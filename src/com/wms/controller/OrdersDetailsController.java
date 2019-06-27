package com.wms.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.common.LoadSpringContext;
import com.wms.dao.OrdersDetailsDao;
import com.wms.pojo.OrdersDetails;


@Controller
public class OrdersDetailsController {

	@RequestMapping("/OrdersDetailsList")
	public String indexPage(HttpServletRequest req,Model m){
		System.out.println("From here");

		OrdersDetailsDao dao = (OrdersDetailsDao) LoadSpringContext.getSpringFactory().getBean("ordersdetailsdao");

		List<OrdersDetails> list = dao.getorderdetails();
		m.addAttribute("orderdetails", list);
		
		for (OrdersDetails orderdetails : list) {
			System.out.println(orderdetails);
		}

		return "OrdersDetailsList";
	}
	
}
