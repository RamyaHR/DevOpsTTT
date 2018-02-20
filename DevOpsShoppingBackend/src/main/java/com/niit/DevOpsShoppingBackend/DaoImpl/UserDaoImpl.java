package com.niit.DevOpsShoppingBackend.DaoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.DevOpsShoppingBackend.Dao.UserDao;
import com.niit.DevOpsShoppingBackend.Model.Cart;
import com.niit.DevOpsShoppingBackend.Model.CartItems;
import com.niit.DevOpsShoppingBackend.Model.User;


@Repository("userDao")
@EnableTransactionManagement

public class UserDaoImpl implements UserDao{
	
	@Autowired
	SessionFactory sessionFactory;

	List<User> user;
	
	public UserDaoImpl()
	{
		user=new ArrayList<User>();
//		User user1= new User("Ramya", "ramya@gmail.com", "123", "8197657435","Bangalore", "India");
//		user.add(user1);
	}
	
	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory= sessionFactory;
	}

	@Override
	public List<User> list() {
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		List<User> userlist= session.createQuery("from User").list();
		session.getTransaction().commit();
		return userlist;
	}


	public boolean insertUser(User user) {
		
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		return true;
		
	}

	@Override
	public User get(String userId) {
		
		Session session= sessionFactory.openSession();
		User user=null;
		try
		{
			session.beginTransaction();
			user=session.get(User.class, userId);
			session.getTransaction().commit();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return user;
		}

	@Override
	public boolean delete(String userId) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		User user=(User) session.get(User.class, userId);
		session.delete(user);
		return true;
	}

	@Override
	public boolean updateUser(User user) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.update(user);
		session.getTransaction().commit();
		return true;
	}

	@Override
	@Transactional
	public User getMail(String email) {
		String sql= "from User where email='" +email+"'";
		Query q1= sessionFactory.getCurrentSession().createQuery(sql);
		@SuppressWarnings("unchecked")
		List<User> list=(List<User>) q1.list();
		if(list==null || list.isEmpty()){
			System.out.println("Item is not found");
			return null;
		}
		else
		{
			return list.get(0);
		}
		
		}
	}
	
	

	
	
	

