package com.wms.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.common.LoadSpringContext;
import com.wms.dao.ItemsDao;
import com.wms.dao.OrdersHeaderDao;
import com.wms.dao.ReceivingDao;
import com.wms.pojo.Items;
import com.wms.pojo.OrdersDetails;
import com.wms.pojo.OrdersHeader;


@Controller
public class ReceivingController {

	@RequestMapping("/Receive")
	public String indexPage(HttpServletRequest req,Model m){
		System.out.println("From here");

		OrdersHeaderDao dao = (OrdersHeaderDao) LoadSpringContext.getSpringFactory().getBean("ordersheaderdao");

		List<OrdersHeader> list = dao.getOpenPODetails();
		System.out.println("Type list :: "+ list);
		m.addAttribute("polist", list);
		
		ItemsDao dao1 = (ItemsDao) LoadSpringContext.getSpringFactory().getBean("itemsdao");
		List<Items> list1 = dao1.getitems();
		m.addAttribute("itemlist", list1);
		
		return "Receive";
	}
	
	@RequestMapping("/RecieveListInventory")
	public String receiveInventory(HttpServletRequest req,Model m){
		
		String poid = req.getParameter("poid");
		String item = req.getParameter("item");
		String qty = req.getParameter("qty");	
		
		try {
			Double.parseDouble(qty);
		}catch(Exception e) {
			m.addAttribute("error", "Please enter valid qty");
			return "Receive";
		}
		
		OrdersHeaderDao dao1 = (OrdersHeaderDao) LoadSpringContext.getSpringFactory().getBean("ordersheaderdao");
		
		List<OrdersDetails> details = dao1.getOrderDetails(Integer.parseInt(poid));
		
		boolean isMatched = details.stream().anyMatch(detail -> detail.getItem().toString().equals(item));
		System.out.println("Is item matched : "+isMatched);
		if(isMatched) {
			ReceivingDao dao = (ReceivingDao) LoadSpringContext.getSpringFactory().getBean("receivingdao");
			dao.receiveInventory(item, qty);
			
			dao1.updatePOStatus(poid, "COMPLETED");
			return "RecieveListInventory";
		}else {
			m.addAttribute("error", "Please select correct item for the PO.");
			return "Receive";
		}
		
	}
}
