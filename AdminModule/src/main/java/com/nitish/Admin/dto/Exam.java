package com.nitish.Admin.dto;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Exam {
	private int examId;
	private String examName;
	private int subjectId;
	private double examPrice;
	private String begineeingDateOfExam;
	private String endingDateOfExam;
	private int duration;
	public Exam() {
		super();
	}
	public Exam(int examId,String examName,int subjectId,double examPrice,  String begineeingDateOfExam,String endingDateOfExam, int duration) {
		super();
		this.examId = examId;
		this.examName = examName;
		this.subjectId = subjectId;
		this.examPrice = examPrice;
		this.begineeingDateOfExam = begineeingDateOfExam;
		this.endingDateOfExam = endingDateOfExam;
		this.duration = duration;
	}
	public int getExamId() {
		return examId;
	}
	public void setExamId(int examId) {
		this.examId = examId;
	}
	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public double getExamPrice() {
		return examPrice;
	}
	public void setExamPrice( double examPrice) {
		this.examPrice = examPrice;
	}
	public String getBegineeingDateOfExam() {
		return begineeingDateOfExam;
	}
	public void setBegineeingDateOfExam(String begineeingDateOfExam) {
		this.begineeingDateOfExam = begineeingDateOfExam;
	}
	public String getEndingDateOfExam() {
		return endingDateOfExam;
	}
	public void setEndingDateOfExam(String endingDateOfExam) {
		this.endingDateOfExam = endingDateOfExam;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	@Override
	public String toString() {
		return "Exam [examId=" + examId + ", examName=" + examName + ", subjectId=" + subjectId + ", examPrice="
				+ examPrice + ", begineeingDateOfExam=" + begineeingDateOfExam + ", endingDateOfExam="
				+ endingDateOfExam + ", duration=" + duration + "]";
	}

	
	

}