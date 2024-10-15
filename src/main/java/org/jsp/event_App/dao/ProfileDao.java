package org.jsp.event_App.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.event_App.entity.Profile;

public interface ProfileDao 
{
	 Profile saveProfile(Profile profile);
	 
	 Profile updateProfile(Profile profile);
	 
	 Optional<Profile> findProfileById(int id);
	 
	 List<Profile> findAllProfile();
	 
}
