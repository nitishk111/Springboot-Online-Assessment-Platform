package com.cg.login.controllers;


public class ErrorInfo {
	private int statusCode;
	private String status;
	private String errors;
	private String path;
	public ErrorInfo() {
		super();
	}
	public ErrorInfo(int statusCode, String status, String errors, String path) {
		super();
		this.statusCode = statusCode;
		this.status = status;
		this.errors = errors;
		this.path = path;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getErrors() {
		return errors;
	}
	public void setErrors(String errors) {
		this.errors = errors;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	@Override
	public String toString() {
		return "ErrorInfo [statusCode=" + statusCode + ", status=" + status + ", errors=" + errors + ", path=" + path
				+ "]";
	}
	
}
