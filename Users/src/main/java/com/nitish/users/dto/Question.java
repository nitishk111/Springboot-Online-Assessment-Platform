package com.nitish.users.dto;

import java.util.Set;

/**
 * 
 * DTO class of Question It will keep details of all question
 *
 */
public class Question {

//	variables
	private int questionId;
	private String questionName;
	private Set<Option> option;
	private int examId;
	private String correctOption;
	private int subjectId;

//	getters and setters
	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestionName() {
		return questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}

	public Set<Option> getOption() {
		return option;
	}

	public void setOption(Set<Option> option) {
		this.option = option;
	}

	public int getExamId() {
		return examId;
	}

	public void setExamId(int examId) {
		this.examId = examId;
	}

	public String getCorrectOption() {
		return correctOption;
	}

	public void setCorrectOption(String correctOption) {
		this.correctOption = correctOption;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

//	Field Constructor
	public Question(int questionId, String questionName, Set<Option> option, int examId, String correctOption,
			int subjectId) {
		super();
		this.questionId = questionId;
		this.questionName = questionName;
		this.option = option;
		this.examId = examId;
		this.correctOption = correctOption;
		this.subjectId = subjectId;
	}

//	Default Constructor
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Overriding toString method
	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", questionName=" + questionName + ", option=" + option
				+ ", examId=" + examId + ", correctOption=" + correctOption + ", subjectId=" + subjectId + "]";
	}

}