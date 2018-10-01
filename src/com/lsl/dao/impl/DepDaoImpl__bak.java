/*
package com.lsl.dao.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lsl.dao.DepDao;
import com.lsl.model.Dep;
import com.lsl.query.DepQuery;

public class DepDaoImpl__bak extends HibernateDaoSupport implements DepDao {
	@Override
	public void saveDep(Dep dep) {
		this.getHibernateTemplate().save(dep);
	}

	@Override
	public void updateDep(Dep dep) {
		this.getHibernateTemplate().update(dep);
	}

	@Override
	public Dep getDepById(Integer depId) {
		return this.getHibernateTemplate().get(Dep.class, depId);
	}

	@Override
	public void deleteDepById(Integer depId) {
		Dep dep = new Dep();
		dep.setDepId(depId);
		this.getHibernateTemplate().delete(dep);
	}

	@Override
	public List<Dep> queryDepByCondition(DepQuery dquery) {
		String hql = "From Dep d where 1=1";
		if(StringUtils.isNotBlank(dquery.getName())){
			hql+=" and d.name like :name";
		}
		if(StringUtils.isNotBlank(dquery.getTel())){
			hql+=" and d.tel like :tel";
		}
		if(dquery.getDepId()!=null){
			hql+=" and d.depId = :depId";
		}
		Session session = this.getSessionFactory().getCurrentSession();
		Query query = session.createQuery(hql);
		setDynamicParam(query,dquery);
		return query.list();
	}
	
	public static void setDynamicParam(Query query,DepQuery dquery){
		Class<? extends DepQuery> class1 = dquery.getClass();
		Field[] fields1 = class1.getDeclaredFields();
		Field[] fields2 = class1.getSuperclass().getDeclaredFields();
		List<Field> list1 = Arrays.asList(fields1);
		List<Field> list2 = Arrays.asList(fields2);
		List<Field> listall = new ArrayList<Field>();
		listall.addAll(list1);
		listall.addAll(list2);
		
		for(Field f:listall){
			String name = f.getName();
			Object val = null;
			try {
				f.setAccessible(true);
				val = f.get(dquery);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
			
			if(val!=null){
				if(val.getClass()==String.class){
					//Ä£ºý²éÑ¯
					query.setParameter(name, "%"+val+"%");
				}else{
					query.setParameter(name, val);
				}
			}
		}
	}
}
 */
