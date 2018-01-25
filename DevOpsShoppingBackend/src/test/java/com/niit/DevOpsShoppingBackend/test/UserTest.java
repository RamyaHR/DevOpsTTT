package com.niit.DevOpsShoppingBackend.test;


import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;

import org.junit.BeforeClass;

import com.niit.DevOpsShoppingBackend.Dao.UserDao;
import com.niit.DevOpsShoppingBackend.Model.User;


public class UserTest{
	
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
	public static void init()
	{
		context= new AnnotationConfigApplicationContext();
		context.scan("com.niit.DevOpsShoppingBackend.*");
		context.refresh();
		
		userDao=(UserDao)context.getBean("userDao");
	}
	
//	@Test
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
       
        
        user.setUserId("u102");
        user.setName("Keerthana");
        user.setAddress("Bangalore");
        user.setCountry("India");
        user.setPhone("98844596846");
        user.setEmail("keerthana@gmail.com");
        user.setPassword("keerthana");
       
        assertEquals("User added successfully", true, userDao.insertUser(user));
       
        
        user.setUserId("u103");
        user.setName("Ananya");
        user.setAddress("Bangalore");
        user.setCountry("India");
        user.setPhone("8574963254");
        user.setEmail("ananya@gmail.com");
        user.setPassword("ananya");
       
        assertEquals("User added successfully", true, userDao.insertUser(user));
       
    }
	
	@Test
	public void testget()
	{
		user= userDao.get("u101");
		 assertEquals("Successfully retrieved the user", "Ramya", user.getName());
	       
	}
	
	@Test
	public void testupdateUser()
	{
		user= userDao.get("u101");
		user.setName("Ramya H.R");
		 assertEquals("Successfully updated the user", "Ramya H.R", user.getName());
	       
	}
	
//	@Test
	public void testdelete()
	{
		user= userDao.get("u103");
		
		assertEquals("Successfully deleted the user", true, userDao.delete(user));
		 	       
	}
	
	
	@Test
	public void testgetUser()
	{
		
		assertEquals("Successfully fetched the user list", 2, userDao.list().size());
		 	       
	}
	
}
