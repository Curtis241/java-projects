package org.sakila.ws.data.mapper;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sakila.ws.data.CurrentObservationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = {"test-mapper-configuration.xml"})
public class WeatherMapperTests extends AbstractTransactionalJUnit4SpringContextTests {


	@Autowired
	private WeatherMapper mapper;

	
	@Test
	@Transactional
	public void insertMultipleRecords() {
		
		CurrentObservationImpl mock1 = getCurrentObservationMock();
		CurrentObservationImpl mock2 = getCurrentObservationMock();
		
		mapper.insertWeather(mock1);
		mapper.insertWeather(mock2);
		
		List<CurrentObservationImpl> result = mapper.selectAllWeather();
		
		assertNotNull(result);
		assertTrue(result.size() > 0);
		
	}
	
	@Test
	@Transactional
	public void insertSingleRecord(){
		
		CurrentObservationImpl mock = getCurrentObservationMock();
		mapper.deleteWeather(mock);
		mapper.insertWeather(mock);
		
		List<CurrentObservationImpl> result = mapper.selectAllWeather();
		
		assertNotNull(result);
		assertTrue(result.size() > 0);
	
}
	
	public CurrentObservationImpl getCurrentObservationMock() {

		CurrentObservationImpl currentObservation = new CurrentObservationImpl();
		currentObservation.setCurrentObservationId(999);
		currentObservation.setStationId("CYYC");
		currentObservation.setDewpoint(-3);
		currentObservation.setFeelsLike(21);
		currentObservation.setLocalTime("Sat, 11 May 2013 22:13:12 -0600");
		currentObservation.setObservationTime("Last Updated on May 11, 10:00 PM MDT");
		currentObservation.setPrecipToday(0.0);
		currentObservation.setRelativeHumidity("20%");
		currentObservation.setTemperature(21);
		currentObservation.setVisibility(24.1);
		currentObservation.setWeather("Mostly Cloudy");
		currentObservation.setWindString("From the West at 14 MPH Gusting to 21 MPH");
		
		
		return currentObservation;
	}

	public void setMapper(WeatherMapper mapper) {
		this.mapper = mapper;
	}
}
