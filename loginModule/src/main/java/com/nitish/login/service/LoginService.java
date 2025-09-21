package com.nitish.login.service;


import java.util.List;
import java.util.Optional;

import com.nitish.login.entity.Login;
import com.nitish.login.exceptions.PasswordNotFoundException;
import com.nitish.login.exceptions.RecordNotFoundException;
import com.nitish.login.exceptions.UserNameNotFoundException;
import com.nitish.login.repository.LoginRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	Logger logger=LoggerFactory.getLogger(LoginService.class); 
	
	@Autowired
    LoginRepository loginRepository;
	
	//This is to add users in database
	
	public String addUsers(Login register) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodePassword = passwordEncoder.encode(register.getPassword());//To encrypt password
		register.setPassword(encodePassword);
		Login saveDetail = loginRepository.save(register);//To save user details in database
		if (saveDetail != null) {
			return "Data Saved Successfully";
		} 
		else {
			return "Data Not Saved Successfully";
		}

	}
	
	//This is to validate user and response will send to controller
	
	public String validateUsers(Login login){ 
		Optional<Login> optional=loginRepository.findById(login.getUsername());//To check whether the detail of the given id is present or not
		if(optional.isPresent()) { 
			Login dbUser=optional.get(); 
			BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
		    Boolean value=passwordEncoder.matches(login.getPassword(),dbUser.getPassword())?true:false;//matches the provided credentials with stored data in database
		    if(value) { 
		    	return "login Successfull!!"; 
		    }
		    else{ 
		    	logger.error("PasswordNotFoundException occurred");
		    	throw new PasswordNotFoundException("Password Incorrect");
		    }
		} 
		else { 
			logger.error("UserNameNotFoundException occurred");
			throw new UserNameNotFoundException("Username not found");
		}
	}
	
	//This will send list of login users to controller
	
	public List<Login> fetchAllData(){
		List<Login> list=loginRepository.findAll();//To fetch all data of database
		if(!list.isEmpty()) {
			return list;
		}
		else {
			logger.error("RecordNotFoundException occured");
			throw new RecordNotFoundException("No Record");
		}
	}
	
	//To remove user
	
	public String removeUser(String username) {
		Optional<Login> details=loginRepository.findById(username);//To fetch the details of given id
		if(details.isPresent()) {
			loginRepository.deleteById(username);//to remove the id
			return "Logout Successfully!!";
		}
		else {
			logger.error("UserNameNotFoundException occured");
			throw new UserNameNotFoundException("Username not found");
		}
	}
}
	
