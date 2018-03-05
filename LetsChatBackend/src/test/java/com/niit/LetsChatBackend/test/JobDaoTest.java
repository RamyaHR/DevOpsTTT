package com.niit.LetsChatBackend.test;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.LetsChatBackend.Dao.JobDao;
import com.niit.LetsChatBackend.model.Job;

public class JobDaoTest {

private static AnnotationConfigApplicationContext context;
	
	private static JobDao jobDao;
	
	private static Job job;
	
	@BeforeClass
	public static void setup()
	{
		Job job= new Job();
	}
	
	@AfterClass
	public static void teardown()
	{
		job=null;
	}

	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		
		jobDao=(JobDao)context.getBean("jobDao");
	}
	
	
//	@Test
	public void addJobTest()
	{
//		Timestamp dt_date = new Timestamp(System.currentTimeMillis());
		Job job= new Job();
		job.setJobId(301);
		job.setJobTitle("Developer");
		job.setJobDescription("java Platform");
		job.setSkillsRequired("c,c++, java");
		job.setLocation("Bangalore");
		job.setPostedOn(new Timestamp(System.currentTimeMillis()));
		assertEquals("Job is saved",true, jobDao.addJob(job));
	
		job.setJobId(302);
		job.setJobTitle("Designer");
		job.setJobDescription("UI/UX");
		job.setSkillsRequired("photoshop, corel");
		job.setLocation("Mysore");
		job.setPostedOn(new Timestamp(System.currentTimeMillis()));
		assertEquals("Job is saved",true, jobDao.addJob(job));
		
		job.setJobId(303);
		job.setJobTitle("Tester");
		job.setJobDescription("Selenium");
		job.setSkillsRequired("java, Qtp");
		job.setLocation("Dharwad");
		job.setPostedOn(new Timestamp(System.currentTimeMillis()));
		assertEquals("Job is saved",true, jobDao.addJob(job));
	}
	
//	@Test
	public void testgetJob()
	{
		job= jobDao.getJob(301);
		 assertEquals("Successfully retrieved the job", "Developer", job.getJobTitle());
	       
	}
	
//	@Test
	public void testupdateJob()
	{
		job= jobDao.getJob(301);
		job.setJobTitle("Java Developer");
		 assertEquals("Successfully updated the job", true, jobDao.updateJob(job));
	       
	}
	
//	@Test
	public void testdeleteJob()
	{
		job= jobDao.getJob(302);
		
		assertEquals("Successfully deleted the user", true, jobDao.deleteJob(job));
		 	       
	}
	
	
	@Test
	public void testlistJob()
	{
		
		assertEquals("Successfully fetched the job list", 2, jobDao.listJob().size());
		 	       
	}
	

}
