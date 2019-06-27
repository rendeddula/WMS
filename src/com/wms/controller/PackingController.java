package com.wms.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.common.LoadSpringContext;
import com.wms.dao.OrdersHeaderDao;
import com.wms.dao.PackingDao;
import com.wms.pojo.OrdersDetails;
import com.wms.pojo.OrdersHeader;

@Controller
public class PackingController {

	@RequestMapping("/Packing")
	public String indexPage(HttpServletRequest req,Model m){
		System.out.println("From here");

		OrdersHeaderDao dao = (OrdersHeaderDao) LoadSpringContext.getSpringFactory().getBean("ordersheaderdao");

		List<OrdersHeader> list = dao.getOpenSODetails();
		System.out.println("Type list :: "+ list);
		m.addAttribute("solist", list);
		
				return "Packing";
	}
	
	@RequestMapping("/PackingListInventory")
	public String packingInventory(HttpServletRequest req,Model m){
		
		String soid = req.getParameter("soid");
		System.out.println("soid :: "+ soid);
				String ss = "PACKED";
		OrdersHeaderDao dao = (OrdersHeaderDao) LoadSpringContext.getSpringFactory().getBean("ordersheaderdao");
		
		OrdersDetails detail = dao.getOrderDetails(Integer.parseInt(soid)).get(0);
		
		String item = detail.getItem();
		Integer qty= Integer.parseInt(detail.getQuantity().trim());
		System.out.println("Item : "+item);
		System.out.println("qty : "+qty);
		dao.updateSOStatus(soid, ss);
		//Create lpn
		
		String order_headerid = soid;
		String details_id = detail.getDetailsId().toString();
	
		
		String indicator = "outbound";
		
		PackingDao pdao = (PackingDao) LoadSpringContext.getSpringFactory().getBean("packingdao");
		pdao.packLPN(order_headerid, details_id, item, qty, indicator);
		//update wm_inventory available qty
		pdao.updateWMInventory(qty, item);
		
		return "PackingListInventory";
		
	}
}
