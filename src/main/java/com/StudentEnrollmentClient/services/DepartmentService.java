package com.StudentEnrollmentClient.services;

import com.StudentEnrollmentClient.domain.Department;

public interface DepartmentService extends Services<Department,Long>{
	public Department getByName(String departmentName);

}
