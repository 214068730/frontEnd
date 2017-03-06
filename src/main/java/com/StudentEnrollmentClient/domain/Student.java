package com.StudentEnrollmentClient.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Student {

	private Long studentID;

	private String studentNumber;

	private String studentIdNumber;

	private String studentName;

	private String studentSurname;

	private String dateCreated;

	private Address studentAddress;

	private Roles role;

	public Student() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		DateFormat studentNumberGenerator = new SimpleDateFormat("yyyyHHddss");
		Date date = new Date();
		this.dateCreated = dateFormat.format(date).toString();
		this.studentNumber =  (studentNumberGenerator.format(date).toString()+System.currentTimeMillis()).substring(0, 8);
	}

	public Student(String studentName,
			String studentSurname, Address studentAddress,
			String studentIdNumber, Roles role) {
		super();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		DateFormat studentNumberGenerator = new SimpleDateFormat("yyyyHHddss");
		Date date = new Date();
		this.studentNumber =  (studentNumberGenerator.format(date).toString()+System.currentTimeMillis()).substring(0, 8);
		this.studentName = studentName;
		this.studentSurname = studentSurname;
		this.studentAddress = studentAddress;
		this.studentIdNumber = studentIdNumber;
		this.role = role;
		this.dateCreated = dateFormat.format(date).toString();

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

	public String getDateCreated() {
		return this.dateCreated;
	}

	public String getStudentIdNumber() {
		return studentIdNumber;
	}

	public void setStudentIdNumber(String studentIdNumber) {
		this.studentIdNumber = studentIdNumber;
	}

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return studentID == student.studentID;

    }

    @Override
    public int hashCode() {
        return (int) (studentID ^ (studentID >>> 32));
    }

}
