package org.sakila.ws.data.mapper;

import java.util.List;

import org.sakila.ws.data.Location;


public interface LocationMapper {

	
	List<Location> getLocationNames();
	
	List<Location> getLocationName(String name);
	
	void insertLocationName(String name); 
			
	void deleteLocationName(int locationId);

	List<Location> getThermometerLocations();
	
	List<Location> getLocationByThermometerId(int thermometerId);
	
	void insertThermometerLocation(Location location);
	
	List<Location> getThermometerLocationHistory(Location location);
	
	Location getThermometerLocation(Location location);
	
	void trashThermometerLocation(int thermometerLocationId);
	
	void deleteThermometerLocation(int thermometerLocationId);
	
	void deleteThermometerLocations();
}
