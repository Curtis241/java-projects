package org.sakila.ws.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sakila.ws.data.Temperature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = {"test-service-configuration.xml"})
public class TemperatureServiceTests   {

	protected static Logger logger = Logger.getLogger(TemperatureServiceTests.class);
	
	@Autowired
	private TemperatureService temperatureService;
	
	@Test
	@Transactional
	public void GetTemperaturesByLocation()
	{
		Temperature temperature = new Temperature(19, 1,"Guest Room", 19, 16, 23);
		temperatureService.setTemperatureByLocation(temperature);
		
		List<Temperature> list = temperatureService.getTemperaturesByLocation("Guest Room");
		
		assertNotNull(list);
		assertTrue(list.size() > 0);
		
	}

	public void setTemperatureService(final TemperatureService temperatureService) {
		this.temperatureService = temperatureService;
	}
}
