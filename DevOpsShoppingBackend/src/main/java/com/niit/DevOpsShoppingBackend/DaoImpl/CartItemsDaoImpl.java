package com.niit.DevOpsShoppingBackend.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.DevOpsShoppingBackend.Dao.CartItemsDao;
import com.niit.DevOpsShoppingBackend.Model.Cart;
import com.niit.DevOpsShoppingBackend.Model.CartItems;

@Repository("cartItemsDao")
@EnableTransactionManagement
@Transactional
public class CartItemsDaoImpl implements CartItemsDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public CartItemsDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Override
	public boolean saveorupdateCartItems(CartItems cartItems) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(cartItems);
		session.getTransaction().commit();
		return true;
	}


	@Override
	public boolean deleteCartItems(String cartitemsId) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		CartItems cartItems=(CartItems) session.get(CartItems.class, cartitemsId);
		session.delete(cartItems);
		return true;
	}

	@Override
	public CartItems getCartItems(String cartitemsId) {
		Session session= sessionFactory.openSession();
		CartItems cartItems=null;
		try
		{
			session.beginTransaction();
			cartItems=session.get(CartItems.class, cartitemsId);
			session.getTransaction().commit();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return cartItems;
	}

	@Override
	public List<CartItems> list() {
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		List<CartItems> cartitemlist= session.createQuery("from CartItems").list();
		session.getTransaction().commit();
		return cartitemlist;
	}
	
	
	@Override
	public CartItems getlistall(String cartId, String pro) {
		String sql= "from CartItems where cartId='" +cartId+ "'and cartProductId ='"+pro+ "'";
		Query q1= sessionFactory.getCurrentSession().createQuery(sql);
		@SuppressWarnings("unchecked")
		List<CartItems> list=(List<CartItems>) q1.list();
		if(list==null || list.isEmpty()){
			System.out.println("Item is not found");
			return null;
		}
		else
		{
			return list.get(0);
		}
		
	}
	
	public List<CartItems> getlist(String cartId)
	{
		String Sq1="from CartItems where cartId='"+cartId+"'";
		Query q1=sessionFactory.getCurrentSession().createQuery(Sq1);
		@SuppressWarnings("unchecked")
		List<CartItems> list=(List<CartItems>)q1.list();
		if(list==null||list.isEmpty())
		{
			System.out.println("Item is not found");
			return null;
		}
		else
		{
			return list;
		}
		
	}

}
