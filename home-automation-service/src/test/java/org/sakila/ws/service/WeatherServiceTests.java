package org.sakila.ws.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sakila.ws.data.WeatherImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"test-service-configuration.xml"})
public class WeatherServiceTests {

	@Autowired
	private WeatherService service;

	private ClassPathResource jsonResource;
	
	@Before
	public void Setup() {
		jsonResource = new ClassPathResource("currentObservation.json");
	}
	
	@Test
	public void deserializeWeatherTest() throws IOException {
				            
		String response = FileUtils.readFileToString(jsonResource.getFile());
		
		WeatherImpl weather = service.deserializeJsonResponse(response);
		
		assertNotNull(weather);
		assertEquals(weather.getCurrentObservation().getStationId(),"CYYC");
	}
	
	@Test
	public void getWeatherObservationHttpResponseTest() throws IOException {
		
		WeatherImpl weather = service.getWeather();
		
		assertNotNull(weather);
	}
	
	public void setWeatherService(WeatherService service) {
		this.service = service;
	}
	
	
}
