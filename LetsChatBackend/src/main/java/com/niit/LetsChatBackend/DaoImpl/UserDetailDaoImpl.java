package com.niit.LetsChatBackend.DaoImpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.niit.LetsChatBackend.Dao.UserDetailDao;
import com.niit.LetsChatBackend.model.UserDetail;

@Repository("userDetailDao")
@Transactional
public class UserDetailDaoImpl implements UserDetailDao{
	@Autowired
	SessionFactory sessionFactory;
	
	public UserDetailDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	@Transactional
	public boolean addUser(UserDetail userDetail) {
		try
		{
			sessionFactory.getCurrentSession().save(userDetail);
			return true;
		}
		catch(Exception e)
		{
			
			return false;
		}
	}

	@Override
	public boolean deleteUser(UserDetail userDetail) {
		try
		{
			sessionFactory.getCurrentSession().delete(userDetail);
			return true;
		}
		catch(Exception e)
		{
			
			return false;
		}
	}

	@Override
	public boolean updateUser(UserDetail userDetail) {
		try
		{
			sessionFactory.getCurrentSession().update(userDetail);
			return true;
		}
		catch(Exception e)
		{
			
			return false;
		}
	}

	@Override
	public UserDetail getUserbyid(int userId) {
		try
		{
			Session session=sessionFactory.openSession();
			UserDetail user= session.get(UserDetail.class, userId);
			session.close();
			return user;
		}
		catch(Exception e)
		{
			
			return null;
		}
	}

	@Override
	public List<UserDetail> listUser() {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		List<UserDetail> li= session.createQuery("from UserDetail").list();
		session.getTransaction().commit();
		return li;
	}

	@Override
	public boolean checkLogin(UserDetail userDetail) {
		try{
			Session session=sessionFactory.openSession();
			Query query= session.createQuery("from UserDetail where loginname=:loginname and password=:password");
			query.setParameter("loginname", userDetail.getLoginname());
			query.setParameter("password", userDetail.getPassword());
			UserDetail user1=(UserDetail)query.getResultList().get(0);
			
			if(user1==null)
				return false;
			else
				return true;
			
		}
		
		catch(Exception e)
		{
			return false;
		}

	}

	@Override
	public boolean updateOnlineStatus(String status, UserDetail userDetail) {
		try
		{
			userDetail.setIsOnline(status);
			sessionFactory.getCurrentSession().update(userDetail);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public UserDetail getUser(String loginname) {
		Session session = sessionFactory.openSession();
		UserDetail userDetail= (UserDetail)session.get(UserDetail.class, loginname);
		return userDetail;
	}
}
