package com.wms.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.common.LoadSpringContext;
import com.wms.dao.ItemsDao;
import com.wms.pojo.Items;

@Controller
public class ItemsController {

	@RequestMapping("/itemslist")	
	public String indexPage(HttpServletRequest req,Model m){
		System.out.println("From here");

		ItemsDao dao = (ItemsDao) LoadSpringContext.getSpringFactory().getBean("itemsdao");

		List<Items> list = dao.getitems();

		m.addAttribute("items", list);
		
		for (Items items : list) {
			System.out.println(items);
		}

		return "itemslist";
	}
	
	@RequestMapping("/listitems")
	public String newItem(HttpServletRequest req,Model m){
		ItemsDao dao = (ItemsDao) LoadSpringContext.getSpringFactory().getBean("itemsdao");

		List<Items> typeList =  dao.itemsDetails();
		System.out.println("Type list :: "+typeList);
		m.addAttribute("itemType", typeList);
		return "ItemsInsert";
}
	@RequestMapping("/additem")
	public String additem(HttpServletRequest req,Model m) throws ParseException{
		ItemsDao dao = (ItemsDao) LoadSpringContext.getSpringFactory().getBean("itemsdao");

		
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		String barcode = req.getParameter("barcode");
		String price = req.getParameter("price");
		String weight = req.getParameter("weight");
		
		
		Items i = new Items();
		
		i.setName(name);
		i.setDescription(description);
		i.setBarcode(barcode);
		
		Double d = Double.parseDouble(price);
		i.setPrice(d);
		
		Double dd = Double.parseDouble(weight);
		i.setWeight(dd);
	
		
		dao.saveitem(i);
		
		List<Items> list = dao.getitems();
		m.addAttribute("items", list);
		
		return "itemslist";
	}
	
	
	@RequestMapping("/newItems")
	public String newItems(HttpServletRequest req,Model m){
		return "ItemsInsert";
	}
	
	@RequestMapping("deleteItem")
	public String deleteItem(HttpServletRequest req, Model m){
		ItemsDao dao = (ItemsDao) LoadSpringContext.getSpringFactory().getBean("itemsdao");

		
		String item_id = req.getParameter("id");
		Integer cid = Integer.parseInt(item_id);
		
		dao.removeitem(cid);
		return "DeleteItem";
		
	}
	@RequestMapping("/editItem")
	public String editItem(HttpServletRequest req, Model m){
		
		String itemId = req.getParameter("id");
		System.out.println(itemId);
		ItemsDao dao = (ItemsDao) LoadSpringContext.getSpringFactory().getBean("itemsdao");

		Items item  = dao.edititemdetails(itemId);
		Integer itm = Integer.parseInt(itemId);
		item.setItemId(itm);
		
		m.addAttribute("listValue", item);
		
		
		Items items = dao.edititemdetails(itemId);
		m.addAttribute("itemTypes", items);
		
		return "ItemsEdit";
		
		
	}
	
	@RequestMapping("/updateItem")
	public String updateItem(HttpServletRequest req,Model m) {
		ItemsDao dao = (ItemsDao) LoadSpringContext.getSpringFactory().getBean("itemsdao");

		String name = req.getParameter("name");
		String description = req.getParameter("description");
		String barcode = req.getParameter("barcode");
		String price = req.getParameter("price");
		String weight = req.getParameter("weight");

		String itemid = req.getParameter("itemId");
		
		System.out.println("id is :: "+ itemid);
		
		Items i = new Items();
		
		i.setItemId(Integer.parseInt(itemid));
		i.setName(name);
		i.setDescription(description);
		i.setBarcode(barcode);
		Double d = Double.parseDouble(price);
		i.setPrice(d);
		
		Double dd = Double.parseDouble(weight);
		i.setWeight(dd);
		   
		dao.updateItem(i);
		   
		   List<Items> list = dao.getitems();
				   
		    m.addAttribute("items", list);
		   
		return "itemslist";
		
		
	}
	@RequestMapping("/viewItem")
	public String viewItem(HttpServletRequest req,Model m){
		String itemId = req.getParameter("id");
		System.out.println(itemId);
		ItemsDao dao = (ItemsDao) LoadSpringContext.getSpringFactory().getBean("itemsdao");

		Items item  = dao.edititemdetails(itemId);
		Integer itm = Integer.parseInt(itemId);
		item.setItemId(itm);
		
		m.addAttribute("listValue", item);
		
		
		Items items = dao.edititemdetails(itemId);
		m.addAttribute("itemTypes", items);
		
		return "ItemsView";
		
	}
}
