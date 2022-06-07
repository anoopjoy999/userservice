package com.bezkoder.spring.files.upload.db.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.spring.files.upload.db.message.UserObj;
import com.bezkoder.spring.files.upload.db.model.User;
import com.bezkoder.spring.files.upload.db.repository.UserRepository;

@Service
public class UserStorageService {
	
	  @Autowired
	  private UserRepository userDBRepository;
	  
	  public User storeUser(UserObj user) throws IOException {
		    User obj = new User(user);
		     return userDBRepository.save(obj);
		  }
	  
	  public User getUser(UserObj user) throws IOException {
		     return userDBRepository.findByUserName(user.getUsername());
		  }
	  

}
