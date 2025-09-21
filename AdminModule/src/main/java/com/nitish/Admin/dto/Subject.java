package com.nitish.Admin.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


public class Subject {
	private int subId;
	private String subName;
	private String question;
	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Subject(int subId, String subName, String question) {
		super();
		this.subId = subId;
		this.subName = subName;
		this.question = question;
	}
	public int getSubId() {
		return subId;
	}
	public void setSubId(int subId) {
		this.subId = subId;
	}
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	@Override
	public String toString() {
		return "Subject [subId=" + subId + ", subName=" + subName + ", question=" + question + "]";
	}
	
	
	

}
