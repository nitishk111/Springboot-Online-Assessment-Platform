package com.nitish.users.dto;

/**
 *
 * DTO class of Option It keeps details of all option
 * 
 */

public class Option {
	
//	variables
	private int optionId;
	private String optionName;

//	Default Constructor
	public Option() {
		super();
	}

//	getters and setters
	public Option(String optionName) {
		super();
		this.optionName = optionName;
	}

	public int getOptionId() {
		return optionId;
	}

	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}

	public String getOptionName() {
		return optionName;
	}

	public void setOption(String option) {
		this.optionName = option;
	}

	// Overriding toString method
	@Override
	public String toString() {
		return "Option [optionId=" + optionId + ", option=" + optionName + "]";
	}

}
