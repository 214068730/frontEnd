package com.StudentEnrollmentClient.domain;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;

public class TestStudent extends TestCase{

	final static Address address = new Address();
	final static Student student = new Student();
	
	@Test
	public void testCreateStudent() throws Exception{
		
		address.setAreaCode("2345");
		address.setStreetName("Sparrow");
		address.setStreetNumber("15");
		address.setSurbubName("Rocklands");
		
		student.setStudentAddress(address);
		student.setStudentID(275L);
		student.setStudentName("Siraaj");
		student.setStudentNumber("214068730");
		student.setStudentSurname("Wilkinson");
		student.setStudentIdNumber("9202138302983");
		
		//Test takes place
		Assert.assertNotNull(student);
		Assert.assertEquals("Siraaj", student.getStudentName());
		Assert.assertEquals("Wilkinson", student.getStudentSurname());
		Assert.assertEquals("214068730", student.getStudentNumber());
		Assert.assertEquals("9202138302983", student.getStudentIdNumber());
	}
	
	@Test
	public void testUpdateStudent() throws Exception{
		
		//test old values
		Assert.assertEquals("Siraaj", student.getStudentName());
		student.setStudentName("Kebo");
		Assert.assertEquals("Wilkinson", student.getStudentSurname());
		student.setStudentSurname("Moreng");
		
		//test new values 
		Assert.assertEquals("Kebo", student.getStudentName());
	}
}
