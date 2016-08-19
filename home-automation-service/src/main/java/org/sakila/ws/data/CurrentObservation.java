package org.sakila.ws.data;

public interface CurrentObservation {

	public abstract int getCurrentObservationId();

	public abstract void setCurrentObservationId(int currentObservationId);

	public abstract String getStationId();

	public abstract void setStationId(String stationId);

	public abstract String getObservationTime();

	public abstract void setObservationTime(String observationTime);

	public abstract String getLocalTime();

	public abstract void setLocalTime(String localTime);

	public abstract String getWeather();

	public abstract void setWeather(String weather);

	public abstract int getTemperature();

	public abstract void setTemperature(int temperature);

	public abstract String getRelativeHumidity();

	public abstract void setRelativeHumidity(String relativeHumidity);

	public abstract String getWindString();

	public abstract void setWindString(String windString);

	public abstract int getDewpoint();

	public abstract void setDewpoint(int dewpoint);

	public abstract int getFeelsLike();

	public abstract void setFeelsLike(int feelsLike);

	public abstract double getVisibility();

	public abstract void setVisibility(double visibility);

	public abstract double getPrecipToday();

	public abstract void setPrecipToday(double precipToday);

}