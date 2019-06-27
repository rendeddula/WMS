package com.wms.dao;

import org.hibernate.SQLQuery;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class PackingDao {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public boolean updateWMInventory(Integer qty , String item_id){
		boolean retval = false;
		
		String sql = "UPDATE wm_inventory SET available_qty = available_qty - "+qty+"    WHERE item_id= '"+item_id+"' ";
		
		SQLQuery query = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sql);
		int affectedRows = query.executeUpdate();
		
		if(affectedRows > 0){
			retval = true;
		}
		
		return retval;
	}
	
	public boolean packLPN(String order_headerid, String details_id , String item,Integer quantity,String indicator ){
		boolean retval = false;
		
		String sqlQu = "INSERT INTO lpn(order_headerid, details_id,item,quantity,indicator)"
				+ " VALUES('"+order_headerid+"', '"+details_id+"','"+item+"','"+quantity+"','"+indicator+"')";
		
		
		SQLQuery query = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sqlQu);
		int affectedRows = query.executeUpdate();
		
		if(affectedRows > 0){
			retval = true;
		}
		
		return retval;
	}
}
