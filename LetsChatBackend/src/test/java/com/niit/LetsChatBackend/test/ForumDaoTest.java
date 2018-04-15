package com.niit.LetsChatBackend.test;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.LetsChatBackend.Dao.ForumDao;
import com.niit.LetsChatBackend.model.Forum;

public class ForumDaoTest {

private static AnnotationConfigApplicationContext context;
	
	private static ForumDao forumDao;
	
	private static Forum forum;
	
	@BeforeClass
	public static void setup()
	{
		Forum forum= new Forum();
	}
	
	@AfterClass
	public static void teardown()
	{
		forum=null;
	}

	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		
		forumDao=(ForumDao)context.getBean("forumDao");
	}
	
	
//	@Test
	public void addForumTest()
	{
//		Timestamp dt_date = new Timestamp(System.currentTimeMillis());
		Forum forum= new Forum();
		forum.setForumId(201);
		forum.setForumName("Forum1");
		forum.setForumContent("abcd");
		forum.setUserName("dfg");
		forum.setStatus("A");
		forum.setForumDate(new Timestamp(System.currentTimeMillis()));
		assertEquals("Forum is saved",true, forumDao.addForum(forum));
	
		forum.setForumId(202);
		forum.setForumName("Forum2");
		forum.setForumContent("def");
		forum.setUserName("abcd");
		forum.setStatus("A");
		forum.setForumDate(new Timestamp(System.currentTimeMillis()));
		assertEquals("Forum is saved",true, forumDao.addForum(forum));
		
		forum.setForumId(103);
		forum.setForumName("Forum3");
		forum.setForumContent("fghi");
		forum.setUserName("lmno");
		forum.setStatus("A");
		forum.setForumDate(new Timestamp(System.currentTimeMillis()));
		assertEquals("Forum is saved",true, forumDao.addForum(forum));
	}
	
//	@Test
	public void testgetForum()
	{
		forum= forumDao.getForum(201);
		 assertEquals("Successfully retrieved the forum", "Forum1", forum.getForumName());
	       
	}
	
//	@Test
	public void testupdateForum()
	{
		forum= forumDao.getForum(201);
		forum.setForumName("Forum4");
		 assertEquals("Successfully updated the user", true, forumDao.updateForum(forum));
	       
	}
	
//	@Test
	public void testdeleteForum()
	{
		forum= forumDao.getForum(202);
		
		assertEquals("Successfully deleted the user", true, forumDao.deleteForum(forum));
		 	       
	}
	
	
//	@Test
	public void testlistForum()
	{
		
		assertEquals("Successfully fetched the forum list", forumDao.listForum().size()>0);
		 	       
	}
	
//	@Test
	public void testAcceptForum()
	{
		forum=forumDao.getForum(201);
		assertEquals("Successfully accepted", true, forumDao.approveForum(forum));
	}
	
	@Test
	public void testRejectForum()
	{
		forum=forumDao.getForum(103);
		assertEquals("Successfully accepted", true, forumDao.rejectForum(forum));
	}
}
