package com.StudentEnrollmentClient.services;


import java.util.List;

import com.StudentEnrollmentClient.domain.ProgressStatus;
import com.StudentEnrollmentClient.domain.StudentCourse;
import com.StudentEnrollmentClient.domain.Subject;

public interface StudentCourseService extends Services<StudentCourse,Long> {
	public  List<StudentCourse> getByStudentId(Long id);
	public boolean register(List<Subject> subjects,StudentCourse entity);

 
}
