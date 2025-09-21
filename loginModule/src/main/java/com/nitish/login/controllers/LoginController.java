package com.cg.login.controllers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import com.cg.login.entity.Login;
import com.cg.login.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
@RestController
public class LoginController {
	
	Logger logger=LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	LoginService loginService;
	
	//For Registration
	
	@PostMapping("/register")
	@Operation(summary = "For Registration")
	public ResponseEntity<ResponseInfo> addUsers(@Valid @RequestBody Login register,HttpServletRequest request){
		String message=loginService.addUsers(register);	
		logger.info("Inside the method [addUsers] of controller:"+message);
		ResponseInfo rinfo=new ResponseInfo(HttpStatus.CREATED.value(),HttpStatus.CREATED.name(),message,request.getRequestURI());
		return new ResponseEntity<ResponseInfo>(rinfo,HttpStatus.OK);
	}
	
	//For login
	
	@PostMapping("/login") 
	@Operation(summary = "To Login")
	public ResponseEntity<ResponseInfo> validateUsers(@Valid @RequestBody Login login,HttpServletRequest request){
	  String message=loginService.validateUsers(login);
	  logger.info("Inside the method [validateUsers] of controller:"+message);
	  ResponseInfo rinfo=new ResponseInfo(HttpStatus.ACCEPTED.value(),HttpStatus.ACCEPTED.name(),message,request.getRequestURI());
	  return new ResponseEntity<ResponseInfo>(rinfo,HttpStatus.OK); 
	}
	
	//For fetching all registered users data
	
	@GetMapping("/users")
	@Operation(summary = "To Fetch All data")
	public List<Login> fetchAllData(){
		String message="All Data of Users Are Fetched";
		logger.info("Inside the method [fetchAllData] of controller:"+message);
		return loginService.fetchAllData();
	}
	
	//For removing user
	
	@DeleteMapping("/logout/{username}") 
	@Operation(summary = "To Logout ")
	public ResponseEntity<ResponseInfo> removeUser(@PathVariable ("username") String username,HttpServletRequest request){
	  String message=loginService.removeUser(username);
	  logger.info("Inside the method [removeUser] of controller:"+message);
	  ResponseInfo rinfo=new ResponseInfo(HttpStatus.FOUND.value(),HttpStatus.FOUND.name(),message,request.getRequestURI());
	  return new ResponseEntity<ResponseInfo>(rinfo,HttpStatus.OK); 
	}
}
