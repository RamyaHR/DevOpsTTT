package com.niit.LetsChatBackend.Dao;

import java.util.List;

import com.niit.LetsChatBackend.model.User;

public interface UserDao {

	public boolean addUser(User user);
	public boolean deleteUser(User user);
	public boolean updateUser(User user);
	public User getUser(int userId);
	public List<User> listUser();
}
