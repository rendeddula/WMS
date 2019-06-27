package com.wms.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.springframework.orm.hibernate3.HibernateTemplate;
import com.wms.pojo.WMInventory;

public class WMInventoryDao {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public List<WMInventory> getinventory(){
		
		List<WMInventory> list = new ArrayList<WMInventory>();
		list = hibernateTemplate.loadAll(WMInventory.class);
		return list;
		
	}
	
	public List<Map<String, String>> inventoryDetails(){
		
		String sqlQu = "SELECT available_qty, items.name FROM (wm_inventory LEFT JOIN items ON wm_inventory.item_id = items.item_id);";
		
		SQLQuery query = hibernateTemplate.getSessionFactory().openSession().createSQLQuery(sqlQu);
		
		@SuppressWarnings("unchecked")
		List<Object[]> list = query.list();
		List<Map<String, String>> returnList = new ArrayList<Map<String, String>>();
		for (Object[] row : list) {
			
			Map<String, String> map = new HashMap<String, String>();
			map.put("allocatedQty", row[0]==null?"":row[0].toString());
			map.put("itemName", row[1]==null?"":row[1].toString());
			returnList.add(map);
		}
		
		 return returnList; 
		
	}
}
