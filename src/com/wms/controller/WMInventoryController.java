package com.wms.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.common.LoadSpringContext;
import com.wms.dao.WMInventoryDao;

@Controller
public class WMInventoryController {

	@RequestMapping("/WMInventoryList")
	public String indexPage(HttpServletRequest req,Model m){
		System.out.println("From here");

		WMInventoryDao dao = (WMInventoryDao) LoadSpringContext.getSpringFactory().getBean("wminventorydao");

		List<Map<String, String>> list = dao.inventoryDetails();

		m.addAttribute("wminventory", list);
		
		
		

		return "WMInventoryList";
	}
}
