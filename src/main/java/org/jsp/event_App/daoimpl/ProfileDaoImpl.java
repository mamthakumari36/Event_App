package org.jsp.event_App.daoimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.event_App.dao.ProfileDao;
import org.jsp.event_App.entity.Profile;
import org.jsp.event_App.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProfileDaoImpl implements ProfileDao
{
	@Autowired
	private ProfileRepository profileRepository;

	@Override
	public Profile saveProfile(Profile profile) {
		return profileRepository.save(profile);
	}

	@Override
	public Profile updateProfile(Profile profile) {
		return profileRepository.save(profile);
	}

	@Override
	public Optional<Profile> findProfileById(int id) {
		return profileRepository.findById(id);
	}

	@Override
	public List<Profile> findAllProfile() {
		return profileRepository.findAll();
	}
	

}
