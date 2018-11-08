package com.lsl.dao.impl;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lsl.dao.BaseDao;

public abstract class BaseDaoImpl<T,Q> extends HibernateDaoSupport implements BaseDao<T, Q> {

	@Override
	public void saveObj(T t) {
		this.getHibernateTemplate().save(t);
	}

	@Override
	public void updateObj(T t) {
		this.getHibernateTemplate().update(t);
	}

	@Override
	public T getObjById(Integer id) {
		Class<T> entityClass =  getGenericClass();
		return this.getHibernateTemplate().get(entityClass, id);
	}

	@Override
	public void deleteObjById(Integer id) {
		//把t查询出来
		T t = getObjById(id);
		this.getHibernateTemplate().delete(t);
	}

	@Override
	public void deleteObj(T t) {
		this.getHibernateTemplate().delete(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> queryObjByCondition(Q q,List<String> exclude) {
		List<T> lists = new ArrayList<T>();
		//这里是为了不让where多出来
		String hql = getHql(q);
		Session session = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
		Query query = session.createQuery(hql);	
		//动态地设置参数
		setDynamicParam(query,q,exclude);
		//获取startIndex
		Class<? extends Object> class1 = q.getClass();
		Integer startIndex = 0;
		try {
			Field field = class1.getDeclaredField("startIndex");
			field.setAccessible(true);
			startIndex = (Integer) field.get(q);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		lists = query.setFirstResult(startIndex).setMaxResults(5).list();
		return lists;
	}

	/**
	 * @return 获得泛型的类
	 */
	
	@SuppressWarnings("unchecked")
	public Class<T> getGenericClass(){
		//获得该类的父类
		Type genericSuperclass = this.getClass().getGenericSuperclass();
		//强制转换
		ParameterizedType pt = (ParameterizedType) genericSuperclass;
		//获得当前类的所有泛型
		Type[] types = pt.getActualTypeArguments();
		return (Class<T>)types[0];
	}
	
	public void setDynamicParam(Query query,Q q,List<String> exclude){
		//利用反射的机制
		Class<?> class1 = q.getClass();
		//获得本类的属性键值对
		Field[] fields1 = class1.getDeclaredFields();
		//获得父类的属性键值对
		Field[] fields2 = class1.getSuperclass().getDeclaredFields();
		List<Field> asList = Arrays.asList(fields1);
		List<Field> asList2 = Arrays.asList(fields2);
		//获取子类和父类的集合大对象
		List<Field> flist = new ArrayList<Field>();
		flist.addAll(asList);
		flist.addAll(asList2);
		for(Field f:flist){
			String name = f.getName();
			if(exclude!=null&&exclude.contains(name)){
				//排除在集合中的字段
				continue;
			}
			Object val = null;
			try {
				//设置暴力反射，访问私有变量
				f.setAccessible(true);
				//这里是对象
				val= f.get(q);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
			if(val!=null){
				if(val.getClass()==String.class){
					/**
					 * 注意这里必须排除空字符串的可能性
					 */
					if(StringUtils.isNotBlank(val.toString())){
						//模糊查询
						query.setParameter(name, "%"+val+"%");
					}
				}else{
					//精确查询
					query.setParameter(name, val);
				}
			}
		}
	}
	
	public abstract String getHql(Q q);
	
	public abstract String getHqlCount(Q q);
	
	public abstract String createHqlCondition(String hql,Q q);
	
	@Override
	public List<T> list(){
		String hql = "from "+getGenericClass().getName();
		return this.getHibernateTemplate().find(hql);
	}
	
	@Override
	public Long queryObjCountByCondition(Q q,List<String> exclude){
		Long totalCount = 0L;
		String hql = getHqlCount(q);
		Session session = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
		Query query = session.createQuery(hql);	
		//动态地设置参数
		setDynamicParam(query,q,exclude);
		 totalCount = (Long) query.uniqueResult();
		return totalCount;
	}
	
	public List<T> queryObjByConditionNoPage(Q q,List<String> exclude){
		List<T> lists = new ArrayList<T>();
		//这里是为了不让where多出来
		String hql = getHql(q);
		Session session = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
		Query query = session.createQuery(hql);	
		//动态地设置参数
		setDynamicParam(query,q,exclude);
		lists = query.list();
		return lists;
	}
	
}
