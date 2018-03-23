package com.niit.LetsChatMiddleWare.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.niit.LetsChatBackend.Dao.BlogDao;
import com.niit.LetsChatBackend.model.Blog;

@RestController
public class BlogController {
	
	@Autowired
	BlogDao blogDao;
	
	@GetMapping(value="/demo")
	public ResponseEntity<String> demoPurpose()
	{
		return new ResponseEntity<String>("Demo Data", HttpStatus.OK);
	}
	
	@GetMapping(value="/listBlogs")
	public ResponseEntity<List<Blog>> getlistBlogs()
	{
		List<Blog> listBlogs= blogDao.listBlog("abcd");
		if(listBlogs.size()>0)
		{
			return new ResponseEntity<List<Blog>>(listBlogs, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Blog>>(listBlogs, HttpStatus.NOT_FOUND);
		}
	}

	
	@PostMapping(value="/addBlog")
	public ResponseEntity<String> addBlog(@RequestBody Blog blog)
	{
		blog.setCreateDate(new java.util.Date());
		blog.setLikes(0);
		blog.setUserName("abcd");
		blog.setStatus("A");
		
		if(blogDao.addBlog(blog))
		{
			return new ResponseEntity<String>("Success", HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Failure", HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(value="/deleteBlog")
	public ResponseEntity<String> deleteBlog(@RequestBody Blog blog)
	{
		if(blogDao.deleteBlog(blog))
		{
			return new ResponseEntity<String>("Success", HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Failure", HttpStatus.NOT_FOUND);
		}
	}
	
	
	@GetMapping(value="/getBlog/{blogId}")
	public ResponseEntity<Integer> getBlog(@RequestParam("blogId")int blogId)
	{
		
			return new ResponseEntity<Integer>(HttpStatus.OK);
	}
	
	
}
