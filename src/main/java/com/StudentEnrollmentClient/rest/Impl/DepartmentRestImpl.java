package com.StudentEnrollmentClient.rest.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.StudentEnrollmentClient.domain.Department;
import com.StudentEnrollmentClient.domain.Lecturer;
import com.StudentEnrollmentClient.rest.RestAPI;
import com.StudentEnrollmentClient.utils.AppUtil;

public class DepartmentRestImpl implements RestAPI<Department, Long> {

	AppUtil util = new AppUtil();
	String BASE_URL = util.getUri() + "enrollment/department";
	final HttpHeaders requestHeaders = RestMethods.getHeaders();
	final RestTemplate restTemplate = RestMethods.getRestTemplate();

	@Override
	public Department get(Long id) {
		final String url = BASE_URL + "/" + id;
		Department department = restTemplate.getForObject(url, Department.class,
				id.toString());
		return department;
	}

	@Override
	public Department post(Department entity) {
		String url = BASE_URL + "/create";
		HttpEntity<Department> httpEntity = new HttpEntity<Department>(entity,
				requestHeaders);
		Department department = restTemplate.postForObject(url, httpEntity,
				Department.class);
		return department;
	}

	@Override
	public void put(Department entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Department entity) {
		String id =  entity.getDepartmentID()+"";
		String url = BASE_URL + "/delete/{id}";
		restTemplate.delete(url,id);

	}

	@Override
	public List<Department> getAll() {
		String url = BASE_URL + "/findAll";
		List<Department> departments = new ArrayList<>();
		HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
		ResponseEntity<Department[]> responseEntity = restTemplate.exchange(url,
				HttpMethod.GET, requestEntity, Department[].class);
		Department[] results = responseEntity.getBody();

		for (Department b : results) {
			departments.add(b);
		}
		return departments;
	}

}
