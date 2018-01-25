package com.niit.DevOpsShoppingBackendTestCases;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

import org.junit.AfterClass;

import org.junit.BeforeClass;

import com.niit.DevOpsShoppingBackend.Dao.UserDao;
import com.niit.DevOpsShoppingBackend.Model.User;

import junit.framework.TestCase;

public class UserTest extends TestCase{
	
	private static UserDao userDao;
	
	private static AnnotationConfigApplicationContext context;
	
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
	public static void init()
	{
		context= new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		
		userDao=(UserDao)context.getBean("userDao");
	}
	
	@Test
    public void testInsertUser()
    {
		user= new User();
        user.setUserId("u101");
        user.setName("Ramya");
        user.setAddress("Bangalore");
        user.setCountry("India");
        user.setPhone("8197657435");
        user.setEmail("ramya@gmail.com");
        user.setPassword("ramya");
       
        assertEquals("User added successfully", true, userDao.insertUser(user));
       
    }
}
