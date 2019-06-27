package com.wms.controller;

import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.common.LoadSpringContext;
import com.wms.dao.ItemsDao;
import com.wms.dao.OrdersHeaderDao;
import com.wms.pojo.Items;
import com.wms.pojo.OrdersDetails;
import com.wms.pojo.OrdersHeader;

@Controller
public class OrdersHeaderController {

	@RequestMapping("/OrdersHeaderList")
	public String indexPage(HttpServletRequest req,Model m){
		System.out.println("From here");

		OrdersHeaderDao dao = (OrdersHeaderDao) LoadSpringContext.getSpringFactory().getBean("ordersheaderdao");

		List<OrdersHeader> list = dao.getorder();

		m.addAttribute("ordersheader", list);
		
		for (OrdersHeader ordersheader : list) {
			System.out.println(ordersheader);
		}

		return "OrdersHeaderList";
	}
	@RequestMapping("/listOrders")
	public String newOrder(HttpServletRequest req,Model m){
		OrdersHeaderDao dao = (OrdersHeaderDao) LoadSpringContext.getSpringFactory().getBean("ordersheaderdao");

		List<OrdersHeader> list = dao.orderDetails();
		System.out.println("Type list :: "+ list);
		m.addAttribute("orderType", list);
		return "OrdersHeaderInsert";
	}
	
	@RequestMapping("/addorder")
	public String addorder(HttpServletRequest req,Model m) throws ParseException{
		OrdersHeaderDao dao = (OrdersHeaderDao) LoadSpringContext.getSpringFactory().getBean("ordersheaderdao");

		
		String ordername = req.getParameter("ordername");
		String ordertype = "PO";
		String shippingaddress = req.getParameter("shippingaddress");
		String destname = req.getParameter("destname");
		String destaddress = req.getParameter("destaddress");
		String destcity = req.getParameter("destcity");
		String deststate = req.getParameter("deststate");
		String destcountry = req.getParameter("destcountry");
		String pincode = req.getParameter("pincode");
		String status = "CREATED";
		
				
		String item = req.getParameter("item");
		String quantity = req.getParameter("quantity");
		String packedquantity = req.getParameter("packedquantity");
		String status1 = req.getParameter("status");
		
		OrdersDetails detail = new OrdersDetails();
		detail.setItem(item);
		detail.setQuantity(quantity);
		detail.setPackedquantity(packedquantity);
		detail.setStatus(status1);
		
		
		Set<OrdersDetails> details = new HashSet<OrdersDetails>();
		
		details.add(detail);
		
		OrdersHeader oh = new OrdersHeader();
		
		oh.setOrdername(ordername);
		oh.setOrdertype(ordertype);
		oh.setShippingaddress(shippingaddress);
		oh.setDestname(destname);
		oh.setDestaddress(destaddress);
		oh.setDestcity(destcity);
		oh.setDeststate(deststate);
		oh.setDestcountry(destcountry);
		oh.setPincode(pincode);
		oh.setStatus(status);
		oh.setDetails(details);
		
		oh.setDetails(details);
		
		dao.saveorder(oh);
		
		List<OrdersHeader> list = dao.getorder();
		m.addAttribute("ordersheader", list);
		
		return "OrdersHeaderList";
	}
	
	@RequestMapping("/newOrders")
	public String newOrders(HttpServletRequest req,Model m){
		
		ItemsDao dao = (ItemsDao) LoadSpringContext.getSpringFactory().getBean("itemsdao");

		List<Items> list = dao.getitems();

		m.addAttribute("itemlist", list);
		
		return "OrdersHeaderInsert";
	}
	
	@RequestMapping("deleteOrder")
	public String deleteOrder(HttpServletRequest req, Model m){
		OrdersHeaderDao dao = (OrdersHeaderDao) LoadSpringContext.getSpringFactory().getBean("ordersheaderdao");

		String orderHeaderId = req.getParameter("id");
		Integer ohid = Integer.parseInt(orderHeaderId);
		
		dao.removeorder(ohid);
		return "OrdersHeaderDelete";
		
	}
	
	@RequestMapping("/editOrder")
	public String editOrder(HttpServletRequest req, Model m){
		
		String orderHeaderId = req.getParameter("id");
		System.out.println(orderHeaderId);
		OrdersHeaderDao dao = (OrdersHeaderDao) LoadSpringContext.getSpringFactory().getBean("ordersheaderdao");

		OrdersHeader orderheader  = dao.editOrder(orderHeaderId);
		Integer order = Integer.parseInt(orderHeaderId);
		orderheader.setOrderHeaderId(order);
		
		m.addAttribute("listValue", orderheader);
		
		
		OrdersHeader ordersheader  = dao.editOrder(orderHeaderId);
		m.addAttribute("itemTypes", ordersheader);
		
		return "OrdersHeaderEdit";
		
		
	}
	
	@RequestMapping("/updateOrder")
	public String updateOrder(HttpServletRequest req,Model m) {
		OrdersHeaderDao dao = (OrdersHeaderDao) LoadSpringContext.getSpringFactory().getBean("ordersheaderdao");

		String ordername = req.getParameter("ordername");
		String ordertype = req.getParameter("ordertype");
		String shippingaddress = req.getParameter("shippingaddress");
		String destname = req.getParameter("destname");
		String destaddress = req.getParameter("destaddress");
		String destcity = req.getParameter("destcity");
		String deststate = req.getParameter("deststate");
		String destcountry = req.getParameter("destcountry");
		String pincode = req.getParameter("pincode");
		String status = req.getParameter("status");
		
		String orderheaderid = req.getParameter("orderHeaderId");
		
		System.out.println("id is :: "+ orderheaderid);
		
		OrdersHeader oh = new OrdersHeader();
		
		oh.setOrderHeaderId(Integer.parseInt(orderheaderid));
		
		oh.setOrdername(ordername);
		oh.setOrdertype(ordertype);
		oh.setShippingaddress(shippingaddress);
		oh.setDestname(destname);
		oh.setDestaddress(destaddress);
		oh.setDestcity(destcity);
		oh.setDeststate(deststate);
		oh.setDestcountry(destcountry);
		oh.setPincode(pincode);
		oh.setStatus(status);
		
		   
		dao.updateOrder(oh);
		   
		List<OrdersHeader> list = dao.getorder();
		m.addAttribute("ordersheader", list);
		
		return "OrdersHeaderList";
		
		
	}
	
	@RequestMapping("/viewOrder")
	public String viewOrder(HttpServletRequest req,Model m){
		String orderHeaderId = req.getParameter("id");
		System.out.println(orderHeaderId);
		OrdersHeaderDao dao = (OrdersHeaderDao) LoadSpringContext.getSpringFactory().getBean("ordersheaderdao");

		OrdersHeader orderheader  = dao.editOrder(orderHeaderId);
		
		List<OrdersDetails> details = dao.getOrderDetails(orderheader.getOrderHeaderId());
		m.addAttribute("orderdetails", details);
		System.out.println("orderdetails : "+details);
		m.addAttribute("listValue", orderheader);
		
		OrdersHeader ordersheader  = dao.editOrder(orderHeaderId);
		m.addAttribute("itemTypes", ordersheader);
		
		return "OrdersHeaderView";
		
	}
	
	
}
