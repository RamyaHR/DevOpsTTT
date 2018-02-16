package com.niit.DevOpsShoppingBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.DevOpsShoppingBackend.Dao.CategoryDao;
import com.niit.DevOpsShoppingBackend.Model.Cart;
import com.niit.DevOpsShoppingBackend.Model.Category;
import com.niit.DevOpsShoppingBackend.Model.Product;

@Repository("categoryDao")
@EnableTransactionManagement
@Transactional

public class CategoryDaoImpl implements CategoryDao{

	@Autowired
	SessionFactory sessionFactory;

	public CategoryDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		
	}
	
	@Override
	public boolean insertCat(Category category) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(category);
		session.getTransaction().commit();
		return true;
	}

	@Override
	public boolean updateCat(Category category) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.update(category);
		session.getTransaction().commit();
		return true;
	}

	@Override
	public boolean deleteCat(String catId) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Category cat=(Category) session.get(Category.class, catId);
		session.delete(cat);
		return true;
		
	}

	@Override
	public Category getCat(String catId) {

		Session session= sessionFactory.openSession();
		Category category=null;
		try
		{
			session.beginTransaction();
			category=session.get(Category.class, catId);
			session.getTransaction().commit();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return category;
		}
	

	@Override
	public List<Category> list() {
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		List<Category> catlist= session.createQuery("from Category").list();
		session.getTransaction().commit();
		return catlist;
	}

	@Override
	public List<Category> getByCategoryName(String catName) {
		Session session= sessionFactory.openSession();
		List<Category> li=null;
		session.beginTransaction();
		li=session.createQuery("from Category where catName="+catName).list();
		session.getTransaction().commit();
		return li;
	}
	
}
