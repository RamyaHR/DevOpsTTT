package com.niit.Controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.DevOpsShoppingBackend.Dao.CartDao;
import com.niit.DevOpsShoppingBackend.Dao.CartItemsDao;
import com.niit.DevOpsShoppingBackend.Dao.CategoryDao;
import com.niit.DevOpsShoppingBackend.Dao.OrderDao;
import com.niit.DevOpsShoppingBackend.Dao.ProductDao;
import com.niit.DevOpsShoppingBackend.Dao.SupplierDao;
import com.niit.DevOpsShoppingBackend.Dao.UserDao;
import com.niit.DevOpsShoppingBackend.Model.Cart;
import com.niit.DevOpsShoppingBackend.Model.CartItems;
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
	Cart cart;
	
	@Autowired
	CartItems cartItems;
	
	@Autowired
	CartDao cartDao;
	
	@Autowired
	CartItemsDao cartItemsDao;
	
	
	@RequestMapping(value="/prodDetails/{catId}")
	public ModelAndView productDetails(@PathVariable("catId") String catId)
	{
		ModelAndView mv= new ModelAndView();
		Product prod= productDao.getProdByCatId(catId);
		mv.addObject("product", prod);
		mv.setViewName("productdetails");
		return mv;
	}
	
	
	@RequestMapping(value="/addToCart/{prodId}", method=RequestMethod.POST)
	public ModelAndView addtocart(@PathVariable("prodId")String prodId, @ModelAttribute("user")User user,HttpSession session, HttpServletRequest req)
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currusername = authentication.getName();
	User u = userDao.getMail(currusername);
	if (user == null)
	{
		return new ModelAndView("redirect:/");
	} 
	else
	{
		cart = u.getCart();
		Product product1 = productDao.getProd(prodId);
		CartItems cartItem = new CartItems();
		cartItem.setCart(cart);
		cartItem.setProduct(product1);
		cartItem.setCartPrice(product1.getProdPrice());
		cartItem.setCartImage(product1.getImagename());
		cartItemsDao.saveorupdateCartItems(cartItem);
		cart.setGrandtotal(cart.getGrandtotal() + product1.getProdPrice());
		cart.setTotalitem(cart.getTotalitem() + 1);
		cartDao.saveorupdateCart(cart);
		session.setAttribute("items", cart.getTotalitem());
		session.setAttribute("gd", cart.getGrandtotal());
		return new ModelAndView("redirect:/");
		}
		}
		else {
			return new ModelAndView("redirect:/");
		}
	}
			
		
//			Cart cart=new Cart();
//			Product product1 = productDao.getProd(prodId);
//			CartItems cartItem = new CartItems();
//			cartItem.setCart(cart);
//			cartItem.setCartPrice(product1.getProdPrice());
//			cartItem.setCartProductId(prodId);
//			cartItem.setCartQuantity(product1.getProdQuantity());
//			cartItem.setCartImage(product1.getImagename());
//			cartItem.setCartProductName(product1.getProdName());
//			cartItemsDao.updateCartItems(cartItem);
//			cart.setGrandtotal(cart.getGrandtotal() + product1.getProdPrice());
//			cart.setTotalitem(cart.getTotalitem() + 1);
//			cartDao.updateCart(cart);
//			session.setAttribute("items", cart.getTotalitem());
//			session.setAttribute("gd", cart.getGrandtotal());
////			List<Cart> list= cartDao.findCartById(email);
////			mv.addObject("cartitems", list);
//			return new ModelAndView("redirect:/");
			
//			Product product1 = productDao.getProd(prodId);
//				CartItems c=new CartItems();
//				c.setCartPrice(product1.getProdPrice());
//				c.setCartProductId(prodId);
//				c.setCartQuantity(product1.getProdQuantity());
//				c.setCartImage(product1.getImagename());
//				c.setCartProductName(product1.getProdName());
//				User u= userDao.getMail(email);
//				c.setCart(c);
//				cartDao.insertCart(c);
				
//			}
//		else
//			if (email!=null)
//			{
//			
//			System.out.println(prodId);
//			System.out.println(email);
//			Cart cart = new Cart();
//			Product product1 = productDao.getProd(prodId);
//			CartItems cartItem = new CartItems();
//			cartItem.setCart(cart);
//			cartItem.setCartPrice(product1.getProdPrice());
//			cartItem.setCartProductId(prodId);
//			cartItem.setCartQuantity(product1.getProdQuantity());
//			cartItem.setCartImage(product1.getImagename());
//			cartItem.setCartProductName(product1.getProdName());
//			cartItemsDao.insertCartItems(cartItem);
//			cartDao.getCartById(prodId, email);
//			System.out.println(cart.getGrandtotal());
//			System.out.println(product1.getProdPrice());
			
