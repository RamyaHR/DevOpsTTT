package com.niit.DevOpsShoppingBackend.DaoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.DevOpsShoppingBackend.Dao.UserDao;
import com.niit.DevOpsShoppingBackend.Model.User;


@Repository("userDao")
@EnableTransactionManagement
@Transactional
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
		List<User> user=(List<User>)sessionFactory.getCurrentSession().createCriteria(User.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return user;
	}


	public boolean insertUser(User user) {
		
		sessionFactory.getCurrentSession().save(user);
		return true;
		
	}

	@Override
	public User get(String userId) {
		
//		return sessionFactory.getCurrentSession().get("User.class", String.valueOf(userId));
		String c1="from User where userId='"+userId+"'";
		Query q1=sessionFactory.getCurrentSession().createQuery(c1);
		List<User> list=(List<User>) q1.list();
		if(list==null|| list.isEmpty())
		{
		return null;}
		else {
			return list.get(0);
		}
		}

	@Override
	public boolean delete(User user) {
		sessionFactory.getCurrentSession().delete(user);
		return true;
		
	}

	@Override
	public boolean updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
		return true;
	}
	
	

	
	
	
}
