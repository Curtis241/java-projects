package org.corp.ws.service;

import static org.junit.Assert.*;

import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = {"test-service-configuration.xml"})
public class SensorServiceTests {

	protected static Logger logger = Logger.getLogger(SensorServiceTests.class);

	
	@Autowired
	private SensorService sensorService;
	
	@Test
	@Transactional
	public void simulateTest(){
		Response response = sensorService.simulateSensorMovement();
		
		assertTrue(response.getStatus() == 200);
	}
}
