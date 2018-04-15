package com.niit.LetsChatMiddleWare.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.LetsChatBackend.Dao.JobDao;
import com.niit.LetsChatBackend.model.ApplyJob;
import com.niit.LetsChatBackend.model.Blog;
import com.niit.LetsChatBackend.model.Job;

@RestController
public class JobController {

	@Autowired
	JobDao jobDao;
	
	//--------------------------Add job------------		Working	
	
	@PostMapping("/addJob")
	public ResponseEntity<String> addJob(@RequestBody Job job)
	{
		job.setLastDateApply(new Date());
		if(jobDao.addJob(job))
		{
			return new ResponseEntity<String>("Job added", HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Job adding failed", HttpStatus.NOT_FOUND);
		}
	}
	
	//----------------------Listing jobs-----------			Working
	
	@GetMapping(value="/listJobs")
	public ResponseEntity<List<Job>> listJob()
	{
		List<Job> listJobs= jobDao.listJob();
		if(listJobs.size()>0)
		{
			return new ResponseEntity<List<Job>>(listJobs, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Job>>(listJobs, HttpStatus.NOT_FOUND);
		}
	}
	
	
	//-----------------------updateJob-------------			Working
	
	@PostMapping("/updateJob/{jobId}")
	public ResponseEntity<String> updateJob(@PathVariable("jobId")int jobId, @RequestBody Job job){
	System.out.println("Updating Job " + jobId);
	Job job1 = jobDao.getJob(jobId);
	if (job1 == null) {
		System.out.println("Job with jobId " + jobId + " Not Found");
		return new ResponseEntity<String>("Update Job Failue", HttpStatus.NOT_FOUND);
	}
	
	job.setJobId(jobId);
	job1.setJobTitle(job.getJobTitle());
	job1.setLastDateApply(new Date());
	job1.setJobDescription(job.getJobDescription());
	job1.setLocation(job.getLocation());
	job1.setPostedOn(new Date());
	job1.setSalary(job.getSalary());
	job1.setSkillsRequired(job.getSkillsRequired());

	jobDao.updateJob(job1);
	return new ResponseEntity<String>("Update Job Success", HttpStatus.OK);
}
	
	//--------------------------getjob--------------------- Working 
	
	@GetMapping("/getJob/{jobId}")
	public ResponseEntity<Job> getJob(@PathVariable("jobId")int jobId)
	{
		Job job= jobDao.getJob(jobId);
		if(job==null)
		{
			return new ResponseEntity<Job>(job, HttpStatus.NOT_FOUND);
		}
		else
		{
			return new ResponseEntity<Job>(job, HttpStatus.OK);
		}
	}
	
	//-------------------Applyjob----------------------  Working
	
	@PostMapping("/applyJob")
	public ResponseEntity<String> addJob(@RequestBody ApplyJob applyJob)
	{
		applyJob.setApplyDate(new Date());
		applyJob.setJobId(applyJob.getJobId());
		if(jobDao.applyJob(applyJob))
		{
			return new ResponseEntity<String>("Applied Job Success", HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Applying job failed", HttpStatus.NOT_FOUND);
		}
	}
	
	
	//---------------------------list applied jobs-----------
	@GetMapping("/listAppliedJobs")
	public ResponseEntity<List<ApplyJob>> listAppliedJobs()
	{
		List<ApplyJob> listAppliedJobs= jobDao.getAllAppliedJobDetails();
		if(listAppliedJobs.size()>0)
		{
			return new ResponseEntity<List<ApplyJob>>(listAppliedJobs, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<ApplyJob>>(listAppliedJobs, HttpStatus.NOT_FOUND);
		}
	}
}
