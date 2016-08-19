package org.sakila.ws.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentObservationImpl implements CurrentObservation {
	
	 private int weatherId;
	
	 @JsonProperty("station_id")
	 private String stationId;
	 	 
	 @JsonProperty("observation_time_rfc822")
	 private String observationTime_rfc822;
	 
	 @JsonProperty("local_time_rfc822")
	 private String localTime;
	 
	 @JsonProperty("weather")
	 private String weather;
	 	 
	 @JsonProperty("temp_c")
	 private int temperature;
	 
	 @JsonProperty("relative_humidity")
	 private String relativeHumidity;
	 
	 @JsonProperty("wind_string")
	 private String windString;
	 
	 @JsonProperty("wind_dir")
	 private String windDirection;
	
	 @JsonProperty("wind_degrees")
	 private int windDegrees;
	 
	 @JsonProperty("wind_kph")
	 private int windSpeed;
	 
	 @JsonProperty("wind_gust_kph")
	 private int windGustSpeed;
	  
	 @JsonProperty("dewpoint_c")
	 private int dewpoint;
	 
	 @JsonProperty("feelslike_c")
	 private int feelsLike;
	 
	 @JsonProperty("visibility_km")
	 private double visibility;
	 
	 @JsonProperty("precip_today_metric")
	 private double precipToday;
 
	 
	/* (non-Javadoc)
	 * @see org.sakila.ws.data.ICurrentObservation#getCurrentObservationId()
	 */
	@Override
	public int getCurrentObservationId() {
		return weatherId;
	}

	
	/* (non-Javadoc)
	 * @see org.sakila.ws.data.ICurrentObservation#setCurrentObservationId(int)
	 */
	@Override
	public void setCurrentObservationId(int currentObservationId) {
		this.weatherId = currentObservationId;
	}

	
	/* (non-Javadoc)
	 * @see org.sakila.ws.data.ICurrentObservation#getStationId()
	 */
	@Override
	public String getStationId() {
		 return stationId;
	}
	 
	
	/* (non-Javadoc)
	 * @see org.sakila.ws.data.ICurrentObservation#setStationId(java.lang.String)
	 */
	@Override
	public void setStationId(String stationId){
		 this.stationId = stationId;
	}

	
	/* (non-Javadoc)
	 * @see org.sakila.ws.data.ICurrentObservation#getObservationTime()
	 */
	@Override
	public String getObservationTime() {
		return observationTime_rfc822;
	}

	
	/* (non-Javadoc)
	 * @see org.sakila.ws.data.ICurrentObservation#setObservationTime(java.lang.String)
	 */
	@Override
	public void setObservationTime(String observationTime) {
		this.observationTime_rfc822 = observationTime;
	}

	
	/* (non-Javadoc)
	 * @see org.sakila.ws.data.ICurrentObservation#getLocalTime()
	 */
	@Override
	public String getLocalTime() {
		return localTime;
	}

	
	/* (non-Javadoc)
	 * @see org.sakila.ws.data.ICurrentObservation#setLocalTime(java.lang.String)
	 */
	@Override
	public void setLocalTime(String localTime) {
		this.localTime = localTime;
	}

	
	/* (non-Javadoc)
	 * @see org.sakila.ws.data.ICurrentObservation#getWeather()
	 */
	@Override
	public String getWeather() {
		return weather;
	}

	
	/* (non-Javadoc)
	 * @see org.sakila.ws.data.ICurrentObservation#setWeather(java.lang.String)
	 */
	@Override
	public void setWeather(String weather) {
		this.weather = weather;
	}

	/* (non-Javadoc)
	 * @see org.sakila.ws.data.ICurrentObservation#getTemperature()
	 */
	@Override
	public int getTemperature() {
		return temperature;
	}


	/* (non-Javadoc)
	 * @see org.sakila.ws.data.ICurrentObservation#setTemperature(int)
	 */
	@Override
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}


	/* (non-Javadoc)
	 * @see org.sakila.ws.data.ICurrentObservation#getRelativeHumidity()
	 */
	@Override
	public String getRelativeHumidity() {
		return relativeHumidity;
	}


	/* (non-Javadoc)
	 * @see org.sakila.ws.data.ICurrentObservation#setRelativeHumidity(int)
	 */
	@Override
	public void setRelativeHumidity(String relativeHumidity) {
		this.relativeHumidity = relativeHumidity;
	}


	/* (non-Javadoc)
	 * @see org.sakila.ws.data.ICurrentObservation#getWindString()
	 */
	@Override
	public String getWindString() {
		return windString;
	}


	/* (non-Javadoc)
	 * @see org.sakila.ws.data.ICurrentObservation#setWindString(java.lang.String)
	 */
	@Override
	public void setWindString(String windString) {
		this.windString = windString;
	}

	/* (non-Javadoc)
	 * @see org.sakila.ws.data.ICurrentObservation#getDewpoint()
	 */
	@Override
	public int getDewpoint() {
		return dewpoint;
	}


	/* (non-Javadoc)
	 * @see org.sakila.ws.data.ICurrentObservation#setDewpoint(int)
	 */
	@Override
	public void setDewpoint(int dewpoint) {
		this.dewpoint = dewpoint;
	}

	/* (non-Javadoc)
	 * @see org.sakila.ws.data.ICurrentObservation#getFeelsLike()
	 */
	@Override
	public int getFeelsLike() {
		return feelsLike;
	}


	/* (non-Javadoc)
	 * @see org.sakila.ws.data.ICurrentObservation#setFeelsLike(int)
	 */
	@Override
	public void setFeelsLike(int feelsLike) {
		this.feelsLike = feelsLike;
	}


	/* (non-Javadoc)
	 * @see org.sakila.ws.data.ICurrentObservation#getVisibility()
	 */
	@Override
	public double getVisibility() {
		return visibility;
	}


	/* (non-Javadoc)
	 * @see org.sakila.ws.data.ICurrentObservation#setVisibility(double)
	 */
	@Override
	public void setVisibility(double visibility) {
		this.visibility = visibility;
	}

	/* (non-Javadoc)
	 * @see org.sakila.ws.data.ICurrentObservation#getPrecipToday()
	 */
	@Override
	public double getPrecipToday() {
		return precipToday;
	}


	/* (non-Javadoc)
	 * @see org.sakila.ws.data.ICurrentObservation#setPrecipToday(double)
	 */
	@Override
	public void setPrecipToday(double precipToday) {
		this.precipToday = precipToday;
	}
	
	
	 
	 
	 
}
