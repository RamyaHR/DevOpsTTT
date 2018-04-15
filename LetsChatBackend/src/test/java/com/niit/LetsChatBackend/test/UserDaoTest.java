package com.niit.LetsChatBackend.test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.LetsChatBackend.Dao.UserDetailDao;
import com.niit.LetsChatBackend.model.UserDetail;

public class UserDaoTest {

private static AnnotationConfigApplicationContext context;
	
	private static UserDetailDao userDetailDao;
	
	private static UserDetail userDetail;
	
	@BeforeClass
	public static void setup()
	{
		UserDetail userDetail= new UserDetail();
	}
	
	@AfterClass
	public static void teardown()
	{
		userDetail=null;
	}

	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		
		userDetailDao=(UserDetailDao)context.getBean("userDetailDao");
	}
	
	
	//@Test
	public void addUserTest()
	{
		UserDetail user= new UserDetail();
//		user.setUserId(101);
		user.setUserName("abcd");
		user.setAddress("def");
		user.setCity("fs");
		user.setEmailId("abcd@gmail.com");
		user.setMobile("96874526931");
		user.setPassword("abcd");
		user.setLoginname("abcd");
		user.setRole("ROLEUSER");
		user.setIsOnline("N");
		
		assertEquals("User is saved",true, userDetailDao.addUser(user));
	
//		user.setUserId(102);
		user.setUserName("defg");
		user.setAddress("fgh");
		user.setCity("abcd");
		user.setEmailId("defg@gmail.com");
		user.setMobile("9685646931");
		user.setPassword("defg");
		user.setLoginname("defg");
		user.setRole("ROLEUSER");
		user.setIsOnline("N");
		assertEquals("User is saved",true, userDetailDao.addUser(user));
		
//		user.setUserId(103);
		user.setUserName("xyz");
		user.setAddress("hjnk");
		user.setCity("ghjb");
		user.setEmailId("xyz@gmail.com");
		user.setMobile("9965526931");
		user.setPassword("xyz");
		user.setLoginname("xyz");
		user.setRole("ROLEUSER");
		user.setIsOnline("N");
		assertEquals("User is saved",true, userDetailDao.addUser(user));
	}
	
//	@Test
	public void testgetUser()
	{
		userDetail= userDetailDao.getUserbyid(101);
		 assertEquals("Successfully retrieved the user", "abcd", userDetail.getUserName());
	       
	}
	
//	@Test
	public void testupdateUser()
	{
		userDetail= userDetailDao.getUserbyid(101);
		userDetail.setUserName("abc");
		 assertEquals("Successfully updated the user", true, userDetailDao.updateUser(userDetail));
	       
	}
	
//	@Test
	public void testdeleteUser()
	{
		userDetail= userDetailDao.getUserbyid(102);
		
		assertEquals("Successfully deleted the user", true, userDetailDao.deleteUser(userDetail));
		 	       
	}
	
	
	//@Test
	public void testlistUser()
	{
		
		assertEquals("Successfully fetched the user list",userDetailDao.listUser().size()>0);
		 	       
	}
	
	
	@Test
	public void updateOnlineStatusTest()
	{
		UserDetail user= userDetailDao.getUser("abcd");
		assertTrue("Problem in updating", userDetailDao.updateOnlineStatus("Y", user));
	}

	//@Test
	public void checkUserTest()
	{
		UserDetail user= new UserDetail();
		user.setLoginname("abcd");
		user.setPassword("abcd");
		assertTrue("Check user Fail", userDetailDao.checkLogin(user));
	}
}
