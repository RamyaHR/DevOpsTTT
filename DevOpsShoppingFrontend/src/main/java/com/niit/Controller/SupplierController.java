package com.niit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.DevOpsShoppingBackend.Dao.SupplierDao;
import com.niit.DevOpsShoppingBackend.Model.Supplier;


@Controller
public class SupplierController {
	@Autowired
	Supplier supplier;
	@Autowired
	SupplierDao supplierDao;
	
	@RequestMapping("/supplier")
	public ModelAndView supplierform() 
	{
		ModelAndView obj = new ModelAndView("addsupplier");
		obj.addObject("supplier", new Supplier());
		return obj;
	}

	@RequestMapping(value="/addsupplier", method=RequestMethod.POST)
	public ModelAndView addsupplier(@ModelAttribute("supplier")Supplier supplier ) 
	{
		ModelAndView obj = new ModelAndView("redirect:/supplier");
		if(supplierDao.insertSupp(supplier))
		{
	       obj.addObject("msg","supplier is added successfuly");  		
		}
		else
		{
			obj.addObject("msg","Sorry");
		}
		return obj;
	}
	@RequestMapping("/editsupplier/{supId}")
	public ModelAndView edit(@PathVariable("supId")String id)
	{
		ModelAndView obj = new ModelAndView("addsupplier");
		supplier=supplierDao.getSupp(id);
		obj.addObject("supplier",supplier);
		return obj;
		
	}
	@RequestMapping("/deletesupplier/{supId}")
	public ModelAndView deletesupplier(@PathVariable("supId")String SupId)
	{
		ModelAndView obj=new ModelAndView("redirect:/supplier");
		supplier=supplierDao.getSupp(SupId);
				return obj;
	}
}


