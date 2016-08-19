package org.sakila.ws.data.mapper;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sakila.ws.data.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = {"test-mapper-configuration.xml"})
public class LocationMapperTests {

	protected static Logger logger = Logger.getLogger(LocationMapperTests.class);
	
	@Autowired
	private LocationMapper locationMapper;
	
	@Test
	@Transactional
	public void InsertLocationNameTest(){
		
		String location1 = "Location1";
		String location2 = "Location2";
				
		locationMapper.insertLocationName(location1);
		locationMapper.insertLocationName(location2);
		
		assertTrue(locationMapper.getLocationName(location1).size() == 1);
		assertTrue(locationMapper.getLocationName(location2).size() == 1);
		
	}
	
	@Test
	@Transactional
	public void DeleteLocationNameTest(){
		String location = "Location1";
		locationMapper.insertLocationName(location);
		
		List<Location> list = locationMapper.getLocationName(location);
		locationMapper.deleteLocationName(list.get(0).getLocationId());
		
		assertTrue(locationMapper.getLocationName(location).size() == 0);
	}
	
	@Test
	@Transactional
	public void GetLocationNamesTest() {
		String location1 = "Location1";
		String location2 = "Location2";
				
		locationMapper.insertLocationName(location1);
		locationMapper.insertLocationName(location2);
		
		List<Location> list = locationMapper.getLocationNames();
		assertTrue(list.size() > 2);
	}
	
	@Test
	@Transactional
	public void InsertThermometerLocationTest() {
		
		Location location = new Location(1,1);
		
		locationMapper.deleteThermometerLocations();
		locationMapper.insertThermometerLocation(location);
		Location locationResult = locationMapper.getThermometerLocation(location);
		
		assertNotNull(locationResult);
	}
	
	@Test
	@Transactional
	public void TrashThermometerLocationTest() {
		Location location = new Location(1,1);
		
		locationMapper.deleteThermometerLocations();
		locationMapper.insertThermometerLocation(location);
		Location locationResult = locationMapper.getThermometerLocation(location);
		locationMapper.trashThermometerLocation(locationResult.getThermometerLocationId());
		
		List<Location> list = locationMapper.getLocationByThermometerId(location.getThermometerId());
		assertTrue(list.size() == 0);
	}

	public void setLocationMapper(LocationMapper locationMapper) {
		this.locationMapper = locationMapper;
	}
	
}
