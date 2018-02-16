package com.niit.Controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.DevOpsShoppingBackend.Dao.CategoryDao;
import com.niit.DevOpsShoppingBackend.Dao.ProductDao;
import com.niit.DevOpsShoppingBackend.Dao.SupplierDao;
import com.niit.DevOpsShoppingBackend.Model.Category;
import com.niit.DevOpsShoppingBackend.Model.Product;
import com.niit.DevOpsShoppingBackend.Model.Supplier;
import com.niit.DevOpsShoppingBackend.Model.User;

@Controller
public class AdminController {
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	SupplierDao supplierDao;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	Category category;
	
	@Autowired
	Supplier supplier;
	
	
	@RequestMapping(value="/category")
	public ModelAndView category()
	{
		ModelAndView mv= new ModelAndView();
		mv.setViewName("category");
		return mv;
	}
	
	
	@RequestMapping(value="/savecat", method=RequestMethod.POST)
	public ModelAndView saveCategory(@RequestParam("catName")String catName, @ModelAttribute("user")User user)
	{
		ModelAndView obj= new ModelAndView();
		List<Category> catlist=categoryDao.list();
		List<Supplier> suplist=supplierDao.list();
		obj.addObject("categories", catlist);
		obj.addObject("suppliers", suplist);
		obj.addObject("user", user);
		Category c= new Category();
//		c.setCatId(catId);
		c.setCatName(catName);
		categoryDao.insertCat(c);
		obj.setViewName("admin");
		return obj;
	}
	
	@RequestMapping(value="/updatecat", method=RequestMethod.POST)
	public ModelAndView updateCategory(@RequestParam("catName")String catName, @ModelAttribute("user")User user)
	{
		ModelAndView obj= new ModelAndView();
		obj.addObject("user", user);
		List<Category> catlist=categoryDao.list();
		List<Supplier> suplist=supplierDao.list();
		obj.addObject("categories", catlist);
		obj.addObject("suppliers", suplist);
//		category.setCatId(catId);
		category.setCatName(catName);
		categoryDao.updateCat(category);
		obj.setViewName("adminlist");
		return obj;
	}
	

	@RequestMapping(value="/savesup", method=RequestMethod.POST)
	public ModelAndView saveSupplier(@RequestParam("supName")String supName, @ModelAttribute("user")User user)
	{
		ModelAndView obj= new ModelAndView();
		obj.addObject("user", user);
		List<Category> catlist=categoryDao.list();
		List<Supplier> suplist=supplierDao.list();
		obj.addObject("categories", catlist);
		obj.addObject("suppliers", suplist);
		Supplier s= new Supplier();
//		s.setSupId(supId);
		s.setSupName(supName);
		supplierDao.insertSupp(s);
		obj.setViewName("admin");
		return obj;
	}
	
	@RequestMapping(value="/updatesup", method=RequestMethod.POST)
	public ModelAndView updateSupplier(@RequestParam("supName")String supName, @ModelAttribute("user")User user)
	{
		ModelAndView obj= new ModelAndView();
		obj.addObject("user", user);
		List<Category> catlist=categoryDao.list();
		List<Supplier> suplist=supplierDao.list();
		obj.addObject("categories", catlist);
		obj.addObject("suppliers", suplist);
//		supplier.setSupId(supId);
		supplier.setSupName(supName);
		supplierDao.updateSupp(supplier);
		obj.setViewName("adminlist");
		return obj;
	}
	
