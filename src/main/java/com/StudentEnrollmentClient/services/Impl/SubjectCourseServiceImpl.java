package com.StudentEnrollmentClient.services.Impl;

import java.util.List;

import com.StudentEnrollmentClient.domain.SubjectCourse;
import com.StudentEnrollmentClient.rest.RestAPI;
import com.StudentEnrollmentClient.rest.Impl.SubjectCourseRestImpl;
import com.StudentEnrollmentClient.rest.Impl.SubjectRestImpl;
import com.StudentEnrollmentClient.services.SubjectCourseService;

public class SubjectCourseServiceImpl implements SubjectCourseService {
	private SubjectCourseRestImpl rest = new SubjectCourseRestImpl();

	@Override
	public SubjectCourse findById(Long id) {
		return rest.get(id);
	}

	@Override
	public SubjectCourse save(SubjectCourse entity) {
		return rest.post(entity);
	}

	@Override
	public SubjectCourse update(SubjectCourse entity) {
		return rest.put(entity);

	}

	@Override
	public void delete(SubjectCourse entity) {
		rest.delete(entity);

	}

	@Override
	public List<SubjectCourse> findAll() {
		return rest.getAll();
	}

	@Override
	public List<SubjectCourse> findByCourseCode(Long code) {
		if(code == null)
			return null;
		else
			return rest.getByCourseCode(code);
	}

}
