package com.nitish.users.dto;

import java.time.LocalDate;

/**
 * DTO class of Examination It keeps details of all exam 
 * 
 *
 */
public class Examination {

//	variables
	private int examinationId;
	private String examinationName;
	private int subjectId;
	private double examinationPrice;
	private LocalDate beginningDateOfExamination;
	private LocalDate endingDateOfExamination;
	private int duration;

	// getters and setters

	public int getExaminationId() {
		return examinationId;
	}

	public void setExaminationId(int ExaminationId) {
		this.examinationId = ExaminationId;
	}

	public String getExaminationName() {
		return examinationName;
	}

	public void setExaminationName(String ExaminationName) {
		this.examinationName = ExaminationName;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public double getExaminationPrice() {
		return examinationPrice;
	}

	public void setExaminationPrice(double ExaminationPrice) {
		this.examinationPrice = ExaminationPrice;
	}

	public LocalDate getBeginningDateOfExamination() {
		return beginningDateOfExamination;
	}

	public void setBeginningDateOfExamination(LocalDate beginningDateOfExamination) {
		this.beginningDateOfExamination = beginningDateOfExamination;
	}

	public LocalDate getEndingDateOfExamination() {
		return endingDateOfExamination;
	}

	public void setEndingDateOfExamination(LocalDate endingDateOfExamination) {
		this.endingDateOfExamination = endingDateOfExamination;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	// field constructor

	public Examination(int examinationId, String examinationName, int subjectId, double examinationPrice,
			LocalDate beginningDateOfExamination, LocalDate endingDateOfExamination, int duration) {
		super();
		this.examinationId = examinationId;
		this.examinationName = examinationName;
		this.subjectId = subjectId;
		this.examinationPrice = examinationPrice;
		this.beginningDateOfExamination = beginningDateOfExamination;
		this.endingDateOfExamination = endingDateOfExamination;
		this.duration = duration;
	}

	// Default constructor

	public Examination() {
		super();

	}

	// Overriding toString method

	@Override
	public String toString() {
		return "Examination [ExaminationId=" + examinationId + ", ExaminationName=" + examinationName + ", subjectId="
				+ subjectId + ", ExaminationPrice=" + examinationPrice + ", BeginningDateOfExamination="
				+ beginningDateOfExamination + ", endingDateOfExamination=" + endingDateOfExamination + ", duration="
				+ duration + "]";
	}
}
