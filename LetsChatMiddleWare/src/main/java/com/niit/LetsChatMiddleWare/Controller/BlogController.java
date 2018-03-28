package com.niit.LetsChatMiddleWare.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.niit.LetsChatBackend.Dao.BlogDao;
import com.niit.LetsChatBackend.model.Blog;
import com.niit.LetsChatBackend.model.BlogComment;

@RestController
public class BlogController {
	
	@Autowired
	BlogDao blogDao;
	
	@GetMapping(value="/demo")
	public ResponseEntity<String> demoPurpose()
	{
		return new ResponseEntity<String>("Demo Data", HttpStatus.OK);
	}
	
	//-----------ListBlog--------------//
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

	//-------------Add Blog---------------//
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
	
	//---------------DeleteBlog-------------------//
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
	
	//---------------------Update Blog-------------------//
	@PostMapping(value = "/updateBlog/{blogId}")
	public ResponseEntity<String> updateBlog(@PathVariable("blogId") int blogId, @RequestBody Blog blog) {
		System.out.println("Updating Blog " + blogId);
		Blog blog1 = blogDao.getBlog(blogId);
		if (blog1 == null) {
			System.out.println("Blog with blogId " + blogId + " Not Found");
			return new ResponseEntity<String>("Update Blog Failue", HttpStatus.NOT_FOUND);
		}
		
		blog1.setBlogContent(blog.getBlogContent());
		blog1.setBlogName(blog.getBlogName());
		blog1.setCreateDate(new Date());
		blog1.setStatus(blog.getStatus());
		blog1.setUserName(blog.getUserName());
		
		blogDao.updateBlog(blog1);
		return new ResponseEntity<String>("Update Blog Success", HttpStatus.OK);
	}

	// -----------------------Get Blog --------------------//

	@GetMapping(value = "/getBlog/{blogId}")
	public ResponseEntity<String> getBlog(@PathVariable("blogId") int blogId) {
		System.out.println("Get Blog " + blogId);
		Blog blog = blogDao.getBlog(blogId);
		if (blog == null) {
			return new ResponseEntity<String>("Get blog failure", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<String>("Get blog Success", HttpStatus.OK);
		}
	}

	// -----------------------Approve Blog ------------//

	@PostMapping(value = "/approveBlog/{blogId}")
	public ResponseEntity<String> approveBlog(@PathVariable("blogId") int blogId) {
		System.out.println("Approve Blog with Blog ID: " + blogId);
		Blog blog = blogDao.getBlog(blogId);
		if (blog == null) {
			System.out.println("Not blog with blog Id: " + blogId + " found for Approval");
			return new ResponseEntity<String>("No Blog found for Approval", HttpStatus.NOT_FOUND);
		} else {
			blog.setStatus("A");
			blogDao.approveBlog(blog);
			return new ResponseEntity<String>("Blog " + blogId + " Approved Successfully", HttpStatus.OK);
		}
	}

	// --------------------Reject Blog ------------------//

	@PostMapping(value = "/rejectBlog/{blogId}")
	public ResponseEntity<String> rejectBlog(@PathVariable("blogId") int blogId) {
		System.out.println("Disapprove Blog with Blog ID: " + blogId);
		Blog blog = blogDao.getBlog(blogId);
		if (blog == null) {
			System.out.println("Not blog with blog Id: " + blogId + " found for Approval");
			return new ResponseEntity<String>("No Blog with Blog Id " + blogId + " found for Disapproval",
					HttpStatus.NOT_FOUND);
		} else {
			blog.setStatus("NA");
			blogDao.rejectBlog(blog);
			return new ResponseEntity<String>("Blog " + blogId + " Disapproved Successfully", HttpStatus.OK);
		}
	}

	
	// ---------------- Add BlogComments --------------------//

		@PostMapping(value = "/addBlogComment")  //Not working with postman
		public ResponseEntity<String> addBlogComments(@RequestBody BlogComment blogComment) {
			blogComment.setCommentDate(new Date());
			Blog blog = blogDao.getBlog(1);
			String username = blog.getUserName();
			int blogId = blog.getBlogId();
			blogComment.setBlogId(blogId);
			blogComment.setLoginname(username);
			if (blogDao.addBlogComment(blogComment)) {
				return new ResponseEntity<String>("BlogComment Added- Success", HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("BlodComment insertion failed", HttpStatus.NOT_FOUND);
			}
		}

		// -------------------------Delete BlogComment	 ---------------//

		@PostMapping(value = "/deleteBlogComment/{commentId}")    //not working with postman
		public ResponseEntity<String> deleteBlogComment(@PathVariable("commentId") int commentId) {
			System.out.println("Delete blogComment with comment Id: " + commentId);
			BlogComment blogComment = blogDao.getBlogComment(commentId);
			if (blogComment == null) {
				System.out.println("No blog " + commentId + " found to delete");
				return new ResponseEntity<String>("No blogcomment with comment Id: " + commentId + " found to delete",
						HttpStatus.NOT_FOUND);
			} else {
				blogDao.deleteBlogComment(blogComment);
				return new ResponseEntity<String>("BlogComment with comment Id " + commentId + " deleted successfully", HttpStatus.OK);
			}

		}
		// -----------------------Get BlogComment ---------------//

		@GetMapping(value = "/getBlogComment/{commentId}")    //not working with postman
		public ResponseEntity<String> getBlogComment(@PathVariable("commentId") int commentId) {
			System.out.println("Get BlogComment " + commentId);
			BlogComment blogComment = blogDao.getBlogComment(commentId);
			if (blogComment == null) {
				return new ResponseEntity<String>("Get blogComment failure", HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<String>("Get blogComment Success", HttpStatus.OK);
			}
		}

		// -----------------list Blogs ---------------------------------
		@GetMapping(value = "/listBlogComments")
		public ResponseEntity<List<BlogComment>> listBlogComments() {
			List<BlogComment> listBlogComments = blogDao.listBlogComments(1);
			if (listBlogComments.size() != 0) {
				return new ResponseEntity<List<BlogComment>>(listBlogComments, HttpStatus.OK);
			} else {
				return new ResponseEntity<List<BlogComment>>(listBlogComments, HttpStatus.NOT_FOUND);
			}
		}
		
		// -----------------increment likes ---------------------//
				@PostMapping(value = "/incrementLikes/{blogId}")
				public ResponseEntity<String> incrementLikes(@PathVariable("blogId")int blogId) {
					System.out.println("Increment likes for BlogId " + blogId);
					Blog blog = blogDao.getBlog(blogId);
					if (blogDao.incrementLike(blog)) {
						return new ResponseEntity<String>("Successfully incremented..", HttpStatus.OK);
					} else {
						return new ResponseEntity<String>("Failed", HttpStatus.NOT_FOUND);
					}
				}

	
}
