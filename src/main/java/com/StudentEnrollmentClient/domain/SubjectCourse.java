package com.StudentEnrollmentClient.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;



public class SubjectCourse {
	private Long id;

	private Course course;

	private Subject subject;

	private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	private Date date = new Date();

	private String dateCreated;

	public SubjectCourse() {
		super();
		this.dateCreated = dateFormat.format(date);
	}

	public SubjectCourse(Course course, Subject subject) {
		super();
		this.course = course;
		this.subject = subject;
		this.dateCreated = dateFormat.format(date);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public String getDateCreated() {
		return dateCreated;
	}
	
	

}
