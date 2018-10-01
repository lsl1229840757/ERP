package com.lsl.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.lsl.dao.EmpDao;
import com.lsl.model.Emp;
import com.lsl.query.EmpQuery;

public class EmpDaoImpl extends BaseDaoImpl<Emp, EmpQuery> implements EmpDao {

	@Override
	public String getHql(EmpQuery q) {
		String hql = "From Emp e where 1=1";
		hql = createHqlCondition(hql, q) + " order by e.empId desc";
		return hql;
	}

	@Override
	public String getHqlCount(EmpQuery q) {
		String hql = "select count(e.empId) from Emp e where 1=1";
		hql = createHqlCondition(hql, q);
		return hql;
	}

	@Override
	public String createHqlCondition(String hql, EmpQuery q) {
		// 这里使用模糊查询
		if (StringUtils.isNotBlank(q.getUsername())) {
			hql = hql + " and e.username like :username";
		}
		if (StringUtils.isNotBlank(q.getAddress())) {
			hql = hql + " and e.address like :address";
		}
		if (StringUtils.isNotBlank(q.getEmail())) {
			hql = hql + " and e.email like :email";
		}
		if (StringUtils.isNotBlank(q.getTel())) {
			hql = hql + " and e.tel like :tel";
		}
		if (q.getGender() != null) {
			hql = hql + " and e.gender = :gender";
		}
		if (q.getStartBirthday() != null) {
			hql = hql + " and e.birthday >= :startBirthday";
		}
		if (q.getEndBirthday() != null) {
			hql = hql + " and e.birthday <= :endBirthday";
		}
		if (q.getDepId() != null) {
			hql = hql + " and e.dep.depId = :depId";
		}
		return hql;
	}

	@Override
	public Emp getEmpByUsername(String username) {
		//Emp emp = this.getHibernateTemplate().get(Emp.class, username);，这里会出现找不到情况，因为emp的主键是empId
		/*String hql = "from Emp e where e.username ="+username;这里不能直接构造hql，字符串要加上单引号*/
		String hql = "from Emp e where e.username = ?";
		List<?> list = (List<?>) this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql).setString(0, username).list();
		if(list.size()!=0){
			return (Emp) list.get(0);
		}
		return null;
	}

}
