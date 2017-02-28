package com.StudentEnrollmentClient.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
	private Long studentID;

	private String studentNumber;

	private String studentName;

	private String studentSurname;
	
	private String dateCreated;

	private Address studentAddress;

	public Student() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		this.dateCreated = dateFormat.format(date);
	}

	public Student(String studentNumber, String studentName,
			String studentSurname, Address studentAddress) {
		super();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		this.studentNumber = studentNumber;
		this.studentName = studentName;
		this.studentSurname = studentSurname;
		this.studentAddress = studentAddress;
		this.dateCreated =  dateFormat.format(date);
	}

	public String getStudentSurname() {
		return studentSurname;
	}

	public void setStudentSurname(String studentSurname) {
		this.studentSurname = studentSurname;
	}

	public Long getStudentID() {
		return studentID;
	}

	public void setStudentID(Long studentID) {
		this.studentID = studentID;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Address getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(Address studentAddress) {
		this.studentAddress = studentAddress;
	}
	
	public String getDateCreated(){
		return this.dateCreated;
	}
}