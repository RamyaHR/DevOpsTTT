package com.niit.LetsChatBackend.Dao;

import com.niit.LetsChatBackend.model.ProfilePicture;

public interface ProfilePictureDao {

	public void save(ProfilePicture profilePicture);
	public ProfilePicture getProfilePicture(String loginname);
}
