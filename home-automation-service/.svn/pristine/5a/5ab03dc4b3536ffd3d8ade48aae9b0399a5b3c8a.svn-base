package org.sakila.ws.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.sakila.ws.data.Location;
import org.sakila.ws.data.mapper.LocationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

protected static Logger logger = Logger.getLogger(TemperatureService.class);
	
	@Autowired(required = true)
	private LocationMapper locationMapper;
	
	
	public List<Location> getLocationNames() {
		return locationMapper.getLocationNames();
	}
	
	public void setLocationName(String name){
		locationMapper.insertLocationName(name);
	}
	
	public List<Location> getThermometerLocations() {
		return locationMapper.getThermometerLocations();
	}
	
	public List<Location> getThermometerLocation(int thermometerId){
		return locationMapper.getLocationByThermometerId(thermometerId);
	}
	
	public void setThermometer(int locationId,int thermometerId) {
		locationMapper.insertThermometerLocation(new Location(locationId,thermometerId));
	}
	
	public void moveThermometer(int fromLocationId,int toLocationId, int thermometerId){
		
		Location fromLocation = new Location(fromLocationId, thermometerId);
		Location thermometerLocation = locationMapper.getThermometerLocation(fromLocation);
		locationMapper.trashThermometerLocation(thermometerLocation.getThermometerLocationId());
		
		Location toLocation = new Location(toLocationId, thermometerId);
		locationMapper.insertThermometerLocation(toLocation);
		
	}

}
