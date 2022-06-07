package com.bezkoder.spring.files.upload.db.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.files.upload.db.message.ResponseMessage;
import com.bezkoder.spring.files.upload.db.message.UserObj;
import com.bezkoder.spring.files.upload.db.model.User;
import com.bezkoder.spring.files.upload.db.service.UserStorageService;

@RestController
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserStorageService storageService;

	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody UserObj user) {
		String message =null;
		try {
			User usero = storageService.getUser(user);
			message = "Uploaded the file successfully";
			return ResponseEntity.status(HttpStatus.OK).body(usero);
		} catch (Exception e) {
			message = "Could not upload the file: ";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(null);
		}
	}

	@PostMapping("/register")
	public ResponseEntity<ResponseMessage> register(@RequestBody UserObj user) {
		String message = null;
		try {
			storageService.storeUser(user);
			message = "Registered successfully: " + user.getFirstname();
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		} catch (Exception e) {
			message = "Could not register: " + user.getFirstname();
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	}

}
