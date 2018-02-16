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

import com.niit.DevOpsShoppingBackend.Dao.ProductDao;
import com.niit.DevOpsShoppingBackend.Model.Category;
import com.niit.DevOpsShoppingBackend.Model.Product;

@Repository("productDao")
@EnableTransactionManagement
@Transactional
public class ProductDaoImpl implements ProductDao{

	@Autowired
	SessionFactory sessionFactory;

	public ProductDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		
	}
	
	@Override
	public boolean insertProd(Product product) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(product);
		session.getTransaction().commit();
		return true;
	}

	@Override
	public boolean updateProd(Product product) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.update(product);
		session.getTransaction().commit();
		return true;
	}

	@Override
	public boolean deleteProd(String prodId) {
		Session session=sessionFactory.openSession();
//		session.beginTransaction();
		Product pro=(Product) session.get(Product.class, prodId);
		session.delete(pro);
		return true;
	}

	@Override
	public Product getProd(String prodId) {
		Session session= sessionFactory.openSession();
		Product product=null;
		try
		{
			session.beginTransaction();
			product=session.get(Product.class, prodId);
			session.getTransaction().commit();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return product;
	}

	
	@Override
	public Product getProdByCatId(String catId) {
		Session session= sessionFactory.openSession();
		Product product=null;
		try
		{
			session.beginTransaction();
			product=session.get(Product.class, catId);
			session.getTransaction().commit();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public List<Product> list() {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		List<Product> li= session.createQuery("from Product").list();
		session.getTransaction().commit();
		return li;
	}

	@Override
	public List<Product> getProductByCategory(String catId) {
		String q1 = "from Product where catId='" + catId + "'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		List<Product> list1 = (List<Product>) w.list();
		if (list1 == null || list1.isEmpty()) 
		{
			return null;
		}
		   return list1;
	}
	
	

}
