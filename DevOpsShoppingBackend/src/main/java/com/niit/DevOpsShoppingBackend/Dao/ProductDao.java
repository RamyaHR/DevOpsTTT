package com.niit.DevOpsShoppingBackend.Dao;

import java.util.List;

import com.niit.DevOpsShoppingBackend.Model.Product;

public interface ProductDao {

public boolean saveorupdateProd(Product product);
	
	public boolean updateProd(Product product);
	
	public boolean deleteProd(String prodId);
	
	public Product getProd(String prodId);
	
	public Product getProdByCatId(String catId);
	
	public List<Product> list();
	
	public List<Product> getProductByCategory(String catId);
}
