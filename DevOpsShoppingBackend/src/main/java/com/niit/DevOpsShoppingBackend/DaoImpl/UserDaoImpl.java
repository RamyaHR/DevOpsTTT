package com.niit.DevOpsShoppingBackend.DaoImpl;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.DevOpsShoppingBackend.Dao.UserDao;
import com.niit.DevOpsShoppingBackend.Model.User;


public class UserDaoImpl implements UserDao{
	
	@Autowired 
	SessionFactory sessionFactory;
		
	List<User> user;
	
	public UserDaoImpl()
	{
		user=new ArrayList<User>();
		User user1= new User("Ramya", "ramya@gmail.com", "123", "8197657435","Bangalore", "India");
		user.add(user1);
	}
	
	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory= sessionFactory;
	}

	@Override
	public List<User> getUser() {
		
		return user;
	}

	

		
	
}
