package com.StudentEnrollmentClient.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



public class Department {
	Long departmentID;
	String departmentName;
	String dateAdded;

	public Department() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		this.dateAdded =   dateFormat.format(date);
	}

	public Department(String departmentName) {
		super();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		this.departmentName = departmentName;
		this.dateAdded =   dateFormat.format(date);
	}

	public Long getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(Long departmentID) {
		this.departmentID = departmentID;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	public String getDateAdded(){
		return  new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department department = (Department) o;

        return departmentID == department.departmentID;

    }

    @Override
    public int hashCode() {
        return (int) (departmentID ^ (departmentID >>> 32));
    }
}
