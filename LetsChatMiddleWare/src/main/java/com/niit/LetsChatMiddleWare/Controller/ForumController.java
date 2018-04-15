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

import com.niit.LetsChatBackend.Dao.ForumDao;
import com.niit.LetsChatBackend.model.Forum;
import com.niit.LetsChatBackend.model.ForumComment;

@RestController
public class ForumController {

	@Autowired
	ForumDao forumDao;
	
	//-----------ListForum--------------//						Working
	@GetMapping(value="/listForums")
	public ResponseEntity<List<Forum>> getlistForums()
	{
		List<Forum> listForums= forumDao.listForum();
		if(listForums.size()>0)
		{
			return new ResponseEntity<List<Forum>>(listForums, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Forum>>(listForums, HttpStatus.NOT_FOUND);
		}
	}

	//-------------Add Forum---------------//				Working
	@PostMapping(value="/addForum")
	public ResponseEntity<String> addForum(@RequestBody Forum forum)
	{
		forum.setForumDate(new Date());
//		forum.setUserName("abcd1");
		forum.setStatus("A");
		
		if(forumDao.addForum(forum))
		{
			return new ResponseEntity<String>("Success", HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Failure", HttpStatus.NOT_FOUND);
		}
	}
	
	//---------------DeleteForum-------------------				Working				
	@PostMapping(value="/deleteForum")
	public ResponseEntity<String> deleteForum(@RequestBody Forum forum)
	{
		if(forumDao.deleteForum(forum))
		{
			return new ResponseEntity<String>("Success", HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Failure", HttpStatus.NOT_FOUND);
		}
	}
	
	//---------------------Update Forum-------------------//		Working
	@PostMapping(value = "/updateForum/{forumId}")
	public ResponseEntity<String> updateForum(@PathVariable("forumId") int forumId, @RequestBody Forum forum) {
		System.out.println("Updating Forum " + forumId);
		Forum forum1 = forumDao.getForum(forumId);
		if (forum1 == null) {
			System.out.println("Forum with forumId " + forumId + " Not Found");
			return new ResponseEntity<String>("Update Forum Failue", HttpStatus.NOT_FOUND);
		}
		
		forum1.setForumContent(forum.getForumContent());
		forum1.setForumName(forum.getForumName());
		forum1.setForumDate(new Date());
		forum1.setStatus(forum.getStatus());
		forum1.setUserName(forum.getUserName());
		
		forumDao.updateForum(forum1);
		return new ResponseEntity<String>("Update Forum Success", HttpStatus.OK);
	}

	// -----------------------Get Forum --------------------//		Working

	@GetMapping(value = "/getForum/{forumId}")
	public ResponseEntity<String> getForum(@PathVariable("forumId") int forumId) {
		System.out.println("Get Forum " + forumId);
		Forum forum = forumDao.getForum(forumId);
		if (forum == null) {
			return new ResponseEntity<String>("Get forum failure", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<String>("Get forum Success", HttpStatus.OK);
		}
	}

	// -----------------------Approve Forum ------------//		Working

	@PostMapping(value = "/approveForum/{forumId}")
	public ResponseEntity<String> approveForum(@PathVariable("forumId") int forumId) {
		System.out.println("Approve Forum with Forum ID: " + forumId);
		Forum forum = forumDao.getForum(forumId);
		if (forum == null) {
			System.out.println("Not forum with forum Id: " + forumId + " found for Approval");
			return new ResponseEntity<String>("No Forum found for Approval", HttpStatus.NOT_FOUND);
		} else {
			forum.setStatus("A");
			forumDao.approveForum(forum);
			return new ResponseEntity<String>("Forum " + forumId + " Approved Successfully", HttpStatus.OK);
		}
	}

	// --------------------Reject Forum ------------------//			Working

	@PostMapping(value = "/rejectForum/{forumId}")
	public ResponseEntity<String> rejectForum(@PathVariable("forumId") int forumId) {
		System.out.println("Disapprove Forum with Forum ID: " + forumId);
		Forum forum = forumDao.getForum(forumId);
		if (forum == null) {
			System.out.println("Not forum with forum Id: " + forumId + " found for Approval");
			return new ResponseEntity<String>("No Forum with Forum Id " + forumId + " found for Disapproval",
					HttpStatus.NOT_FOUND);
		} else {
			forum.setStatus("NA");
			forumDao.rejectForum(forum);
			return new ResponseEntity<String>("Forum " + forumId + " Disapproved Successfully", HttpStatus.OK);
		}
	}

	
	// ---------------- Add ForumComments --------------------//Working

		@PostMapping(value = "/addForumComment")  
		public ResponseEntity<String> addForumComments(@RequestBody ForumComment forumComment) {
			forumComment.setCommentDate(new Date());
			forumComment.setForumId(forumComment.getForumcommmentID());
			forumComment.setCommentText(forumComment.getCommentText());
			forumComment.setUsername(forumComment.getUsername());
			
//			Forum forum = forumDao.getForum(1);
//			String username = forum.getUserName();
//			int forumId = forum.getForumId();
//			forumComment.setForumId(forumId);
//			forumComment.setUsername(username);
			if (forumDao.addForumComment(forumComment)) {
				return new ResponseEntity<String>("ForumComment Added- Success", HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("ForumComment insertion failed", HttpStatus.NOT_FOUND);
			}
		}

		// -------------------------Delete ForumComment	 ---------------//		Working

		@PostMapping(value = "/deleteForumComment/{forumcommmentID}")    
		public ResponseEntity<String> deleteForumComment(@PathVariable("forumcommmentID") int forumcommmentID) {
			System.out.println("Delete forumComment with forumcommmentID: " + forumcommmentID);
			ForumComment forumComment = forumDao.getForumComment(forumcommmentID);
			if (forumComment == null) {
				System.out.println("No forum " + forumcommmentID + " found to delete");
				return new ResponseEntity<String>("No forumcomment with comment Id: " + forumcommmentID + " found to delete",
						HttpStatus.NOT_FOUND);
			} else {
				forumDao.deleteForumComment(forumComment);
				return new ResponseEntity<String>("ForumComment with comment Id " + forumcommmentID + " deleted successfully", HttpStatus.OK);
			}

		}
		// -----------------------Get ForumComment ---------------//			Working

		@GetMapping(value = "/getForumComment/{forumcommmentID}")    
		public ResponseEntity<String> getForumComment(@PathVariable("forumcommmentID") int forumcommmentID) {
			System.out.println("Get ForumComment " + forumcommmentID);
			ForumComment forumComment = forumDao.getForumComment(forumcommmentID);
			if (forumComment == null) {
				return new ResponseEntity<String>("Get forumComment failure", HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<String>("Get forumComment Success", HttpStatus.OK);
			}
		}

		// -----------------list ForumComments ---------------------------------
		@GetMapping(value = "/listForumComments")
		public ResponseEntity<List<ForumComment>> listForumComments() {
			List<ForumComment> listForumComments = forumDao.listForumComments(1);
			if (listForumComments.size() != 0) {
				return new ResponseEntity<List<ForumComment>>(listForumComments, HttpStatus.OK);
			} else {
				return new ResponseEntity<List<ForumComment>>(listForumComments, HttpStatus.NOT_FOUND);
			}
		}
}
