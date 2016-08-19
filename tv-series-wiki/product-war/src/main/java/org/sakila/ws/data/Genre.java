package org.sakila.ws.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Genre {

	private String id;
	private String name;
	
	
	@JsonProperty("id")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@JsonProperty("name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
