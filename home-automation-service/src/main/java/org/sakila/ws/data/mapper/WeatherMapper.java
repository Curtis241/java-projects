package org.sakila.ws.data.mapper;

import java.util.List;

import org.sakila.ws.data.CurrentObservationImpl;


public interface WeatherMapper {

	void insertWeather(CurrentObservationImpl weather);
	
	List<CurrentObservationImpl> selectAllWeather();
	
	void deleteWeather(CurrentObservationImpl weather);
	
}
