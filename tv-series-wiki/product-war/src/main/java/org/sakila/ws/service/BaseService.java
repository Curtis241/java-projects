package org.sakila.ws.service;

import javax.ws.rs.core.Response;

public interface BaseService<T> {

	Response selectById(String guid);
	
	Response selectByName(String name);
	
	Response selectAll();
	
	Response select(T object);
	
	Response insert(T object);
	
	Response delete(T object);
	
	Response update(T object);
}