//			cart.setGrandtotal(cart.getGrandtotal() + cartItem.getCartPrice());
//			cart.setTotalitem(cart.getTotalitem() + 1);
//			cartDao.updateCart(cart);
//			session.setAttribute("items", cart.getTotalitem());
//			session.setAttribute("gd", cart.getGrandtotal());
//			List<Cart> list= cartDao.findCartById(email);
//			mv.addObject("cartitems", list);
//			return new ModelAndView("redirect:/");
//			
//			}
//		return mv;
//		}
	
			
//		try
//		{
//			prodId=req.getParameter("prodId");
//			Double price= Double.parseDouble(req.getParameter("prodPrice"));
//			int qty=Integer.parseInt(req.getParameter("prodQuantity"));
//			String prodName=req.getParameter("prodName");
//			String imgname= req.getParameter("imagename");
//			Cart cart=cartDao.getCartById(prodId, email);
//			if (cart==null)
//			{
//				Cart c=new Cart();
//				c.setCartPrice(price);
//				c.setCartProductId(prodId);
//				c.setCartQuantity(qty);
//				c.setCartImage(imgname);
//				c.setCartProductName(prodName);
//				
//				User u= userDao.get(email);
//				c.setUser(u);
//				cartDao.insertCart(c);
//			}
//			else
//				if(cart!=null)
//				{
//					Cart c=new Cart();
//					c.setCartId(cart.getCartId());
//					c.setCartPrice(price);
//					c.setCartProductId(prodId);
//					c.setCartQuantity(qty);
//					c.setCartImage(imgname);
//					c.setCartProductName(prodName);
//					
//					User u= userDao.get(email);
//					c.setUser(u);
//					cartDao.updateCart(c);			
//			}
//			mv.addObject("cartInfo", cartDao.findCartById(email));
//			mv.setViewName("cart");
//			return mv;
//		}
//		catch(Exception e)
//		{
//			mv.addObject("cartInfo", cartDao.findCartById(email));
//			mv.setViewName("cart");
//			return mv;
//		}
		
	
	@RequestMapping(value = "/viewcart")
	public String viewcart(Model model, HttpSession session, @ModelAttribute("user")User user) 
	{
		System.out.println(1223);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken))
		{
			String currusername = authentication.getName();
			User u = userDao.getMail(currusername);
		        Cart c=u.getCart();
				List<CartItems> cartItem = cartItemsDao.getlist(u.getCart().getCartId());
				if(cartItem==null ||cartItem.isEmpty())
				{
					session.setAttribute("items",0);
					model.addAttribute("user", user);
					model.addAttribute("gtotal",0.0);
					model.addAttribute("msg", "no Items is added to cart");
					return "viewcart";		
				}
				
				model.addAttribute("user", user);
				model.addAttribute("cartItems", cartItem);
				model.addAttribute("gtotal",c.getGrandtotal());
				session.setAttribute("items",c.getTotalitem());
			    session.setAttribute("cartId", c.getCartId());
				return "viewcart";		
	}
		model.addAttribute("user", user);
		return "redirect:/viewcart";
	}
	
	@RequestMapping(value="/Remove/{cartitemsId}")
	public ModelAndView RemoveFromCart(@PathVariable("cartitemsId") String id)
	{
		ModelAndView obj= new ModelAndView("redirect:/viewcart");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken))
		{
			String currusername = authentication.getName();
			User u = userDao.getMail(currusername);
				
		cartItems=cartItemsDao.getCartItems(id);
		Cart c=cartDao.getCart(u.getCart().getCartId());
		c.setGrandtotal(c.getGrandtotal()-cartItems.getCartPrice());
		c.setTotalitem(c.getTotalitem()-1);
//		cartDao.saveorupdateCart(c);       //If i uncomment this line i am getting error like  Illegal attempt to associate a collection with two open sessions
		cartItemsDao.deleteCartItems(cartItems.getCartitemsId());
		
		return obj;
		}
		return obj;
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
	
//	@RequestMapping(value="/deleteCart/{cartId}")
//	public ModelAndView deleteCartItems(@PathVariable("cartId")String cartId, HttpServletRequest req)
//	{
//		ModelAndView mv= new ModelAndView();
//		Principal p= req.getUserPrincipal();
//		String email= p.getName();
//		mv.addObject("cartInfo", cartDao.findCartById(cartId));
//		mv.setViewName("cart");
//		return mv;
//	}
//	
	
//	@RequestMapping(value="/gotoCart", method=RequestMethod.GET)
//	public ModelAndView gotocart(@ModelAttribute("user")User user,HttpServletRequest req)
//	{
//		ModelAndView mv=new ModelAndView();
//		mv.addObject("user", user);
//		Principal p= req.getUserPrincipal();
//		String email= p.getName();
//		mv.addObject("cartInfo", cartDao.findCartById(email));
//		
//		mv.setViewName("cart");
//		return mv;
//	}
}
