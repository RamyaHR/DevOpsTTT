package com.niit.DevOpsShoppingBackend.Dao;

import java.util.List;

import com.niit.DevOpsShoppingBackend.Model.Order;

public interface OrderDao {

public boolean insertOrder(Order order);
	
	public boolean updateOrder(Order order);
	
	public boolean deleteOrder(String orderId);
	
	public Order getOrder(String orderId);
	
	public List<Order> list();
}
