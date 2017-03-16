package com.StudentEnrollmentClient.utils;

public class AppUtil {

	private final String URI = "http://localhost:8080/";
	private final String invalidLoginInput = "INVALID INPUT";
	private final String recordsUpdated = "RECORDS SUCCESSFULLY UPDATED";
	private final String recordsNotUpdated = "RECORDS NOT UPDATED";
	private final String recordsAdded = "RECORDS SUCCESSFULLY ADDED";
	private final String recordsNotAdded = "SORRY! RECORDS NOT ADDED";
	private final String recordsFilled = "PLEASE FILL IN ALL FIELDS";
	private final String noRowSelected = "NO ROW SELECTED";

	
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
}
