package com.StudentEnrollmentClient.services.Impl;

import java.util.List;

import com.StudentEnrollmentClient.domain.ProgressStatus;
import com.StudentEnrollmentClient.domain.StudentCourse;
import com.StudentEnrollmentClient.domain.Subject;
import com.StudentEnrollmentClient.rest.RestAPI;
import com.StudentEnrollmentClient.rest.Impl.StudentCourseRestImpl;
import com.StudentEnrollmentClient.services.StudentCourseService;

public class StudentCourseServiceImpl implements StudentCourseService{

	private StudentCourseRestImpl rest = new StudentCourseRestImpl();

	@Override
	public StudentCourse findById(Long id) {
		return rest.get(id);
	}

	@Override
	public StudentCourse save(StudentCourse entity) {
		return rest.post(entity);
	}

	@Override
	public StudentCourse update(StudentCourse entity) {
		return rest.put(entity);
		
	}

	@Override
	public void delete(StudentCourse entity) {
		rest.delete(entity);
		
	}

	@Override
	public List<StudentCourse> findAll() {
		return rest.getAll();
	}

	@Override
	public List<StudentCourse> getByStudentId(Long id) {
		return rest.getByStudentId(id);
	}

	@Override
	public List<StudentCourse> registeredSubjects(Long studentID,Long courseID)  {
		return rest.registeredSubjects(studentID, courseID);
	}

	

	

}
