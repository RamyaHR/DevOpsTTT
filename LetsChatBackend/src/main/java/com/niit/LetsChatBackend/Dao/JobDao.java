package com.niit.LetsChatBackend.Dao;

import java.util.List;

import com.niit.LetsChatBackend.model.ApplyJob;
import com.niit.LetsChatBackend.model.Job;

public interface JobDao {

	public boolean addJob(Job job);
	public boolean deleteJob(Job job);
	public boolean updateJob(Job job);
	public Job getJob(int jobId);
//	public boolean approveJob(Job job);
//	public boolean rejectJob(Job job);
	public List<Job> listJob();
	public List<Job> getAllAppliedJobDetails();
	public boolean applyJob(ApplyJob applyJob);
	
}
