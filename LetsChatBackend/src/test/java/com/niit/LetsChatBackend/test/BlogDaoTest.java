package com.niit.LetsChatBackend.test;

import static org.junit.Assert.*;

import java.sql.Timestamp;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.LetsChatBackend.Dao.BlogDao;
import com.niit.LetsChatBackend.model.Blog;

import org.junit.Test;
public class BlogDaoTest {
	
	private static AnnotationConfigApplicationContext context;
	
	private static BlogDao blogDao;
	
	private static Blog blog;
	
	@BeforeClass
	public static void setup()
	{
		Blog blog= new Blog();
	}
	
	@AfterClass
	public static void teardown()
	{
		blog=null;
	}

	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		
		blogDao=(BlogDao)context.getBean("blogDao");
	}
	
	
	@Test
	public void addBlogTest()
	{
//		Timestamp dt_date = new Timestamp(System.currentTimeMillis());
		Blog blog= new Blog();
		blog.setBlogId(101);
		blog.setBlogName("Java");
		blog.setBlogContent("abcd");
		blog.setUserName("dfg");
		blog.setStatus("A");
		blog.setLikes(0);
		blog.setCreateDate(new Timestamp(System.currentTimeMillis()));
		assertEquals("Blog is saved",true, blogDao.addBlog(blog));
	
		blog.setBlogId(102);
		blog.setBlogName("Angular Js");
		blog.setBlogContent("def");
		blog.setUserName("abcd");
		blog.setStatus("A");
		blog.setLikes(0);
		blog.setCreateDate(new Timestamp(System.currentTimeMillis()));
		assertEquals("Blog is saved",true, blogDao.addBlog(blog));
		
		blog.setBlogId(103);
		blog.setBlogName("Bootstrap");
		blog.setBlogContent("fghi");
		blog.setUserName("lmno");
		blog.setStatus("A");
		blog.setLikes(0);
		blog.setCreateDate(new Timestamp(System.currentTimeMillis()));
		assertEquals("Blog is saved",true, blogDao.addBlog(blog));
	}
	
//	@Test
	public void testgetBlog()
	{
		blog= blogDao.getBlog(101);
		 assertEquals("Successfully retrieved the blog", "Java", blog.getBlogName());
	       
	}
	
//	@Test
	public void testupdateBlog()
	{
		blog= blogDao.getBlog(101);
		blog.setBlogName("JavaScript");
		 assertEquals("Successfully updated the user", true, blogDao.updateBlog(blog));
	       
	}
	
//	@Test
	public void testdeleteBlog()
	{
		blog= blogDao.getBlog(102);
		
		assertEquals("Successfully deleted the user", true, blogDao.deleteBlog(blog));
		 	       
	}
	
	
//	@Test
	public void testlistBlog()
	{
		
		assertEquals("Successfully fetched the blog list",  blogDao.listBlog().size()>0);
		 	       
	}
	
//	@Test
	public void testAcceptBlog()
	{
		blog=blogDao.getBlog(101);
		assertEquals("Successfully accepted", true, blogDao.approveBlog(blog));
	}
	
//	@Test
	public void testRejectBlog()
	{
		blog=blogDao.getBlog(103);
		assertEquals("Successfully accepted", true, blogDao.rejectBlog(blog));
	}
	
}
