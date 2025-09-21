package com.nitish.users.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nitish.users.dto.ExamBooking;
import com.nitish.users.dto.ExaminationVoucher;
import com.nitish.users.dto.Login;
import com.nitish.users.dto.Question;
import com.nitish.users.entities.User;
import com.nitish.users.service.UserService;

import io.swagger.v3.oas.annotations.Operation;


@RestController
public class UserController {

	//Loggers
	Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

//	GetMapping to Fetch all the user data
	@Operation(summary = "All the users records are fetched")
	@GetMapping("/users")
	public List<User> getAllUser() {
		List<User> user = userService.getAllUsers();
		return user;
	}

//	GetMapping to Fetch all the user data by ID
	@Operation(summary = "Users records are fetched on the basis of usertId")
	@GetMapping("/users/{id}")
	public ResponseEntity<ResponseInfo> getUserById(@PathVariable("id") int id, HttpServletRequest request) {
		userService.getUserById(id);
		String message = "User Found";
		logger.info("Inside the method [getUserById] of controller:" + message);
		ResponseInfo rinfo = new ResponseInfo(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED.name(), message,
				request.getRequestURI());
		return new ResponseEntity<ResponseInfo>(rinfo, HttpStatus.ACCEPTED);

	}

//	PostMapping to insert data of user into Login DTO
	@Operation(summary = "Users records are inserted into Login DTO")
	@PostMapping("/users/logins")
	public ResponseEntity<ResponseInfo> insertData(@Valid @RequestBody User user, HttpServletRequest request) {
		Login login = new Login(user.getFirstName(), user.getPassword(),"user",true);
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForEntity("", login, ResponseInfo.class);
	}

//	 PostMapping to insert data of user
	@Operation(summary = "Users records are added")
	@PostMapping("/users")
	public ResponseEntity<ResponseInfo> addUser(@Valid @RequestBody User user, HttpServletRequest request) {
		String message = userService.addUser(user);
		logger.info("Inside the method [addUsers] of controller:" + message);
		ResponseInfo info = new ResponseInfo(HttpStatus.CREATED.value(), HttpStatus.CREATED.name(), message,
				request.getRequestURI());
		return new ResponseEntity<ResponseInfo>(info, HttpStatus.CREATED);

	}

//	PutMapping to update data of user by ID
	@Operation(summary = "Users records are updated on the basis of usertId")
	@PutMapping("/users/{id}")
	public ResponseEntity<ResponseInfo> updateUserById(@Valid @RequestBody User user, @PathVariable("id") int id,
			HttpServletRequest request) {

		userService.updateUserById(user, id);
		String message = "User Record updated succesfully!";
		logger.info("Inside the method [updateUser] of controller:" + message);
		ResponseInfo rinfo = new ResponseInfo(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED.name(), message,
				request.getRequestURI());
		return new ResponseEntity<ResponseInfo>(rinfo, HttpStatus.ACCEPTED);

	}

//	DeleteMapping to delete data of user by ID
	@Operation(summary = "User records are deleted on the basis of usertId")
	@DeleteMapping("/users/{id}")
	public ResponseEntity<ResponseInfo> deleteUserById(@PathVariable("id") int id, HttpServletRequest request) {
		userService.deleteUserById(id);
		String message = "User data deleted successfully!";
		logger.info("Inside the method [deleteById] of controller:" + message);
		ResponseInfo rinfo = new ResponseInfo(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED.name(), message,
				request.getRequestURI());
		return new ResponseEntity<ResponseInfo>(rinfo, HttpStatus.ACCEPTED);
	}
	
//	Get Examination Voucher Details
	@Operation(summary = "Get Examination Voucher for Exam")
	@GetMapping("/users/examinationVouchers")
	public List<ExaminationVoucher> getExamVoucher(){
		RestTemplate restTemplate = new RestTemplate();
		List<ExaminationVoucher> examinationVouchers = Arrays.asList(restTemplate.getForObject("",ExaminationVoucher[].class ));
		return examinationVouchers;	
	}
	
//	Get Examination Voucher by Id and Book the Exam
	@Operation(summary = "Get the Examination Voucher by Id")
	@PostMapping("users/{id}/examinationVouchers/{examVoucherNumber}")
	public ResponseEntity<ResponseInfo> getExamVoucherById(@PathVariable("id") int id,@PathVariable("examVoucherNumber") int examVoucherNumber, HttpServletRequest request) {
		RestTemplate restTemplate = new RestTemplate();
		ExaminationVoucher examinationVoucher = restTemplate.getForObject("http://localhost:8086/examinationVouchers/"+examVoucherNumber, ExaminationVoucher.class);
		//ExamBooking booking = new ExamBooking(null,id,examinationVoucher.getExaminationName(),examVoucherNumber);
		//restTemplate.postForEntity("", booking, ResponseInfo.class);
		String message = "Booking Confirm";
		ResponseInfo rinfo = new ResponseInfo(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED.name(), message,
				request.getRequestURI());
		return new ResponseEntity<ResponseInfo>(rinfo, HttpStatus.ACCEPTED);
	}
	
//	Fetch All the exams
	@GetMapping("/users/exams")
	@Operation(summary = "show Exam")
	public List<ExamBooking> showExam() {
		RestTemplate restTemplate = new RestTemplate();
		List<ExamBooking> examinations = Arrays.asList(restTemplate.getForObject("", ExamBooking[].class));
		return examinations;
	}
	
//	Give the Exam and Fetch the Question based on examId
	@GetMapping("/users/takeexams/{examId}")
	public List<Question> takeExam(@PathVariable("examId") int examId, HttpServletRequest request){
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getForObject(""+examId, ExamBooking.class);
		List<Question> question =  Arrays.asList(restTemplate.getForObject("", Question[].class));
		return question;	
	}
	
	
}
