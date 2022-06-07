package com.bezkoder.spring.files.upload.db.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.bezkoder.spring.files.upload.db.message.UserObj;

@Entity
@Table(name = "user")
public class User {
	
	 @Id
	  @GeneratedValue(generator = "uuid")
	  @GenericGenerator(name = "uuid", strategy = "uuid2")
	  private String id;

	  private String firstname;

	  private String lastname;
	  
	  private String email;

	  private String username;
	  
	  private String userpassword;
	  
	  

	public User() {
		super();
	}

	public User(String firstname, String lastname, String email, String username, String userpassword) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.username = username;
		this.userpassword = userpassword;
	}

	public User(UserObj user) {
		super();
		this.firstname = user.getUsername();
		this.lastname = user.getLastname();
		this.email = user.getEmail();
		this.username = user.getUsername();
		this.userpassword = user.getUserpassword();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

}
