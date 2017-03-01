package com.StudentEnrollmentClient.services;


import java.util.List;

import com.StudentEnrollmentClient.domain.StudentCourse;

public interface StudentCourseService extends Services<StudentCourse,Long> {
	public  List<StudentCourse> getByStudentId(Long id);
 
}
