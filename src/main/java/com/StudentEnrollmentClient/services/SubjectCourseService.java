package com.StudentEnrollmentClient.services;

import java.util.List;

import com.StudentEnrollmentClient.domain.SubjectCourse;

public interface SubjectCourseService extends Services<SubjectCourse, Long> {
	public List<SubjectCourse> findByCourseCode(Long code);

}
