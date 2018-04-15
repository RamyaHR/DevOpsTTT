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

import com.niit.LetsChatBackend.Dao.UserDetailDao;
import com.niit.LetsChatBackend.model.UserDetail;

@RestController
public class UserController {

	@Autowired
	UserDetailDao userDetailDao;
	
	
	//-----------------------Register-------------		//Working
	
	@PostMapping(value="/Register")
	public ResponseEntity<String> registerUser(@RequestBody UserDetail userDetail){
		userDetail.setIsOnline("N");
		userDetail.setRole("ROLEUSER");
		
		if(userDetailDao.addUser(userDetail)){
			return new ResponseEntity<String>("User Registered Succesfully",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Error in Registering User . Please try again later..",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	//---------------------Login-------------------			Working
	
	@PostMapping(value="/login")
	public ResponseEntity<UserDetail> checkLogin(@RequestBody UserDetail userDetail, HttpSession session)
	{
		
		if(userDetailDao.checkLogin(userDetail))
		{
			UserDetail tempUser=(UserDetail)userDetailDao.getUser(userDetail.getLoginname());
			userDetailDao.updateOnlineStatus("Y", tempUser);
			session.setAttribute("userDetail", tempUser);
			return new ResponseEntity<UserDetail>(tempUser, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<UserDetail>(userDetail, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	//---------------------Update Online status-------------------//Should be post method
	
	
	@GetMapping(value="/updateOnlineStatus/{status}")					//not working
	public ResponseEntity<String> updateOnlineStatus(@PathVariable String status,@RequestBody UserDetail user){
		System.out.println("Status : "+status);
		if(userDetailDao.updateOnlineStatus(status, user)){
			return new ResponseEntity<String>("Status Updated Succesfully",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Not able to update status succesfully",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	//---------------------------DeleteUser---------------------		Working
	
	@PostMapping("/deleteUser")
	public ResponseEntity<String> deleteUser(@RequestBody UserDetail user){
		UserDetail user1=userDetailDao.getUser(user.getLoginname());
		if(userDetailDao.deleteUser(user1)){
			return new ResponseEntity<String>("User deleted succesfully...",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Problem in deleting User...",HttpStatus.NOT_FOUND);
		}
	}
	
	
	//----------------------------update User-------------------	Working
	
	@PostMapping("/updateUser")
	public ResponseEntity<String> updateUser(@RequestBody UserDetail user){
		
		if(userDetailDao.updateUser(user)){
			return new ResponseEntity<String>("User updated succesfully...",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Problem in updating User...",HttpStatus.NOT_FOUND);
		}
	}
	
	//----------------------getlist of users---------------------		Working
	
	
	@GetMapping(value="/getListOfUsers")
	public ResponseEntity<List<UserDetail>> getUsersList(){
		List<UserDetail> list=userDetailDao.listUser();
		if(list.size() >0){
			return new ResponseEntity<List<UserDetail>>(list,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<List<UserDetail>>(list,HttpStatus.NOT_FOUND);
		}
	}
	
	//--------------------get user by loginname------------------     Working
	
	@GetMapping("/getUser/{loginname}")
	public ResponseEntity<UserDetail> getUser(@PathVariable("loginname")String loginname)
	{
		UserDetail userDetail= userDetailDao.getUser(loginname);
		if(userDetail== null)
		{
			return new ResponseEntity<UserDetail>(userDetail, HttpStatus.NOT_FOUND);
		}
		else
		{
			return new ResponseEntity<UserDetail>(userDetail, HttpStatus.OK);
		}
	}
	
}
