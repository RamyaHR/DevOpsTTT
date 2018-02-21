package com.niit.DevOpsShoppingBackend.Dao;

import java.util.List;

import com.niit.DevOpsShoppingBackend.Model.CartItems;

public interface CartItemsDao {

public boolean saveorupdateCartItems(CartItems cartItems);
	
	public boolean deleteCartItems(String cartitemsId);
	
	public CartItems getCartItems(String cartitemsId);
	
	public List<CartItems> list();
	
	public CartItems get(String cartId);
	
//	public CartItems getlistall(String cartId, String pro);
	
	public List<CartItems> getlist(String cartId);
}
