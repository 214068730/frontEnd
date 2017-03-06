package com.StudentEnrollmentClient.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Roles {

	private Long Id;

	private String role;

	private String dateCreated;

	private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	private Date date = new Date();

	public Roles() {
		super();
		this.dateCreated = dateFormat.format(date).toString();
	}

	public Roles(Long id, String role) {
		super();
		Id = id;
		this.role = role;
		this.dateCreated = dateFormat.format(date).toString();
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDateCreate() {
		return this.dateCreated;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Roles roles = (Roles) o;

        return Id == roles.Id;

    }

    @Override
    public int hashCode() {
        return (int) (Id ^ (Id >>> 32));
    }

}
