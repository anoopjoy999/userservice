package com.bezkoder.spring.files.upload.db.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.bezkoder.spring.files.upload.db.message.ResponseMessage;
import com.bezkoder.spring.files.upload.db.message.UserObj;
import com.bezkoder.spring.files.upload.db.model.User;
import com.bezkoder.spring.files.upload.db.service.UserStorageService;

//@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
	
	@Mock
    UserStorageService userStorageService;

    @InjectMocks
    private UserController userController; 
	
	@Test
	   public void loginTest() throws Exception{
		Mockito.when(userStorageService.getUser(Mockito.any())).thenReturn(new User());
		ResponseEntity<User> user = userController.login(new UserObj());
		//Mockito.verify(userController.login(new UserObj()));
		assertNotNull(user);
	   }
	
	@Test
	   public void loginTestException() throws Exception{
		Mockito.when(userStorageService.getUser(Mockito.any())).thenThrow(new RuntimeException());
		ResponseEntity<User> user = userController.login(new UserObj());
		//Mockito.verify(userController.login(new UserObj()));
		assertNotNull(user);
	   }
	
	@Test
	   public void registerTest() throws Exception{
		Mockito.when(userStorageService.storeUser(Mockito.any())).thenReturn(Mockito.any());
		ResponseEntity<ResponseMessage> user = userController.register(new UserObj());
		//Mockito.verify(userController.login(new UserObj()));
		assertNotNull(user);
	   }
	
	@Test
	   public void registerTestException() throws Exception{
		Mockito.when(userStorageService.storeUser(Mockito.any())).thenThrow(new RuntimeException());
		ResponseEntity<ResponseMessage> user = userController.register(new UserObj());
		//Mockito.verify(userController.login(new UserObj()));
		assertNotNull(user);
	   }
	
}
