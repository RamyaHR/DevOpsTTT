package com.niit.LetsChatBackend.DaoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.LetsChatBackend.Dao.ProfilePictureDao;
import com.niit.LetsChatBackend.model.ProfilePicture;

@Repository("profilePictureDao")
public class ProfilePictureDaoImpl implements ProfilePictureDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public ProfilePictureDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	public void save(ProfilePicture profilePicture)
	{
		Session session=sessionFactory.openSession();
		session.save(profilePicture);
		session.flush();
		session.close();
	}
	
	public ProfilePicture getProfilePicture(String loginname)
	{
		Session session=sessionFactory.openSession();
		ProfilePicture profilePicture=(ProfilePicture)session.get(ProfilePicture.class,loginname);
		session.close();
		return profilePicture;
	}
}

