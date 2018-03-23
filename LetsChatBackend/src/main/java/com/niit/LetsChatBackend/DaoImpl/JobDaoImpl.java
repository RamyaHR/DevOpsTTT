package com.niit.LetsChatBackend.DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.LetsChatBackend.Dao.JobDao;
import com.niit.LetsChatBackend.model.ApplyJob;
import com.niit.LetsChatBackend.model.Job;

@Repository("jobDao")
@Transactional
public class JobDaoImpl implements JobDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public JobDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	@Transactional
	public boolean addJob(Job job) {
		try
		{
			sessionFactory.getCurrentSession().save(job);
			return true;
		}
		catch(Exception e)
		{
			
			return false;
		}
	}

	@Override
	public boolean deleteJob(Job job) {
		try
		{
			sessionFactory.getCurrentSession().delete(job);
			return true;
		}
		catch(Exception e)
		{
			
			return false;
		}
	}

	@Override
	public boolean updateJob(Job job) {
		try
		{
			sessionFactory.getCurrentSession().update(job);
			return true;
		}
		catch(Exception e)
		{
			
			return false;
		}
	}

	@Override
	public Job getJob(int jobId) {
		try
		{
			Session session=sessionFactory.openSession();
			Job job= session.get(Job.class, jobId);
			session.close();
			return job;
		}
		catch(Exception e)
		{
			
			return null;
		}
	}

//	@Override
//	public boolean approveJob(Job job) {
//		try
//		{
//			job.setStatus("A");
//			sessionFactory.getCurrentSession().update(job);
//			return true;
//		}
//		catch(Exception e)
//		{
//			
//			return false;
//		}
//	}
//
//	@Override
//	public boolean rejectJob(Job job) {
//		try
//		{
//			job.setStatus("NA");
//			sessionFactory.getCurrentSession().update(job);
//			return true;
//		}
//		catch(Exception e)
//		{
//			
//			return false;
//		}
//	}

	@Override
	public List<Job> listJob() {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		List<Job> li= session.createQuery("from Job").list();
		session.getTransaction().commit();
		return li;
	}

	@Override
	public List<Job> getAllAppliedJobDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean applyJob(ApplyJob applyJob) {
		// TODO Auto-generated method stub
		return false;
	}
}
