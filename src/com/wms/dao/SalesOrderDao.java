package com.wms.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import com.wms.pojo.OrdersHeader;


public class SalesOrderDao {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@SuppressWarnings("unchecked")
	public List<OrdersHeader> getsalesorder(){
		
		
		@SuppressWarnings("unused")
		List<OrdersHeader> list = new ArrayList<OrdersHeader>();
		Criteria criteria = hibernateTemplate.getSessionFactory().openSession().createCriteria(OrdersHeader.class);
		criteria.add(Restrictions.eq("ordertype", "SO"));
		return criteria.list();
		
		
	}
}
