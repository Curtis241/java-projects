package org.sakila.ws.data;

public interface Weather {
	public abstract WeatherResponseImpl getWeatherResponse();
	public abstract void setWeatherResponse(WeatherResponseImpl weatherResponse);
	
	public abstract CurrentObservationImpl getCurrentObservation();
	public abstract void setCurrentObservation(CurrentObservationImpl currentObservation);
}
