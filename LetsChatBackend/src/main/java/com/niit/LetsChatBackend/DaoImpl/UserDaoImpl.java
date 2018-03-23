package com.niit.LetsChatBackend.DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.LetsChatBackend.Dao.UserDao;
import com.niit.LetsChatBackend.model.User;

@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao{
	@Autowired
	SessionFactory sessionFactory;
	
	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	@Transactional
	public boolean addUser(User user) {
		try
		{
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch(Exception e)
		{
			
			return false;
		}
	}

	@Override
	public boolean deleteUser(User user) {
		try
		{
			sessionFactory.getCurrentSession().delete(user);
			return true;
		}
		catch(Exception e)
		{
			
			return false;
		}
	}

	@Override
	public boolean updateUser(User user) {
		try
		{
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e)
		{
			
			return false;
		}
	}

	@Override
	public User getUser(int userId) {
		try
		{
			Session session=sessionFactory.openSession();
			User user= session.get(User.class, userId);
			session.close();
			return user;
		}
		catch(Exception e)
		{
			
			return null;
		}
	}

	@Override
	public List<User> listUser() {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		List<User> li= session.createQuery("from User").list();
		session.getTransaction().commit();
		return li;
	}
}
