package com.StudentEnrollmentClient.rest.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.StudentEnrollmentClient.domain.Lecturer;
import com.StudentEnrollmentClient.domain.Subject;
import com.StudentEnrollmentClient.rest.RestAPI;
import com.StudentEnrollmentClient.utils.AppUtil;

public class LecturerRestImpl implements RestAPI<Lecturer, Long> {

	AppUtil util = new AppUtil();
	String BASE_URL = util.getUri() + "enrollment/lecturer";
	final HttpHeaders requestHeaders = RestMethods.getHeaders();
	final RestTemplate restTemplate = RestMethods.getRestTemplate();

	@Override
	public Lecturer get(Long id) {
		final String url = BASE_URL + "/" + id;
		Lecturer lecturer = restTemplate.getForObject(url, Lecturer.class,
				id.toString());
		return lecturer;
	}

	@Override
	public Lecturer post(Lecturer entity) {
		String url = BASE_URL + "/create";
		HttpEntity<Lecturer> httpEntity = new HttpEntity<Lecturer>(entity,
				requestHeaders);
		Lecturer lecturer = restTemplate.postForObject(url, httpEntity,
				Lecturer.class);
		return lecturer;
	}

	@Override
	public Lecturer put(Lecturer entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Lecturer entity) {
		String id =  entity.getId()+"";
		String url = BASE_URL + "/delete/{id}";
		restTemplate.delete(url,id);

	}

	@Override
	public List<Lecturer> getAll() {
		String url = BASE_URL + "/findAll";
		List<Lecturer> lecturers = new ArrayList<>();
		HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
		ResponseEntity<Lecturer[]> responseEntity = restTemplate.exchange(url,
				HttpMethod.GET, requestEntity, Lecturer[].class);
		Lecturer[] results = responseEntity.getBody();

		for (Lecturer b : results) {
			lecturers.add(b);
		}
		return lecturers;
	}

}
