package com.nitish.Admin.dto;

import java.time.LocalDate;

public class ExamVoucher {

	private int examinationVoucherNumber;
	private LocalDate dateOfExpiration;
	private String examinationName;
	private double voucherPrice;
	private double eligibilityRatingCriteria;

	// getters & setters

	public int getExaminationVoucherNumber() {
		return examinationVoucherNumber;
	}

	public void setExaminationVoucherNumber(int ExaminationVoucherNumber) {
		this.examinationVoucherNumber = ExaminationVoucherNumber;
	}

	public LocalDate getDateOfExpiration() {
		return dateOfExpiration;
	}

	public void setDateOfExpiration(LocalDate dateOfExpiration) {
		this.dateOfExpiration = dateOfExpiration;
	}

	public String getExaminationName() {
		return examinationName;
	}

	public void setExaminationName(String ExamName) {
		this.examinationName = ExamName;
	}

	public double getVoucherPrice() {
		return voucherPrice;
	}

	public void setVoucherPrice(double voucherPrice) {
		this.voucherPrice = voucherPrice;
	}

	public double getEligibilityRatingCriteria() {
		return eligibilityRatingCriteria;
	}

	public void setEligibilityRatingCriteria(double eligibilityRatingCriteria) {
		this.eligibilityRatingCriteria = eligibilityRatingCriteria;
	}

	// Parameterized constructor

	public ExamVoucher(int examinationVoucherNumber, LocalDate dateOfExpiration, String examinationName,
			double voucherPrice, double eligibilityRatingCriteria) {
		super();
		this.examinationVoucherNumber = examinationVoucherNumber;
		this.dateOfExpiration = dateOfExpiration;
		this.examinationName = examinationName;
		this.voucherPrice = voucherPrice;
		this.eligibilityRatingCriteria = eligibilityRatingCriteria;
	}

	// Default constructor

	public ExamVoucher() {
		super();

	}

	// Overriding toString method

	@Override
	public String toString() {
		return "ExaminationVoucher [ExaminationVoucherNumber=" + examinationVoucherNumber + ", dateOfExpiration="
				+ dateOfExpiration + ", ExaminationName=" + examinationName + ", voucherPrice=" + voucherPrice
				+ ", eligibilityRatingCriteria=" + eligibilityRatingCriteria + "]";
	}
}
