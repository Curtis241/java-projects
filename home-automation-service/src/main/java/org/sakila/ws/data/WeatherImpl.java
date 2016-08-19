package org.sakila.ws.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true) 
public class WeatherImpl implements Weather 
{
	@JsonProperty("response")
	private WeatherResponseImpl weatherResponse;
	
	@JsonProperty("current_observation")
	private CurrentObservationImpl currentObservation;

	@Override
	public WeatherResponseImpl getWeatherResponse() {
		return weatherResponse;
	}

	@Override
	public void setWeatherResponse(WeatherResponseImpl weatherResponse) {
		this.weatherResponse = weatherResponse;
	}

	@Override
	public CurrentObservationImpl getCurrentObservation() {
		return currentObservation;
	}

	@Override
	public void setCurrentObservation(CurrentObservationImpl currentObservation) {
		this.currentObservation = currentObservation;
	}
}