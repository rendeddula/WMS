package com.wms.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import com.wms.pojo.OrdersDetails;


public class OrdersDetailsDao {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
		public List<OrdersDetails> getorderdetails(){
		
		List<OrdersDetails> list = new ArrayList<OrdersDetails>();
		list = hibernateTemplate.loadAll(OrdersDetails.class);
		return list;
		
	}
}
