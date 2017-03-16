package com.StudentEnrollmentClient.utils;

public class AppUtil {

	private final String URI = "http://localhost:8080/";
	private final String invalidLoginInput = "Invalid Input";
	private final String successMessage = "Record Successfully Updated";
	
	public String getUri() {
		return URI;
	}	

	public String getInvalidLoginInput() {
		return invalidLoginInput;
	}

	public String getSuccessMessage() {
		return successMessage;
	}
}
