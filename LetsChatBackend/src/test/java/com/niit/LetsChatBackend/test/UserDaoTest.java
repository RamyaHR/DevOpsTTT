package com.niit.LetsChatBackend.test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.LetsChatBackend.Dao.UserDao;
import com.niit.LetsChatBackend.model.User;

public class UserDaoTest {

private static AnnotationConfigApplicationContext context;
	
	private static UserDao userDao;
	
	private static User user;
	
	@BeforeClass
	public static void setup()
	{
		User user= new User();
	}
	
	@AfterClass
	public static void teardown()
	{
		user=null;
	}

	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		
		userDao=(UserDao)context.getBean("userDao");
	}
	
	
//	@Test
	public void addUserTest()
	{
		User user= new User();
//		user.setUserId(101);
		user.setUserName("abcd");
		user.setAddress("def");
		user.setCity("fs");
		user.setEmailId("abcd@gmail.com");
		user.setMobile("96874526931");
		user.setPassword("abcd");
		assertEquals("User is saved",true, userDao.addUser(user));
	
//		user.setUserId(102);
		user.setUserName("defg");
		user.setAddress("fgh");
		user.setCity("abcd");
		user.setEmailId("defg@gmail.com");
		user.setMobile("9685646931");
		user.setPassword("defg");
		assertEquals("User is saved",true, userDao.addUser(user));
		
//		user.setUserId(103);
		user.setUserName("xyz");
		user.setAddress("hjnk");
		user.setCity("ghjb");
		user.setEmailId("xyz@gmail.com");
		user.setMobile("9965526931");
		user.setPassword("xyz");
		assertEquals("User is saved",true, userDao.addUser(user));
	}
	
//	@Test
	public void testgetUser()
	{
		user= userDao.getUser(101);
		 assertEquals("Successfully retrieved the user", "abcd", user.getUserName());
	       
	}
	
//	@Test
	public void testupdateUser()
	{
		user= userDao.getUser(101);
		user.setUserName("abc");
		 assertEquals("Successfully updated the user", true, userDao.updateUser(user));
	       
	}
	
//	@Test
	public void testdeleteUser()
	{
		user= userDao.getUser(102);
		
		assertEquals("Successfully deleted the user", true, userDao.deleteUser(user));
		 	       
	}
	
	
	@Test
	public void testlistUser()
	{
		
		assertEquals("Successfully fetched the user list", 2, userDao.listUser().size());
		 	       
	}
	

}
