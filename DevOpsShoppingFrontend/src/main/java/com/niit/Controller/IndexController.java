package com.niit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.DevOpsShoppingBackend.Dao.CategoryDao;
import com.niit.DevOpsShoppingBackend.Dao.SupplierDao;
import com.niit.DevOpsShoppingBackend.Dao.UserDao;
import com.niit.DevOpsShoppingBackend.Model.Category;
import com.niit.DevOpsShoppingBackend.Model.Supplier;
import com.niit.DevOpsShoppingBackend.Model.User;

@Controller

public class IndexController {
	
	@Autowired
	Category category;
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	User user;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	Supplier supplier;
	
	@Autowired
	SupplierDao supplierDao;
	
	
		
	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
	public ModelAndView welcomePage(@ModelAttribute("user")User user) {

		ModelAndView model = new ModelAndView();
		model.addObject("user", user);
		model.setViewName("index");
		return model;

	}
	
	@RequestMapping(value = { "/userLogged"})
	public ModelAndView UserLoggedpage(@ModelAttribute("user")User user) {

		ModelAndView model = new ModelAndView();
		model.addObject("user", user);
		model.addObject("login","User has succcessfully looged in!!!");
		model.setViewName("index");
		return model;

	}
	
	@RequestMapping(value = { "/error"})
	public ModelAndView ErrorLoginpage(@ModelAttribute("user")User user) {

		ModelAndView model = new ModelAndView();
		model.addObject("user", user);
		model.addObject("error","Please enter the valid credentials!!!");
		model.setViewName("index");
		return model;

	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView adminPage(@ModelAttribute("user")User user) {

		ModelAndView model = new ModelAndView();
		List<Category> catlist=categoryDao.list();
		List<Supplier> suplist=supplierDao.list();
		model.addObject("user", user);
		model.addObject("categories", catlist);
		model.addObject("suppliers", suplist);
		model.addObject("title", "Spring Security Custom Login Form");
		model.addObject("message", "This is protected page!");
		model.setViewName("admin");

		return model;

	}

	//Spring Security see this :
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
//		@RequestParam(value = "logout", required = false) String logout) {
//
//		ModelAndView model = new ModelAndView();
//		if (error != null) {
//			model.addObject("error", "Invalid username and password!");
//		}
//
//		if (logout != null) {
//			model.addObject("msg", "You've been logged out successfully.");
//		}
//		model.setViewName("index");
//
//		return model;
//
//	}
	
	@RequestMapping(value="/saveuser", method=RequestMethod.POST)
	public ModelAndView saveuser(@ModelAttribute("user")User user)
	{
		ModelAndView mv= new ModelAndView();
		user.setRolename("ROLE_USER");
		userDao.insertUser(user);
		mv.setViewName("index");
		return mv;
	}
	

}
