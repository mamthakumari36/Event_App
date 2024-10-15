package org.jsp.event_App.controller;

import org.jsp.event_App.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "/profiles")
public class ProfileController 
{
	@Autowired
	private ProfileService profileService;

//	MultipartFile = this is used to catch any file
	@PostMapping
	public ResponseEntity<?> saveProfile(@RequestParam MultipartFile file)
	{
		return profileService.saveProfile(file);
	}
	
	
}
