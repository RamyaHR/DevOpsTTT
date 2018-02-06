package com.niit.Controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	
	@RequestMapping(value="/savecat", method=RequestMethod.POST)
	public ModelAndView saveCategory(@RequestParam("catId")String catId, @RequestParam("catName")String catName)
	{
		ModelAndView obj= new ModelAndView();
		Category c= new Category();
		c.setCatId(catId);
		c.setCatName(catName);
		categoryDao.insertCat(c);
		obj.setViewName("admin");
		return obj;
	}
	
	@RequestMapping(value="/updatecat", method=RequestMethod.POST)
	public ModelAndView updateCategory(@RequestParam("catId")String catId, @RequestParam("catName")String catName)
	{
		ModelAndView obj= new ModelAndView();
		category.setCatId(catId);
		category.setCatName(catName);
		categoryDao.updateCat(category);
		obj.setViewName("adminlist");
		return obj;
	}
	

	@RequestMapping(value="/savesup", method=RequestMethod.POST)
	public ModelAndView saveSupplier(@RequestParam("supId")String supId, @RequestParam("supName")String supName)
	{
		ModelAndView obj= new ModelAndView();
		Supplier s= new Supplier();
		s.setSupId(supId);
		s.setSupName(supName);
		supplierDao.insertSupp(s);
		obj.setViewName("admin");
		return obj;
	}
	
	@RequestMapping(value="/updatesup", method=RequestMethod.POST)
	public ModelAndView updateSupplier(@RequestParam("supId")String supId, @RequestParam("supName")String supName)
	{
		ModelAndView obj= new ModelAndView();
		supplier.setSupId(supId);
		supplier.setSupName(supName);
		supplierDao.updateSupp(supplier);
		obj.setViewName("adminlist");
		return obj;
	}
	
	@RequestMapping(value="/saveprod", method=RequestMethod.POST)
	public String saveProduct(HttpServletRequest req, @RequestParam("pimage") MultipartFile file)
	{
		Product prod= new Product();
		prod.setProdName(req.getParameter("prodName"));
		prod.setProdPrice(Double.parseDouble(req.getParameter("prodPrice")));
		prod.setProdQuantity(Integer.parseInt(req.getParameter("prodQuantity")));
		prod.setProdDescription(req.getParameter("prodDescription"));
		
		String filepath=req.getSession().getServletContext().getRealPath("/");
		String filename=file.getOriginalFilename();
		prod.setPimage(filename);
		productDao.insertProd(prod);
		
		try
		{
			byte[] imagebyte= file.getBytes();
			BufferedOutputStream fos= new BufferedOutputStream(new FileOutputStream(filepath+"/resources"+filename));
				fos.write(imagebyte);
			fos.close();
		}
		
		catch(Exception e)
		{
			
		}
		return "index";
	}

	
}
