package com.niit.Controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.DevOpsShoppingBackend.Dao.CartDao;
import com.niit.DevOpsShoppingBackend.Dao.CategoryDao;
import com.niit.DevOpsShoppingBackend.Dao.OrderDao;
import com.niit.DevOpsShoppingBackend.Dao.ProductDao;
import com.niit.DevOpsShoppingBackend.Dao.SupplierDao;
import com.niit.DevOpsShoppingBackend.Dao.UserDao;
import com.niit.DevOpsShoppingBackend.Model.Cart;
import com.niit.DevOpsShoppingBackend.Model.Order;
import com.niit.DevOpsShoppingBackend.Model.Product;
import com.niit.DevOpsShoppingBackend.Model.User;

@Controller
public class CartController {

	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	OrderDao orderDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	SupplierDao supplierDao;
	
	@Autowired
	CartDao cartDao;
	
	
	@RequestMapping(value="/prodDetails/{catId}")
	public ModelAndView productDetails(@PathVariable("catId") String catId)
	{
		ModelAndView mv= new ModelAndView();
		Product prod= productDao.getProdByCatId(catId);
		mv.addObject("product", prod);
		mv.setViewName("productdetails");
		return mv;
	}
	
	
	@RequestMapping(value="/addToCart", method=RequestMethod.POST)
	public ModelAndView addtocart(@ModelAttribute("user")User user,HttpServletRequest req)
	{
		ModelAndView mv= new ModelAndView();
		mv.addObject("user", user);
		Principal princi=req.getUserPrincipal();
		String email=princi.getName();
		
		try
		{
			String prodId=req.getParameter("prodId");
			Double price= Double.parseDouble(req.getParameter("prodPrice"));
			int qty=Integer.parseInt(req.getParameter("prodQuantity"));
			String prodName=req.getParameter("prodName");
			String imgname= req.getParameter("imagename");
			Cart cart=cartDao.getCartById(prodId, email);
			if (cart==null)
			{
				Cart c=new Cart();
				c.setCartPrice(price);
				c.setCartProductId(prodId);
				c.setCartQuantity(qty);
				c.setCartImage(imgname);
				c.setCartProductName(prodName);
				
				User u= userDao.get(email);
				c.setUser(u);
				cartDao.insertCart(c);
			}
			else
				if(cart!=null)
				{
					Cart c=new Cart();
					c.setCartId(cart.getCartId());
					c.setCartPrice(price);
					c.setCartProductId(prodId);
					c.setCartQuantity(qty);
					c.setCartImage(imgname);
					c.setCartProductName(prodName);
					
					User u= userDao.get(email);
					c.setUser(u);
					cartDao.updateCart(c);			
			}
			mv.addObject("cartInfo", cartDao.findCartById(email));
			mv.setViewName("cart");
			return mv;
		}
		catch(Exception e)
		{
			mv.addObject("cartInfo", cartDao.findCartById(email));
			mv.setViewName("cart");
			return mv;
		}
		
	}
	
	@RequestMapping(value="/invoiceProcess", method=RequestMethod.POST)
	public ModelAndView orderSave(HttpServletRequest req)
	{
		ModelAndView mv= new ModelAndView("invoice");
		Order order= new Order();
		Principal principal= req.getUserPrincipal();
		String email=principal.getName();
		Double total= Double.parseDouble(req.getParameter("total"));
		String payment= req.getParameter("payment");
		User user= userDao.get(email);
		order.setUser(user);
		order.setTotal(total);
		order.setPayment(payment);
		orderDao.insertOrder(order);
		mv.addObject("orderDetails", user);
		return mv;
	}
	
	
	@RequestMapping(value="/checkout", method=RequestMethod.GET)
	public ModelAndView checkoutprocess(HttpServletRequest req)
	{
		ModelAndView mv= new ModelAndView("checkout");
		Principal pri= req.getUserPrincipal();
		String email= pri.getName();
		User user= userDao.get(email);
		List<Cart> cart= cartDao.findCartById(email);
		mv.addObject("user", user);
		mv.addObject("cart", cart);
		return mv;
	}
	
	@RequestMapping(value="/deleteCart/{cartId}")
	public ModelAndView deleteCartItems(@PathVariable("cartId")String cartId, HttpServletRequest req)
	{
		ModelAndView mv= new ModelAndView();
		Principal p= req.getUserPrincipal();
		String email= p.getName();
		mv.addObject("cartInfo", cartDao.findCartById(email));
		mv.setViewName("cart");
		return mv;
	}
	
	
	@RequestMapping(value="/gotoCart", method=RequestMethod.GET)
	public ModelAndView gotocart(@ModelAttribute("user")User user,HttpServletRequest req)
	{
		ModelAndView mv=new ModelAndView();
		mv.addObject("user", user);
		Principal p= req.getUserPrincipal();
		String email= p.getName();
		mv.addObject("cartInfo", cartDao.findCartById(email));
		
		mv.setViewName("cart");
		return mv;
	}
}
