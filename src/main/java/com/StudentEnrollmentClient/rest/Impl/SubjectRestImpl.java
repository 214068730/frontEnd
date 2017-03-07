package com.StudentEnrollmentClient.rest.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.StudentEnrollmentClient.domain.Address;
import com.StudentEnrollmentClient.domain.Student;
import com.StudentEnrollmentClient.domain.Subject;
import com.StudentEnrollmentClient.rest.RestAPI;
import com.StudentEnrollmentClient.utils.AppUtil;

public class SubjectRestImpl implements RestAPI<Subject, Long> {

	AppUtil util = new AppUtil();
	String BASE_URL = util.getUri()+"enrollment/subject";
	final HttpHeaders requestHeaders = RestMethods.getHeaders();
	final RestTemplate restTemplate = RestMethods.getRestTemplate();
	
	@Override
	public Subject get(Long id) {
		final String url = BASE_URL + "/" + id;
			Subject subject = restTemplate.getForObject(url, Subject.class,
				id.toString());
		return subject;
	}
	@Override
	public Subject post(Subject entity) {
		String url = BASE_URL + "/create";
		HttpEntity<Subject> httpEntity = new HttpEntity<Subject>(entity,
				requestHeaders);
		Subject subject = restTemplate.postForObject(url, httpEntity,
				Subject.class);
		return subject;
	}
	@Override
	public Subject put(Subject entity) {
		String url = BASE_URL + "/update";
		HttpEntity<Subject> requestEntity = new HttpEntity<Subject>(entity,requestHeaders);
		ResponseEntity<Subject> responseEntity = restTemplate.exchange(url,HttpMethod.PUT, requestEntity, Subject.class);
		Subject subject = responseEntity.getBody();
		return subject;
		
	}
	@Override
	public void delete(Subject entity) {
		String id =  entity.getSubjectID()+"";
		String url = BASE_URL + "/delete/{id}";
		restTemplate.delete(url,id);
	}
	@Override
	public List<Subject> getAll() {
		String url = BASE_URL + "/findAll";
		List<Subject> subjects = new ArrayList<>();
		HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
		ResponseEntity<Subject[]> responseEntity = restTemplate.exchange(url,
				HttpMethod.GET, requestEntity, Subject[].class);
		Subject[] results = responseEntity.getBody();

		for (Subject b : results) {
			subjects.add(b);
		}
		return subjects;
	}
	
	public Subject getSubjectCode(String subjectCode) {
		final String url = BASE_URL + "/code/" + subjectCode;
			Subject subject = restTemplate.getForObject(url, Subject.class,
				subjectCode.toString());
		return subject;
	}
	
	public Subject getSubjectName(String subjectName) {
		final String url = BASE_URL + "/name/" + subjectName;
			Subject subject = restTemplate.getForObject(url, Subject.class,
				subjectName.toString());
		return subject;
	}
	
	
	
	
	
}
