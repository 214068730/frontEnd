package com.StudentEnrollmentClient.services;

import com.StudentEnrollmentClient.domain.Student;

public interface StudentService extends Services<Student,Long> {
	
	public Student login(String studentNumber,String studentName);
	public Student findByStudentNumber(String studentNumber);
	
}
