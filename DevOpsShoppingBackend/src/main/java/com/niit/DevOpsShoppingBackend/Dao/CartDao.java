package com.niit.DevOpsShoppingBackend.Dao;

import java.util.List;

import com.niit.DevOpsShoppingBackend.Model.Cart;

public interface CartDao {

public boolean saveorupdateCart(Cart cart);

	public boolean deleteCart(String cartId);
	
	public Cart getCart(String cartId);
	
	public List<Cart> list();
	
	public List<Cart> findCartById(String cartId);
	
	public Cart getCartById(String prodId, String email);

	public boolean updateCart(Cart cart);
	

	

}
