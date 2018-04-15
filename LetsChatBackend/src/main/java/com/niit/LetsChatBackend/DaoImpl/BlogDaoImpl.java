package com.niit.LetsChatBackend.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.LetsChatBackend.Dao.BlogDao;
import com.niit.LetsChatBackend.model.Blog;
import com.niit.LetsChatBackend.model.BlogComment;

@Repository("blogDao")
@Transactional
public class BlogDaoImpl implements BlogDao
{
	@Autowired
	SessionFactory sessionFactory;
	
	public BlogDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	@Transactional
	public boolean addBlog(Blog blog) {
		try
		{
			sessionFactory.getCurrentSession().save(blog);
			return true;
		}
		catch(Exception e)
		{
			
			return false;
		}
	}

	@Override
	public boolean deleteBlog(Blog blog) {
		try
		{
			sessionFactory.getCurrentSession().delete(blog);
			return true;
		}
		catch(Exception e)
		{
			
			return false;
		}
	}

	@Override
	public boolean updateBlog(Blog blog) {
		try
		{
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e)
		{
			
			return false;
		}
	}

	@Override
	public Blog getBlog(int blogId) {
		try
		{
			Session session=sessionFactory.openSession();
			Blog blog= session.get(Blog.class, blogId);
			session.close();
			return blog;
		}
		catch(Exception e)
		{
			
			return null;
		}
	}

	@Override
	public boolean approveBlog(Blog blog) {
		try
		{
			blog.setStatus("A");
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e)
		{
			
			return false;
		}
	}

	@Override
	public boolean rejectBlog(Blog blog) {
		try
		{
			blog.setStatus("NA");
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e)
		{
			
			return false;
		}
	}

	@Override
	public List<Blog> listBlog() {
		try{
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			Query query= session.createQuery("from Blog");
			List<Blog> listBlogs=query.list();
			session.close();
			return listBlogs;
		}
		catch(Exception e)
		{
			return null;
		}
		
	}

	@Override
	public boolean incrementLike(Blog blog) {
		try
		{
			int likes=blog.getLikes();
			likes++;
			blog.setLikes(likes);
			sessionFactory.getCurrentSession().update(blog);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean addBlogComment(BlogComment blogComment) {
		try
		{
			sessionFactory.getCurrentSession().save(blogComment);
			return true;
		}
		catch(Exception e)
		{
			
			return false;
		}
	}

	@Override
	public boolean deleteBlogComment(BlogComment blogComment) {
		try
		{
			sessionFactory.getCurrentSession().delete(blogComment);
			return true;
		}
		catch(Exception e)
		{
			
			return false;
		}
	}

	@Override
	public BlogComment getBlogComment(int commentId) {
		try
		{
			Session session=sessionFactory.openSession();
			BlogComment blogComment=(BlogComment)session.get(BlogComment.class, commentId);
			return blogComment;
		}
		catch(Exception e)
		{
			
			return null;
		}
	}

	@Override
	public List<BlogComment> listBlogComments(int blogId) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from BlogComment where blogId=:blogId");
		query.setParameter("blogId", new Integer(blogId));
		List<BlogComment> listBlogComments=query.list();
		return listBlogComments;
	}
	
	
	}

	

