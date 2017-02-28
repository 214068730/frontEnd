package com.StudentEnrollmentClient.services.Impl;

import java.util.List;

import com.StudentEnrollmentClient.domain.Department;
import com.StudentEnrollmentClient.rest.RestAPI;
import com.StudentEnrollmentClient.rest.Impl.DepartmentRestImpl;
import com.StudentEnrollmentClient.services.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService{
	private RestAPI<Department, Long> rest = new DepartmentRestImpl();

	@Override
	public Department findById(Long id) {
		return rest.get(id);
	}

	@Override
	public Department save(Department entity) {
		return rest.post(entity);
	}

	@Override
	public void update(Department entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Department entity) {
		rest.delete(entity);
		
	}

	@Override
	public List<Department> findAll() {
		return rest.getAll();
	}
}
