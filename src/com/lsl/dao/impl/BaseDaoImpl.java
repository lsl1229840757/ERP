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
		//��t��ѯ����
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
		//������Ϊ�˲���where�����
		String hql = getHql(q);
		Session session = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
		Query query = session.createQuery(hql);	
		//��̬�����ò���
		setDynamicParam(query,q,exclude);
		//��ȡstartIndex
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
	 * @return ��÷��͵���
	 */
	
	@SuppressWarnings("unchecked")
	public Class<T> getGenericClass(){
		//��ø���ĸ���
		Type genericSuperclass = this.getClass().getGenericSuperclass();
		//ǿ��ת��
		ParameterizedType pt = (ParameterizedType) genericSuperclass;
		//��õ�ǰ������з���
		Type[] types = pt.getActualTypeArguments();
		return (Class<T>)types[0];
	}
	
	public void setDynamicParam(Query query,Q q,List<String> exclude){
		//���÷���Ļ���
		Class<?> class1 = q.getClass();
		//��ñ�������Լ�ֵ��
		Field[] fields1 = class1.getDeclaredFields();
		//��ø�������Լ�ֵ��
		Field[] fields2 = class1.getSuperclass().getDeclaredFields();
		List<Field> asList = Arrays.asList(fields1);
		List<Field> asList2 = Arrays.asList(fields2);
		//��ȡ����͸���ļ��ϴ����
		List<Field> flist = new ArrayList<Field>();
		flist.addAll(asList);
		flist.addAll(asList2);
		for(Field f:flist){
			String name = f.getName();
			if(exclude!=null&&exclude.contains(name)){
				//�ų��ڼ����е��ֶ�
				continue;
			}
			Object val = null;
			try {
				//���ñ������䣬����˽�б���
				f.setAccessible(true);
				//�����Ƕ���
				val= f.get(q);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
			if(val!=null){
				if(val.getClass()==String.class){
					/**
					 * ע����������ų����ַ����Ŀ�����
					 */
					if(StringUtils.isNotBlank(val.toString())){
						//ģ����ѯ
						query.setParameter(name, "%"+val+"%");
					}
				}else{
					//��ȷ��ѯ
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
		//��̬�����ò���
		setDynamicParam(query,q,exclude);
		 totalCount = (Long) query.uniqueResult();
		return totalCount;
	}
	
	public List<T> queryObjByConditionNoPage(Q q,List<String> exclude){
		List<T> lists = new ArrayList<T>();
		//������Ϊ�˲���where�����
		String hql = getHql(q);
		Session session = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
		Query query = session.createQuery(hql);	
		//��̬�����ò���
		setDynamicParam(query,q,exclude);
		lists = query.list();
		return lists;
	}
	
}
