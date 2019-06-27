package com.wms.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;
import com.wms.pojo.WMInventory;

public class ReceivingDao {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
		
	public List<WMInventory> getwminventory(){
		
		List<WMInventory> list = new ArrayList<WMInventory>();
		list = hibernateTemplate.loadAll(WMInventory.class);
		return list;
		
	}
	
	public boolean receiveInventory(String itemId, String qty){
		boolean retval = false;
		
		Criteria criteria = hibernateTemplate.getSessionFactory().openSession().createCriteria(WMInventory.class);
		criteria.add(Restrictions.eq("itemId", Integer.parseInt(itemId)));
		List ls = criteria.list();
		
		String sqlQu = "INSERT INTO wm_inventory(ITEM_ID, AVAILABLE_QTY) VALUES('"+itemId+"', '"+qty+"')";
		if(ls!=null && ls.size() > 0){
			System.out.println("Updating inventory");
			WMInventory inv = (WMInventory) ls.get(0);
			Double val = Double.parseDouble(inv.getAvailableqty())+Double.parseDouble(qty);
			inv.setAvailableqty(val.toString());
			
			sqlQu = "UPDATE wm_inventory SET  AVAILABLE_QTY = '"+val+"' WHERE ITEM_ID = '"+itemId+"' ";

		}
		SQLQuery query = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sqlQu);
		int affectedRows = query.executeUpdate();
		
		if(affectedRows > 0){
			retval = true;
		}
		
		return retval;
	}
	
}
