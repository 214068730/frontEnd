package com.StudentEnrollmentClient.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Subject {

	private long subjectID;

	private String subjectName;

	private String subjectCode;

	private String dateAdded;

	private double price;

	private int yearLevel;

	private Lecturer lecturer;

	public Subject() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		this.dateAdded = dateFormat.format(date);
	}

	

	public Subject(String subjectName, String subjectCode, double price,
			int yearLevel, Lecturer lecturer) {
		super();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		this.subjectName = subjectName;
		this.subjectCode = subjectCode;
		this.lecturer = lecturer;
		this.dateAdded = dateFormat.format(date);
		this.price = price;
		this.yearLevel = yearLevel;
		
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getYearCode() {
		return yearLevel;
	}

	public void setYearCode(int yearCode) {
		this.yearLevel = yearCode;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subject subject = (Subject) o;

        return subjectID == subject.subjectID;

    }

    @Override
    public int hashCode() {
        return (int) (subjectID ^ (subjectID >>> 32));
    }

}
