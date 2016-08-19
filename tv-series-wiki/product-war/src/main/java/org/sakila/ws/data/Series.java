package org.sakila.ws.data;

import java.util.Date;

import org.sakila.ws.util.DateFormatter;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Series {

	private String id;
	private String name;
	private String seasonCount;
	private Date startDate;
	private Date endDate;
	
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
	
	@JsonProperty("seasons")
	public String getSeasonCount() {
		return seasonCount;
	}
	public void setSeasonCount(String seasonCount) {
		this.seasonCount = seasonCount;
	}
	
	@JsonProperty("startdate")
	public String getStartDate() {
		return new DateFormatter().toDateString(this.startDate);
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	@JsonProperty("enddate")
	public String getEndDate() {
		return new DateFormatter().toDateString(this.endDate);
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
}
