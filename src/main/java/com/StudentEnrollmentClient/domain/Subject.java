package com.StudentEnrollmentClient.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Subject {

	private long subjectID;

	private String subjectName;

	private String subjectCode;

	private String dateAdded;

	private Lecturer lecturer;

	public Subject() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		this.dateAdded = dateFormat.format(date);
	}

	public Subject(String subjectName, String subjectCode, Lecturer lecturer) {
		super();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		this.subjectName = subjectName;
		this.subjectCode = subjectCode;
		this.lecturer = lecturer;
		this.dateAdded = dateFormat.format(date);
	}

	public long getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(long subjectID) {
		this.subjectID = subjectID;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public Lecturer getLecturer() {
		return lecturer;
	}

	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}

	public String getDateAdded() {
		return this.dateAdded;
	}
}

