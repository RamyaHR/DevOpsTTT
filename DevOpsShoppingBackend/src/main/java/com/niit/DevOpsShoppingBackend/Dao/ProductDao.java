package com.niit.DevOpsShoppingBackend.Dao;

import java.util.List;

import com.niit.DevOpsShoppingBackend.Model.Product;

public interface ProductDao {

public boolean insertProd(Product product);
	
	public boolean updateProd(Product product);
	
	public boolean deleteProd(Product product);
	
	public Product getProd(String prodId);
	
	public List<Product> list();
}
