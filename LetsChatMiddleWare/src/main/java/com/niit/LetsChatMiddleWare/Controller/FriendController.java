package com.niit.LetsChatMiddleWare.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.LetsChatBackend.Dao.FriendDao;
import com.niit.LetsChatBackend.model.Friend;

@RestController
public class FriendController {

	@Autowired
	FriendDao friendDao;
	
	@PostMapping("/sendFriendRequest")
	public ResponseEntity<String> SendFriendRequest(@RequestBody Friend friend)
	{
		if(friendDao.SendFriendRequest(friend))
		{
			return new ResponseEntity<String>("Friend request sent", HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Sending failure", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/deleteFriendRequest/{friendId}")
	public ResponseEntity<String> deleteFriendRequest(@PathVariable("friendId")int friendId)
	{
		if(friendDao.DeleteFriendRequest(friendId))
		{
			return new ResponseEntity<String>("Friend request deleted", HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Failed to delete", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/acceptFriendRequest/{friendId}")
	public ResponseEntity<String> acceptFriendRequest(@PathVariable("friendId") int friendId)
	{
		if(friendDao.acceptFriendRequest(friendId))
		{
			return new ResponseEntity<String>("Friend Request Accepted", HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Accept request failure", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/showAllFriends")
	public ResponseEntity<List<Friend>> showAllFriends(HttpSession session)
	{
		List<Friend> listAllFriends=friendDao.ShowAllFriends("abcd");
		if(listAllFriends.size()>0)
		{
			return new ResponseEntity<List<Friend>>(listAllFriends, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Friend>>(listAllFriends, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/showPendingRequests")
	public ResponseEntity<List<Friend>> showPendingFriendRequest(HttpSession session)
	{
		List<Friend> listPendingRequests= friendDao.ShowRequestPendingList("abcd");
		if(listPendingRequests.size()>0)
		{
			return new ResponseEntity<List<Friend>>(listPendingRequests, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<List<Friend>>(listPendingRequests, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
