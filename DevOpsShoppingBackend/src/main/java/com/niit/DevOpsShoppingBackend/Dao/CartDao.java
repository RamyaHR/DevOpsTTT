package com.niit.DevOpsShoppingBackend.Dao;

import java.util.List;

import com.niit.DevOpsShoppingBackend.Model.Cart;

public interface CartDao {

public boolean insertCart(Cart cart);
	
	public boolean updateCart(Cart cart);
	
	public boolean deleteCart(String cartId);
	
	public Cart getCart(String cartId);
	
	public List<Cart> list();
	
	public List<Cart> findCartById(String emailId);
	
	public Cart getCartById(String cartId, String email);
	

	

}
