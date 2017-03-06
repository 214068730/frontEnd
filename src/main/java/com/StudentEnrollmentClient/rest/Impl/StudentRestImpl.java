package com.StudentEnrollmentClient.rest.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.StudentEnrollmentClient.domain.Student;
import com.StudentEnrollmentClient.rest.RestAPI;
import com.StudentEnrollmentClient.utils.AppUtil;

public class StudentRestImpl implements RestAPI<Student, Long> {

	AppUtil util = new AppUtil();
	String BASE_URL = util.getUri()+"enrollment/student";
	final HttpHeaders requestHeaders = RestMethods.getHeaders();
	final RestTemplate restTemplate = RestMethods.getRestTemplate();
	

	@Override
	public Student get(Long id) {
		final String url = BASE_URL + "/" + id;
		Student student = restTemplate.getForObject(url, Student.class,
				id.toString());
		return student;
	}

	public Student getStudentLogin(String studentNumber, String studentName) {
		final String url = BASE_URL +"/findAll/" + studentNumber+"/"+studentName;
		Student student = restTemplate.getForObject(url, Student.class,
				studentNumber,studentName);
		return student;
	}

	public Student getByStudentNumber(String studentNumber) {
		final String url = BASE_URL + "/findByStudentNumber/" + studentNumber;
		Student student = restTemplate.getForObject(url, Student.class,
				studentNumber.toString());
		return student;
	}

	@Override
	public Student post(Student entity) {
		String url = BASE_URL + "/create";
		HttpEntity<Student> httpEntity = new HttpEntity<>(entity,
				requestHeaders);
		Student student = restTemplate.postForObject(url, httpEntity,
				Student.class);
		return student;
	}

	@Override
	// update this method use putObject
	public Student put(Student entity) {
		String url = BASE_URL + "/update";
		HttpEntity<Student> requestEntity = new HttpEntity<Student>(entity,requestHeaders);
		ResponseEntity<Student> responseEntity = restTemplate.exchange(url,HttpMethod.PUT, requestEntity, Student.class);
		Student student = responseEntity.getBody();
		return student;
	}

	@Override
	public void delete(Student entity) {
		String id = entity.getStudentID().toString();
		String url = BASE_URL + "/delete/{id}";
		restTemplate.delete(url,id);

	}

	@Override
	public List<Student> getAll() {
		String url = BASE_URL + "/findAll";
		List<Student> students = new ArrayList<>();
		HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
		ResponseEntity<Student[]> responseEntity = restTemplate.exchange(url,
				HttpMethod.GET, requestEntity, Student[].class);
		Student[] results = responseEntity.getBody();

		for (Student b : results) {
			students.add(b);
		}
		return students;
	}

}
