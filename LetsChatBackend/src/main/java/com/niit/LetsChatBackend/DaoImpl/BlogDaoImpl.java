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
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		List<Blog> li= session.createQuery("from Blog").list();
		session.getTransaction().commit();
		return li;
	}
	}

	

