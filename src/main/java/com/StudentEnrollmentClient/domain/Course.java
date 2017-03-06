package com.StudentEnrollmentClient.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;



public class Course {

	private Long courseID;
	private String courseName;
	private String courseCode;
	private Department department;
	private String dateCreated;
	private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	private Date date = new Date();

	public Course() {
		super();
		this.dateCreated = dateFormat.format(date);
	}

	public Course(Long id, String courseName, String courseCode,
			Department department, String dateCreated) {
		super();
		this.courseID = id;
		this.courseName = courseName;
		this.courseCode = courseCode;
		this.department = department;
		this.dateCreated = dateFormat.format(date);
	}

	public Long getId() {
		return this.courseID;
	}

	public void setId(Long id) {
		this.courseID = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        return courseID == course.courseID;

    }

    @Override
    public int hashCode() {
        return (int) (courseID ^ (courseID >>> 32));
    }
}
