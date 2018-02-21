package com.niit.Controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
public class ProductController {

	@Autowired
	Product product;
	@Autowired
	ProductDao productDao;
	@Autowired
	Category category;
	@Autowired
	CategoryDao categoryDao;
	@Autowired
	Supplier supplier;
	@Autowired
	SupplierDao supplierDao;
	
	@RequestMapping("/product")
	public ModelAndView productform() 
	{
		List<Product> listproduct=productDao.list();
		List<Category> listcategory=categoryDao.list();
		List<Supplier> listsupplier=supplierDao.list();
		ModelAndView obj = new ModelAndView("addproduct");
		obj.addObject("product", new Product());
		obj.addObject("products",listproduct);
		obj.addObject("categories", listcategory);
		obj.addObject("suppliers", listsupplier);
		
		return obj;
	}

	@RequestMapping(value="/addproduct", method=RequestMethod.POST)
	public ModelAndView addproduct(HttpServletRequest req, @ModelAttribute("product")Product product, @RequestParam("pimage") MultipartFile file, @ModelAttribute("user")User user) {
		ModelAndView obj = new ModelAndView("redirect:/admin");
		String filepath=req.getSession().getServletContext().getRealPath("/");
		String filename=file.getOriginalFilename();
		product.setImagename(filename);
				productDao.saveorupdateProd(product);
		
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
		return obj;
	}
	@RequestMapping("/editproduct/{prodId}")
	public ModelAndView edit(@ModelAttribute("user")User user, @PathVariable("prodId")String id)
	{
		System.out.println(123);
		List<Category> listcategory=categoryDao.list();
		List<Supplier> listsupplier=supplierDao.list();
		List<Product>listproduct=productDao.list();
		ModelAndView obj = new ModelAndView("admin");
		product=productDao.getProd(id);
		obj.addObject("user", user);
		obj.addObject("categories", listcategory);
		obj.addObject("suppliers", listsupplier);
		obj.addObject("products",listproduct);
		obj.addObject("product",product);
		return obj;
		
	}
}
