package com.niit.DevOpsShoppingBackend.Dao;

import java.util.List;

import com.niit.DevOpsShoppingBackend.Model.User;

public interface UserDao {

	public List<User> list();
	
	public boolean insertUser(User user);
	
	public User get(String userId);
	
	public boolean delete(String userId);
	
	public boolean updateUser(User user);
	
	
	
	
}
