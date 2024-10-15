package org.jsp.event_App.serviceImpl;

import java.io.File;
import java.io.IOException;

import org.jsp.event_App.dao.ProfileDao;
import org.jsp.event_App.entity.Profile;
import org.jsp.event_App.responsestructure.ResponseStructure;
import org.jsp.event_App.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProfileServiceImpl implements ProfileService {
	@Autowired
	private ProfileDao profileDao;

	private static final String FOLDER_PATH = "C:\\Users\\Lenovo\\Desktop\\Event_Profile\\";

	@Override
	public ResponseEntity<?> saveProfile(MultipartFile file) {

		String name = file.getOriginalFilename();
		String type = file.getContentType();
		String path = FOLDER_PATH + name;

		try {
			file.transferTo(new File(path));
		} catch (Exception e) {
			e.printStackTrace();
		}

		Profile p = Profile.builder().name(name).type(type).path(path).build();

		p = profileDao.saveProfile(p);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value())
				.message("Profile Saved Successfully").body(p).build());
	}

}
