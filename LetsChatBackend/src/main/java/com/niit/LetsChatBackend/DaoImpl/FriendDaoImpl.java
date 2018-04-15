package com.niit.LetsChatBackend.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.LetsChatBackend.Dao.FriendDao;
import com.niit.LetsChatBackend.model.Friend;
import com.niit.LetsChatBackend.model.UserDetail;

@Repository("friendDao")
@Transactional
public class FriendDaoImpl implements FriendDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public FriendDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	

	@Override
	public boolean SendFriendRequest(Friend friend) {
		try
		{
			friend.setStatus("P");
			sessionFactory.getCurrentSession().save(friend);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean DeleteFriendRequest(int friendId) {
		try
		{
			Session session=sessionFactory.openSession();
			Friend friend=(Friend)session.get(Friend.class, friendId);
			if(friend.getStatus()=="P")
			{
				sessionFactory.getCurrentSession().delete(friend);
				session.close();
				System.out.println("Deleted request");
			}
			else
			{
				System.out.println("Friend request accepted");
			}
			return true;
			
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public List<UserDetail> ShowSuggestedFriend(String loginname) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Friend where loginname=:currentuser and status='A'");
		query.setParameter("currentuser", loginname);
		List<UserDetail> suggestedFriend=(List<UserDetail>)query.list();
		return suggestedFriend;
	}

	@Override
	public List<Friend> ShowAllFriends(String loginname) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Friend where loginname=:currentuser and status='A'");
		query.setParameter("currentuser", loginname);
		List<Friend> listFriends=(List<Friend>)query.list();
		return listFriends;
	}

	@Override
	public List<Friend> ShowRequestPendingList(String loginname) {
		Session session=sessionFactory.openSession();
		Query query= session.createQuery("from Friend where loginname=:curruser and status='P'");
		query.setParameter("currentuser", loginname);
		List<Friend> listFriends1= (List<Friend>)query.list();
		return listFriends1;
	}

	@Override
	public boolean acceptFriendRequest(int friendId) {
		try
		{
			Session session=sessionFactory.openSession();
			Friend friend=(Friend)session.get(Friend.class, friendId);
			friend.setStatus("A");
			sessionFactory.getCurrentSession().update(friend);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

}
