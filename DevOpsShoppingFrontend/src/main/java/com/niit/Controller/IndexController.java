package com.niit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.DevOpsShoppingBackend.Dao.CategoryDao;
import com.niit.DevOpsShoppingBackend.Dao.SupplierDao;
import com.niit.DevOpsShoppingBackend.Model.Category;
import com.niit.DevOpsShoppingBackend.Model.Supplier;

@Controller

public class IndexController {
	
	@Autowired
	Category category;
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	Supplier supplier;
	
	@Autowired
	SupplierDao supplierDao;
	
	
	@RequestMapping("/")
	public String home()
	{
		return "index";
	}
	
	@RequestMapping("/login")
	public String login()
	{
		return "login";
	}
	
	@RequestMapping("/admin")
	public ModelAndView admin()
	{
		ModelAndView mv= new ModelAndView("admin");
		List<Category> catlist=categoryDao.list();
		List<Supplier> suplist=supplierDao.list();
		mv.addObject("categories", catlist);
		mv.addObject("suppliers", suplist);
		return mv;
		
		
	}
}
