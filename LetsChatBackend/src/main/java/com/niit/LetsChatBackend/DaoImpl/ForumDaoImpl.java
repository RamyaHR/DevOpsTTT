package com.niit.LetsChatBackend.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.LetsChatBackend.Dao.ForumDao;
import com.niit.LetsChatBackend.model.Blog;
import com.niit.LetsChatBackend.model.BlogComment;
import com.niit.LetsChatBackend.model.Forum;
import com.niit.LetsChatBackend.model.ForumComment;

@Repository("forumDao")
@Transactional
public class ForumDaoImpl implements ForumDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public ForumDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	@Transactional
	public boolean addForum(Forum forum) {
		try
		{
			sessionFactory.getCurrentSession().save(forum);
			return true;
		}
		catch(Exception e)
		{
			
			return false;
		}
	}

	@Override
	public boolean deleteForum(Forum forum) {
		try
		{
			sessionFactory.getCurrentSession().delete(forum);
			return true;
		}
		catch(Exception e)
		{
			
			return false;
		}
	}

	@Override
	public boolean updateForum(Forum forum) {
		try
		{
			sessionFactory.getCurrentSession().update(forum);
			return true;
		}
		catch(Exception e)
		{
			
			return false;
		}
	}

	@Override
	public Forum getForum(int forumId) {
		try
		{
			Session session=sessionFactory.openSession();
			Forum forum= session.get(Forum.class, forumId);
			session.close();
			return forum;
		}
		catch(Exception e)
		{
			
			return null;
		}
	}

	@Override
	public boolean approveForum(Forum forum) {
		try
		{
			forum.setStatus("A");
			sessionFactory.getCurrentSession().update(forum);
			return true;
		}
		catch(Exception e)
		{
			
			return false;
		}
	}

	@Override
	public boolean rejectForum(Forum forum) {
		try
		{
			forum.setStatus("NA");
			sessionFactory.getCurrentSession().update(forum);
			return true;
		}
		catch(Exception e)
		{
			
			return false;
		}
	}

	@Override
	public List<Forum> listForum() {
		try{
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			Query query= session.createQuery("from Forum");
			List<Forum> listForums=query.list();
			session.close();
			return listForums;
		}
		catch(Exception e)
		{
			return null;
		}
		
	}

	@Override
	public boolean addForumComment(ForumComment forumComment) {
		try
		{
			sessionFactory.getCurrentSession().save(forumComment);
			return true;
		}
		catch(Exception e)
		{
			
			return false;
		}
	}

	@Override
	public boolean deleteForumComment(ForumComment forumComment) {
		try
		{
			sessionFactory.getCurrentSession().delete(forumComment);
			return true;
		}
		catch(Exception e)
		{
			
			return false;
		}
	}

	@Override
	public ForumComment getForumComment(int commentId) {
		try
		{
			Session session=sessionFactory.openSession();
			ForumComment forumComment=(ForumComment)session.get(ForumComment.class, commentId);
			return forumComment;
		}
		catch(Exception e)
		{
			
			return null;
		}
	}

	@Override
	public List<ForumComment> listForumComments(int forumId) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from ForumComment where forumId=:forumId");
		query.setParameter("forumId", new Integer(forumId));
		List<ForumComment> listForumComments=query.list();
		return listForumComments;
	}
}