	@RequestMapping(value="/saveprod", method=RequestMethod.POST)
	public String saveProduct(HttpServletRequest req, Model model, @RequestParam("pimage") MultipartFile file, @ModelAttribute("user")User user)
	{
		Product prod= new Product();
		category=categoryDao.getCat(req.getParameter("catId"));
		supplier=supplierDao.getSupp(req.getParameter("supId"));
		List<Category> catlist=categoryDao.list();
		List<Supplier> suplist=supplierDao.list();
		model.addAttribute("categories", catlist);
		model.addAttribute("suppliers", suplist);
		model.addAttribute("user", user);
		prod.setProdName(req.getParameter("prodName"));
		prod.setProdPrice(Double.parseDouble(req.getParameter("prodPrice")));
		prod.setProdQuantity(Integer.parseInt(req.getParameter("prodQuantity")));
		prod.setProdDescription(req.getParameter("prodDescription"));
		prod.setCategory(category);
		prod.setSupplier(supplier);
//		prod.setCategory(req.getParameter("category"));
		String filepath=req.getSession().getServletContext().getRealPath("/");
		String filename=file.getOriginalFilename();
		prod.setImagename(filename);
		productDao.insertProd(prod);
		
		try
		{
			byte[] imagebyte= file.getBytes();
			BufferedOutputStream fos= new BufferedOutputStream(new FileOutputStream(filepath+"/resources/"+filename));
				fos.write(imagebyte);
			fos.close();
		}
		
		catch(Exception e)
		{
			
		}
		return "index";
	}

	
	
	@RequestMapping(value="/updateprod/{prodId}")
	public ModelAndView updateProd(@PathVariable("prodId")String prodId, @ModelAttribute("user")User user)
	{
		ModelAndView obj= new ModelAndView();
		obj.addObject("user", user);
		List<Category> catlist=categoryDao.list();
		List<Supplier> suplist=supplierDao.list();
		obj.addObject("categories", catlist);
		obj.addObject("suppliers", suplist);
		Product prod= productDao.getProd(prodId);
		obj.addObject("prod", prod);
		obj.setViewName("redirect:/admin");
		return obj;
	}
	
	
	@RequestMapping(value="/updateproduct", method=RequestMethod.POST)
	public ModelAndView updateProduct(HttpServletRequest req, @RequestParam("pimage") MultipartFile file, 
			@ModelAttribute("user")User user)
	{
		ModelAndView model=new ModelAndView();
		Product prod= new Product();
		category=categoryDao.getCat(req.getParameter("catId"));
		supplier=supplierDao.getSupp(req.getParameter("supId"));
		List<Category> catlist=categoryDao.list();
		List<Supplier> suplist=supplierDao.list();
		model.addObject("categories", catlist);
		model.addObject("suppliers", suplist);
		model.addObject("user", user);
		prod.setProdId(req.getParameter("prodId"));
		prod.setProdName(req.getParameter("prodName"));
//		prod.setProdPrice(req.getParameter("prodPrice"));
		prod.setProdPrice(Double.parseDouble(req.getParameter("prodPrice")));
		prod.setProdQuantity(Integer.parseInt(req.getParameter("prodQuantity")));
		prod.setProdDescription(req.getParameter("prodDescription"));
		prod.setCategory(category);
		prod.setSupplier(supplier);
//		prod.setCategory(req.getParameter("category"));
		String filepath=req.getSession().getServletContext().getRealPath("/");
		String filename=file.getOriginalFilename();
		prod.setImagename(filename);
		model.addObject(prod);
		productDao.updateProd(prod);
		
		try
		{
			byte[] imagebyte= file.getBytes();
			BufferedOutputStream fos= new BufferedOutputStream(new FileOutputStream(filepath+"/resources/"+filename));
				fos.write(imagebyte);
			fos.close();
		}
		
		catch(Exception e)
		{
			
		}
		model.setViewName("redirect:/saveprod");
		return model;
	}

	
	
	@RequestMapping(value="/adminlist", method=RequestMethod.POST)
	public ModelAndView saveCategory(@ModelAttribute("user")User user)
	{
		ModelAndView obj= new ModelAndView();
		List<Category> catlist=categoryDao.list();
		List<Supplier> suplist=supplierDao.list();
		List<Product> prodlist=productDao.list();
		obj.addObject("categories", catlist);
		obj.addObject("suppliers", suplist);
		obj.addObject("products", prodlist);
		obj.addObject("user", user);
		obj.setViewName("admin");
		return obj;
	}
	
	@RequestMapping("/deleteProduct/{prodId}")
	public String deleteProd(@PathVariable("prodId")String prodId)
	{
		productDao.deleteProd(prodId);
		return "redirect:/admin";
	}
	}
	

