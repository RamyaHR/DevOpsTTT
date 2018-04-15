package com.niit.LetsChatMiddleWare.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.niit.LetsChatBackend.Dao.ProfilePictureDao;
import com.niit.LetsChatBackend.model.ProfilePicture;
import com.niit.LetsChatBackend.model.UserDetail;

@RestController
public class ProfilePictureController {

	@Autowired
	ProfilePictureDao profilePictureDao;
	
	@RequestMapping(value="/doUpload",method=RequestMethod.POST)
	public ResponseEntity<?> uploadPicture(@RequestParam(value="file")CommonsMultipartFile fileupload,HttpSession session)
	{
	
		UserDetail user=(UserDetail)session.getAttribute("user");
		System.out.println("LoginName:"+user.getLoginname());
		if(user==null) 
		{
			return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
		}
		else
		{
			ProfilePicture profilePicture=new ProfilePicture();
			profilePicture.setLoginname(user.getLoginname());
			profilePicture.setImage(fileupload.getBytes());
			profilePictureDao.save(profilePicture);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="/getImage/{loginname}")
	public @ResponseBody byte[] getProfilePic(@PathVariable("loginname") String loginname)
	{
		
		ProfilePicture profilePicture=profilePictureDao.getProfilePicture(loginname);
		
		if(profilePicture==null)
		{
			return null;
		}
		else
		{
			return profilePicture.getImage();
		}
	}
	
}
