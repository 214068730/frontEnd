package com.StudentEnrollmentClient.domain;

import org.junit.Assert;
import org.junit.Test;

public class TestDepartment {

	final static Department department = new Department();
	
	@Test
	public void testCreateDepartment() throws Exception{
		
		Assert.assertNotNull(department);
		
		department.setDepartmentID(7L);
		department.setDepartmentName("Information Technology");
		
		Assert.assertEquals("Information Technology", department.getDepartmentName());	
	}
	
	@Test
	public void testUpdateDepartment() throws Exception{
		
		department.setDepartmentID(56L);
		department.setDepartmentName("Marketing");
		
		Assert.assertEquals("Marketing", department.getDepartmentName());
	}
}