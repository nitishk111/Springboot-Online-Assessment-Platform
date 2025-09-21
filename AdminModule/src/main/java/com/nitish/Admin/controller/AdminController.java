package com.nitish.Admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nitish.Admin.dto.Exam;
import com.nitish.Admin.dto.ExamVoucher;
import com.nitish.Admin.dto.Subject;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class AdminController {
	
	Logger logger=LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	RestTemplate restTemplate;
	
	//Consuming ExamVoucher microservice 
	
	@PutMapping("admins/examVouchers")
	@Operation(summary = "To update Price")
	ResponseInfo updateExamVoucher(@RequestBody ExamVoucher voucher,HttpServletRequest request) {
		restTemplate.put("http://localhost:8086/examinationVouchers",voucher);
		String message="Updated Successfully!!";
		logger.info("Inside the method [updateExamVoucher] of controller:"+message);
		return new ResponseInfo(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED.name(),message,request.getRequestURI());
	}
	
	//Consuming Exam microservice
	
	@PutMapping("admins/exams")
	@Operation(summary = "To make changes in Examination")
	ResponseInfo updateExam(@RequestBody Exam exam,HttpServletRequest request) {
		restTemplate.put("http://localhost:8084/examinations",exam);

		String message="Updated Successfully!!";
		logger.info("Inside the method [updateExam] of controller:"+message);
		return new ResponseInfo(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED.name(),message,request.getRequestURI());
	}
	
	//Consuming Subject microservice
	
	@PutMapping("admins/subjects/{subjectId}")
	@Operation(summary = "To make change in Subject")
	ResponseInfo updateSubject(@RequestBody Subject subject,@PathVariable("subjectId") int subjectId,HttpServletRequest request) {
		restTemplate.put("http://localhost:8088/subjects/{id}"+subjectId,subject);
		String message="Updated Successfully!!";
		logger.info("Inside the method [updateSubjectupdateSubject] of controller:"+message);
		return new ResponseInfo(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED.name(),message,request.getRequestURI());
	}
}
