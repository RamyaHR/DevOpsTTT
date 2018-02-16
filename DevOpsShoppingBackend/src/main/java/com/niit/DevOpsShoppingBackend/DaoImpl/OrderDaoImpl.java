package com.niit.DevOpsShoppingBackend.DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.DevOpsShoppingBackend.Dao.OrderDao;
import com.niit.DevOpsShoppingBackend.Model.Category;
import com.niit.DevOpsShoppingBackend.Model.Order;

@Repository("orderDao")
@EnableTransactionManagement
@Transactional
public class OrderDaoImpl implements OrderDao{

	@Autowired
	SessionFactory sessionFactory;

	public OrderDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		
	}
	
	@Override
	public boolean insertOrder(Order order) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(order);
		session.getTransaction().commit();
		return true;
	}

	@Override
	public boolean updateOrder(Order order) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.update(order);
		session.getTransaction().commit();
		return true;
	}

	@Override
	public boolean deleteOrder(String orderId) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Order order=(Order) session.get(Order.class, orderId);
		session.delete(order);
		return true;
	}

	@Override
	public Order getOrder(String orderId) {
		Session session= sessionFactory.openSession();
		Order order=null;
		try
		{
			session.beginTransaction();
			order=session.get(Order.class, orderId);
			session.getTransaction().commit();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return order;
	}

	@Override
	public List<Order> list() {
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		List<Order> orderlist= session.createQuery("from Order").list();
		session.getTransaction().commit();
		return orderlist;
	}

}
