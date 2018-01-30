package com.niit.DevOpsShoppingBackend.Dao;

import java.util.List;

import com.niit.DevOpsShoppingBackend.Model.Supplier;


public interface SupplierDao {

	public boolean insertSupp(Supplier supplier);
	
	public boolean updateSupp(Supplier supplier);
	
	public boolean deleteSupp(Supplier supplier);
	
	public Supplier getSupp(String supId);
	
	public List<Supplier> list();
}
