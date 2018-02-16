package com.niit.DevOpsShoppingBackend.Dao;

import java.util.List;

import com.niit.DevOpsShoppingBackend.Model.Category;

public interface CategoryDao {

public boolean insertCat(Category category);
	
	public boolean updateCat(Category category);
	
	public boolean deleteCat(String catId);
	
	public Category getCat(String catId);
	
	public List<Category> list();

	public List<Category> getByCategoryName(String catName);

	
}

