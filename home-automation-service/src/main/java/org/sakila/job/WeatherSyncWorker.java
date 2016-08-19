package org.sakila.job;

import org.apache.log4j.Logger;
import org.sakila.ws.data.WeatherImpl;
import org.sakila.ws.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * A synchronous worker
 */
@Component
public class WeatherSyncWorker implements Worker {

	protected static Logger logger = Logger.getLogger(WeatherSyncWorker.class);
	
	@Autowired
	private WeatherService weatherService;
	
	
	public void work() {
		String threadName = Thread.currentThread().getName();
		logger.debug("   " + threadName + " has began working.");
       
		WeatherImpl weather = weatherService.getWeather();
		weatherService.saveWeather(weather.getCurrentObservation());
		
        logger.debug("   " + threadName + " has completed work.");
	}

	public void setWeatherService(final WeatherService weatherService){
		this.weatherService = weatherService;
	}
}
	

