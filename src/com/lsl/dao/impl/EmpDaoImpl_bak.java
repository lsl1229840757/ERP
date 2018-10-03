/*package com.lsl.dao.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lsl.dao.EmpDao;
import com.lsl.model.Emp;
import com.lsl.query.EmpQuery;

public class EmpDaoImpl_bak extends HibernateDaoSupport implements EmpDao {

	@Override
	public void saveEmp(Emp emp) {
		this.getHibernateTemplate().save(emp);
	}

	@Override
	public void updateEmp(Emp emp) {
		this.getHibernateTemplate().update(emp);
	}

	@Override
	public Emp getEmpById(Integer empId) {
		return this.getHibernateTemplate().get(Emp.class, empId);
	}

	@Override
	public void deleteEmpById(Integer empId) {
		Emp emp = new Emp();
		emp.setEmpId(empId);
		this.getHibernateTemplate().delete(emp);
	}

	*//**
	 * ������birthday���ֱ�����õ�bug
	 *//*
	@SuppressWarnings("unchecked")
	@Override
	public List<Emp> queryEmpByCondition(EmpQuery equery) {
		*//**
		 * ������ʵ�ֶ�̬��������ϲ�ѯ
		 *//*
		List<Emp> lists = new ArrayList<Emp>();
		//������Ϊ�˲���where�����
		String hql = "From Emp e where 1=1";
		//����ʹ��ģ����ѯ
		if(StringUtils.isNotBlank(equery.getUsername())){
			hql = hql+" and e.username like :username";
		}
		if(StringUtils.isNotBlank(equery.getAddress())){
			hql = hql+" and e.address like :address";
		}
		if(StringUtils.isNotBlank(equery.getEmail())){
			hql = hql+" and e.email like :email";
		}
		if(StringUtils.isNotBlank(equery.getTel())){
			hql = hql+" and e.tel like :tel";
		}
		if(equery.getGender()!=null){
			hql = hql+" and e.gender = :gender";
		}
		if(equery.getStartBirthday()!=null){
			hql = hql+" and e.birthday >= :startBirthday";
		}
		if(equery.getEndBirthday()!=null){
			hql = hql+" and e.birthday <= :endBirthday";
		}
		Session session = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
		
		Query query = session.createQuery(hql);	
		//��̬�����ò���
			*//**
			 * ���ǵ����ַ����Ƚ��鷳,��������һ����̬�Ĳ���
			 *//*
		
		if(StringUtils.isNotBlank(equery.getUsername())){
			query.setString("username","%"+equery.getUsername()+"%");
		}
		if(StringUtils.isNotBlank(equery.getAddress())){
			query.setString("address","%"+equery.getAddress()+"%");
		}
		if(StringUtils.isNotBlank(equery.getEmail())){
			query.setString("email", "%"+equery.getEmail()+"%");
		}
		if(StringUtils.isNotBlank(equery.getTel())){
			query.setString("tel", "%"+equery.getTel()+"%");
		}
		if(equery.getGender()!=null){
			query.setInteger("gender", equery.getGender());
		}
		if(equery.getStartBirthday()!=null){
			query.setDate("startBirthday", equery.getStartBirthday());
		}
		if(equery.getEndBirthday()!=null){
			query.setDate("endBirthday", equery.getEndBirthday());
		}
		
		setDynamicParam(query,equery);
		lists = query.list();
		return lists;
	}
	
	public void setDynamicParam(Query query,EmpQuery equery){
		//���÷���Ļ���
		Class<? extends EmpQuery> class1 = equery.getClass();
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
			Object val = null;
			try {
				//���ñ������䣬����˽�б���
				f.setAccessible(true);
				//�����Ƕ���
				val= f.get(equery);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
			if(val!=null){
				if(val.getClass()==String.class){
					//ģ����ѯ
					query.setParameter(name, "%"+val+"%");
				}else{
					//��ȷ��ѯ
					query.setParameter(name, val);
				}
			}
		}
	}
	
}
*/