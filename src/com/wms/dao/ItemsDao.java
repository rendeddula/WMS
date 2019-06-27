package com.wms.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.wms.pojo.Items;

public class ItemsDao {

	private HibernateTemplate hibernateTemplate;
	
	@SuppressWarnings("unused")
	private HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void saveitem(Items i){
		hibernateTemplate.save(i);
				
	}
	
	public List<Items> getitems(){
	
		List<Items> list = new ArrayList<Items>();
		list = hibernateTemplate.loadAll(Items.class);
		return list;
		
	}
	public List<Items> itemsDetails(){
		
		  List<Items> list=new ArrayList<Items>();  
		 return list;
		
	}
		public void removeitem(int itemid) {
		
		Session session = hibernateTemplate.getSessionFactory().openSession();
		
		Items item = (Items) session.get(Items.class, new Integer(itemid));
        if(null != item){
        	System.out.println("inside delete");
            session.delete(item);
            session.flush();  
        }
    }
		
		public Items edititemdetails(String id){
			Items items = hibernateTemplate.get(Items.class, new Integer(id));
			return items;
		}
		
		public void updateItem(Items i){
			hibernateTemplate.update(i);
		}
		
}
