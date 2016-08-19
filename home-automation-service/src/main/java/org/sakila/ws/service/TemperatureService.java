package org.sakila.ws.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.sakila.job.TemperatureMessageStore;
import org.sakila.ws.data.Temperature;
import org.sakila.ws.data.mapper.TemperatureMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemperatureService {

	protected static Logger logger = Logger.getLogger(TemperatureService.class);
	
	@Autowired
	private TemperatureMapper temperatureMapper;
	
	@Autowired
	private TemperatureMessageStore temperatureMessageStore;
	
	
	public List<Temperature> getTemperaturesByLocation(String location) {
		
		if(location == null){
			throw new IllegalArgumentException("location is null");
		}
		
		return temperatureMapper.getTemperaturesByLocation(location);
	}
	
	public void setTemperatureToMessageStore(float value, int thermometerId){
		
		if(value > 0){
			logger.debug("setTemperatureToMessageStore: " + value + " and " + thermometerId);
			temperatureMessageStore.setMessage(new Temperature(value, thermometerId));
		}
	}
	
	public void setTemperatureByLocation(Temperature temperature) {
		
		if(temperature != null){
			if(temperature.getValue() > 0 && temperature.getLocation() != null){
				logger.debug(
						"setTempatureForThermometer: " +
						" temperature " + temperature.getValue() + 
						" location " + temperature.getLocation() +
						" count " + temperature.getSampleCount() +
						" min " + temperature.getSampleMin() +
						" max " + temperature.getSampleMin());
				
				temperatureMapper.insertTemperature(temperature);		
			}
			else
			{
				logger.debug("setTempatureForThermometer: Temperature object has null values");
			}
		}
	}


	public void setTemperatureMapper(TemperatureMapper temperatureMapper) {
		this.temperatureMapper = temperatureMapper;
	}

	public void setTemperatureMessageStore(TemperatureMessageStore temperatureMessageStore) {
		this.temperatureMessageStore = temperatureMessageStore;
	}

}
