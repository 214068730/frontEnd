package com.StudentEnrollmentClient.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;



public class ProgressStatus {
	private Long id;

	private String currentYear;
	private String startDate;
	private String endDate;
	private boolean active;
	private Student student;
	private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	private Date date = new Date();

	public ProgressStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProgressStatus(Long id, String currentYear, String startDate,
			String endDate, boolean active, Student student) {
		super();
		this.id = id;
		this.currentYear = currentYear;
		this.startDate = dateFormat.format(date).toString();
		this.endDate = endDate;
		this.active = active;
		this.student = student;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCurrentYear() {
		return currentYear;
	}

	public void setCurrentYear(String currentYear) {
		this.currentYear = currentYear;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProgressStatus progressStatus = (ProgressStatus) o;

        return id == progressStatus.id;

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

}
