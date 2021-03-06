package com.StudentEnrollmentClient.utils;

public class AppUtil {

	private final String URI = "http://localhost:8080/";
	private final String invalidLoginInput = "INVALID INPUT";
	private final String recordsUpdated = "RECORD SUCCESSFULLY UPDATED";
	private final String recordsNotUpdated = "RECORD NOT UPDATED";
	private final String recordsAdded = "RECORD SUCCESSFULLY ADDED";
	private final String recordsNotAdded = "SORRY! RECORD NOT ADDED";
	private final String recordsFilled = "PLEASE FILL IN ALL FIELDS";
	private final String noRowSelected = "NO ROW SELECTED";
	private final String noBlankFields = "NO BLANK FIELDS ALLOWED";
	
	public String getUri() {
		return URI;
	}	

	public String getInvalidLoginInput() {
		return invalidLoginInput;
	}
	
	public String getRecordsUpdated() {
		return recordsUpdated;
	}

	public String getRecordsNotUpdated() {
		return recordsNotUpdated;
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
	
	public String getNoRowSelected() {
		return noRowSelected;
	}

	public String getNoBlankFields() {
		return noBlankFields;
	}	
}
