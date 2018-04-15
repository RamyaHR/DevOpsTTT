package com.niit.LetsChatBackend.Dao;

import java.util.List;

import com.niit.LetsChatBackend.model.UserDetail;

public interface UserDetailDao {

	public boolean addUser(UserDetail userDetail);
	public boolean deleteUser(UserDetail userDetail);
	public boolean updateUser(UserDetail userDetail);
	public UserDetail getUserbyid(int userId);
	public List<UserDetail> listUser();
	public boolean checkLogin(UserDetail userDetail);
	public boolean updateOnlineStatus(String status, UserDetail user);
	public UserDetail getUser(String loginname);
}
