package com.niit.DevOpsShoppingBackend.DaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.DevOpsShoppingBackend.Dao.CartDao;
import com.niit.DevOpsShoppingBackend.Model.Cart;
import com.niit.DevOpsShoppingBackend.Model.CartItems;
import com.niit.DevOpsShoppingBackend.Model.User;

@Repository("cartDao")
@EnableTransactionManagement

public class CartDaoImpl implements CartDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public CartDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	@Override
	@Transactional
	public boolean saveorupdateCart(Cart cart) {
		sessionFactory.getCurrentSession().saveOrUpdate(cart);
		return true;
	}
	
	
	@Override
	public boolean updateCart(Cart cart) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.update(cart);
		session.getTransaction().commit();
		return true;
	}

	@Override
	public boolean deleteCart(String cartId) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Cart cart=(Cart) session.get(Cart.class, cartId);
		session.delete(cart);
		return true;
	}

	@Override
	public Cart getCart(String cartId) {
		Session session= sessionFactory.openSession();
		Cart cart=null;
		try
		{
			session.beginTransaction();
			cart=session.get(Cart.class, cartId);
			session.getTransaction().commit();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return cart;
	}

	@Override
	public List<Cart> list() {
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		List<Cart> cartlist= session.createQuery("from Cart").list();
		session.getTransaction().commit();
		return cartlist;
	}
	@Override
	public List<Cart> findCartById(String cartId) {
		String q1 = "from Cart where cartId='" + cartId + "'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		List<Cart> list1 = (List<Cart>) w.list();
		if (list1 == null || list1.isEmpty()) 
		{
			return null;
		}
		   return (List<Cart>) list1.get(0);
	}

	@Override
	public Cart getCartById(String prodId, String email) {
		String q1 = "from Cart where cartProductId='" + prodId + "' and userId='"+email+"'";
		Query w = sessionFactory.getCurrentSession().createQuery(q1);
		List<Cart> list1 = (List<Cart>) w.list();
		if (list1 == null || list1.isEmpty()) 
		{
			return null;
		}
		   return list1.get(0);
//		Session session= sessionFactory.openSession();
//		Cart cart= null;
//		session.beginTransaction();
//		cart=(Cart)session.createQuery("from Cart where email=email and cartProductId= id").setString("email",email).setString("id",prodId).uniqueResult();
//		session.getTransaction().commit();
//		return cart;
	}

	
}
