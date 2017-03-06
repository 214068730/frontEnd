package com.StudentEnrollmentClient.rest.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;



import com.StudentEnrollmentClient.domain.Address;
import com.StudentEnrollmentClient.domain.Roles;
import com.StudentEnrollmentClient.rest.RestAPI;
import com.StudentEnrollmentClient.utils.AppUtil;

public class RolesRestImpl implements RestAPI<Roles, Long> {

	AppUtil util = new AppUtil();
	String BASE_URL = util.getUri() + "enrollment/roles";
	final HttpHeaders requestHeaders = RestMethods.getHeaders();
	final RestTemplate restTemplate = RestMethods.getRestTemplate();

	@Override
	public Roles get(Long id) {
		final String url = BASE_URL + "/" + id;
		Roles roles = restTemplate.getForObject(url, Roles.class,
				id.toString());
		return roles;
	}

	@Override
	public Roles post(Roles entity) {
		String url = BASE_URL + "/create";
		HttpEntity<Roles> httpEntity = new HttpEntity<Roles>(entity,
				requestHeaders);
		Roles role = restTemplate.postForObject(url, httpEntity,
				Roles.class);
		return role;
	}

	@Override
	public Roles put(Roles entity) {
		String url = BASE_URL + "/update";
		HttpEntity<Roles> requestEntity = new HttpEntity<Roles>(entity,requestHeaders);
		ResponseEntity<Roles> responseEntity = restTemplate.exchange(url,HttpMethod.PUT, requestEntity, Roles.class);
		Roles role = responseEntity.getBody();
		return role;
	}

	@Override
	public void delete(Roles entity) {
		String id =  entity.getId()+"";
		String url = BASE_URL + "/delete/{id}";
		restTemplate.delete(url,id);

	}

	@Override
	public List<Roles> getAll() {
		String url = BASE_URL + "/findAll";
		List<Roles> roles = new ArrayList<>();
		HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
		ResponseEntity<Roles[]> responseEntity = restTemplate.exchange(url,
				HttpMethod.GET, requestEntity, Roles[].class);
		Roles[] results = responseEntity.getBody();

		for (Roles b : results) {
			roles.add(b);
		}
		return roles;
	}

}
