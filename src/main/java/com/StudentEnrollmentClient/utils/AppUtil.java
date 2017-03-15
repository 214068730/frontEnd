package com.StudentEnrollmentClient.utils;

public class AppUtil {

	private final String URI = "http://localhost:8080/";
	private final String invalidLoginInput = "Invalid Input";
	private final String successMessage = "Records Successfully Updated";
	private final String recordsAdded = "Records Successfully Added";
	private final String recordsNotAdded = "Sorry! Records Not Added";
	private final String recordsFilled = "PLEASE FILL IN ALL FIELDS";
	
	public String getUri() {
		return URI;
	}	

	public String getInvalidLoginInput() {
		return invalidLoginInput;
	}

	public String getSuccessMessage() {
		return successMessage;
	}
	
	public String getRecordsAdded()
	{
		return recordsAdded;
	}
	
	public String getRecordsNotAdded()
	{
		return recordsNotAdded;
	}
	
	public String getRecordsFilled()
	{
		return recordsFilled;
	}
}
