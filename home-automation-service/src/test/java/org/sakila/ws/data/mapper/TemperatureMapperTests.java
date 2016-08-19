package org.sakila.ws.data.mapper;

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
@ContextConfiguration(locations = {"test-mapper-configuration.xml"})
public class TemperatureMapperTests  {

	@Autowired
	private TemperatureMapper temperatureMapper;
	
	protected static Logger logger = Logger.getLogger(TemperatureMapperTests.class);
	
	@Test
	@Transactional
	public void GetTemperaturesByLocationTest(){
		
		Temperature temperature = new Temperature(19, 1,"Location1", 19, 16, 23);
		temperatureMapper.deleteTemperature(temperature);
		temperatureMapper.insertTemperature(temperature);
		
		List<Temperature> temperatureList = temperatureMapper.getTemperaturesByLocation("Location1");
		
		assertNotNull(temperatureList);
		assertTrue(temperatureList.size() == 1);
	
	}

	public void setTemperatureMapper(TemperatureMapper temperatureMapper) {
		this.temperatureMapper = temperatureMapper;
	}
}
