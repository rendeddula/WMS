package com.wms.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.wms.pojo.OrdersDetails;
import com.wms.pojo.OrdersHeader;

public class OrdersHeaderDao {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@SuppressWarnings("unchecked")
	public List<OrdersHeader> getorder(){
		
	
		@SuppressWarnings("unused")
		List<OrdersHeader> list = new ArrayList<OrdersHeader>();
		Criteria criteria = hibernateTemplate.getSessionFactory().openSession().createCriteria(OrdersHeader.class);
		criteria.add(Restrictions.eq("ordertype", "PO"));
		return criteria.list();
		
		
	}
	
@SuppressWarnings("unchecked")
		public List<OrdersHeader> getSalesOrder(){
		
		@SuppressWarnings("unused")
		List<OrdersHeader> list = new ArrayList<OrdersHeader>();
		Criteria criteria = hibernateTemplate.getSessionFactory().openSession().createCriteria(OrdersHeader.class);
		criteria.add(Restrictions.eq("ordertype", "SO"));
		return criteria.list();
		
		
	}
	public List<OrdersHeader> orderDetails(){
		
		  List<OrdersHeader> list=new ArrayList<OrdersHeader>();  
		 return list;
		
	}
	
	
	@SuppressWarnings("unchecked")
	public List<OrdersHeader> getOpenPODetails(){
		
		  Criteria criteria = hibernateTemplate.getSessionFactory().openSession().createCriteria(OrdersHeader.class);
			criteria.add(Restrictions.ne("status", "COMPLETED"));
			criteria.add(Restrictions.ne("status", "CANCELLED"));
			criteria.add(Restrictions.eq("ordertype", "PO"));
			
			return criteria.list();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<OrdersHeader> getOpenSODetails(){
		
		  Criteria criteria = hibernateTemplate.getSessionFactory().openSession().createCriteria(OrdersHeader.class);
			criteria.add(Restrictions.eq("status", "CREATED"));
			criteria.add(Restrictions.eq("ordertype", "SO"));
			
			return criteria.list();
		
	}
	
	public void saveorder(OrdersHeader oh){
		hibernateTemplate.save(oh);
				
	}
	
		public void removeorder(int orderid) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		OrdersHeader ordersheader = (OrdersHeader) session.get(OrdersHeader.class, new Integer(orderid));
        if(null != ordersheader){
        	System.out.println("inside delete");
            session.delete(ordersheader);
            session.flush();  
        }
    }
		public OrdersHeader editOrder(String id){
			OrdersHeader orderheader = hibernateTemplate.get(OrdersHeader.class, new Integer(id));
			return orderheader;
			
		}
		
		public void updateOrder(OrdersHeader oh){
			hibernateTemplate.update(oh);
		}
		
		@SuppressWarnings("unchecked")
		public List<OrdersDetails> getOrderDetails(Integer orderId){
			@SuppressWarnings("unused")
			List<OrdersDetails> list = new ArrayList<OrdersDetails>();
			
			Criteria criteria = hibernateTemplate.getSessionFactory().openSession().createCriteria(OrdersDetails.class);
			criteria.add(Restrictions.eq("headerId", orderId));
			return criteria.list();
			
		}
		
		public boolean updatePOStatus(String poId, String status){
			boolean retval = false;
			
			String sqlQu = "UPDATE  order_header SET STATUS = '"+status+"' WHERE ORDER_HEADERID = '"+poId+"'";
			
			SQLQuery query = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sqlQu);
			int affectedRows = query.executeUpdate();
			
			if(affectedRows > 0){
				retval = true;
			}
			
			return retval;
		}
		
		public boolean updateSOStatus(String soId, String status){
			boolean retval = false;
			
			String sql = "UPDATE  order_header SET STATUS = '"+status+"' WHERE ORDER_HEADERID = '"+soId+"'";
			
			SQLQuery query = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql);
			int affectedRows = query.executeUpdate();
			
			if(affectedRows > 0){
				retval = true;
			}
			
			return retval;
		}
}
