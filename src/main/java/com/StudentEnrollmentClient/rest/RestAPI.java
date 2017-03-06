package com.StudentEnrollmentClient.rest;

import java.util.List;

public interface RestAPI<E, ID> {
	E get(ID id);

	E post(E entity);

	E put(E entity);

	void delete(E entity);

	List<E> getAll();

}
