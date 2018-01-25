//package com.niit.DevOpsShoppingBackendTestCases;
//
//import static org.junit.Assert.*;
//
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.niit.DevOpsShoppingBackend.Dao.UserDao;
//import com.niit.DevOpsShoppingBackend.Model.User;
//
//import junit.framework.Assert;
//
//public class TestUserDao {
//
//	@Autowired
//	User user;
//	@Autowired
//	UserDao userDao;
//	
//	@Test
//	public void test() {
//		user.setAddress("Bangalore");
//		user.setCountry("India");
//		user.setEmail("ramya@gmail.com");
//		user.setName("Ramya");
//		user.setPassword("ramya");
//		user.setPhone("8197657435");
//		
//		userDao.insertUser(user);
//	}
//	
//	@Test
//    @Transactional
//    public void testinsertUser()
//    {
//		
//		User user= new User("Ramya", "ramya@gmail.com","ramya", "8197657435", "Bangalore", "India");
//		user.setAddress("Bangalore");
//		user.setCountry("India");
//		user.setEmail("ramya@gmail.com");
//		user.setName("Ramya");
//		user.setPassword("ramya");
//		user.setPhone("8197657435");
//		
//		userDao.insertUser(user);
////		{
////			System.out.println("User added");
////		}
////		else
////		{
////			System.out.println("Not added");
////		}
//        Assert.assertEquals(user.getName(), user.getName());
//    }
//
//}
