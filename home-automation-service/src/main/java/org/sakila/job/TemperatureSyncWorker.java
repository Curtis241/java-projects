package org.sakila.job;

import java.util.HashSet;

import org.apache.log4j.Logger;
import org.sakila.ws.data.Temperature;
import org.sakila.ws.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * A synchronous worker
 */
@Component
public class TemperatureSyncWorker implements Worker {

	protected static Logger logger = Logger.getLogger(TemperatureSyncWorker.class);
	
	@Autowired
	private TemperatureService service;
	
	@Autowired
	private TemperatureMessageStore store;

	
	
	public void work() {
		String threadName = Thread.currentThread().getName();
		logger.debug("   " + threadName + " has began working.");
       
		HashSet<Temperature> temperatureList = store.getHashSet();
		
		if(temperatureList != null){
			service.setTemperatureByLocation(calculateMetrics(temperatureList));
		}
		else
		{
			logger.debug("Nothing to do!");
		}
		
        logger.debug("   " + threadName + " has completed work.");
	}

	private Temperature calculateMetrics(HashSet<Temperature> temperatureList) {
		float totalTemperature = 0;
		String location = "";
		int thermometerId = 0;
		int count = 0;
		float temperature = 0;
		float min = 0;
		float max = 0;
		
		if(temperatureList != null){
			for(Temperature t : temperatureList){
				totalTemperature = totalTemperature + t.getValue();
				location = t.getLocation();
				thermometerId = t.getThermometerId();
				
				//Set the temperature to the current temperature if it is less then the last value
				//OR if it is still defined as 0 then assign the current temperature.
				if(t.getValue() < min || min == 0) {
					min = t.getValue();
				}
				
				if(t.getValue() > max) {
					max = t.getValue();
				}
				count++;
			}
			
			if(totalTemperature > 0 && count > 0) {
				temperature = totalTemperature / count;
				logger.debug("   Total Temperature: " + temperature + "; Samples: " + count + "; Min: " + min + "; Max: " + max);
		
				store.clear();
			}
		}
		
		return new Temperature(temperature,thermometerId,location,count,min,max);
	}
	
	public void setTemperatureService(TemperatureService service){
		this.service = service;
	}

	public void setTemperatureMessageStore(TemperatureMessageStore store){
		this.store = store;
	}
}
	
