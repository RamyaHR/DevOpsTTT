package com.niit.DevOpsShoppingBackend.Calling;

import com.niit.DevOpsShoppingBackend.Dao.UserDao;
import com.niit.DevOpsShoppingBackend.DaoImpl.UserDaoImpl;
import com.niit.DevOpsShoppingBackend.Model.User;

public class InvokeMethod {
	
	public static void main(String args[])
	{
		UserDao userDao= new UserDaoImpl();
		
//		for(User user:userDao.getUser())
//		{
//			System.out.println(user.getEmail());
//		}
//		
	}

}
