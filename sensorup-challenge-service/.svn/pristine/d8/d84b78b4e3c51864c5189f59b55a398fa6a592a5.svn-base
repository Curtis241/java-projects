package org.corp.ws.data.mapper;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.corp.ws.data.SensorImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = {"test-mapper-configuration.xml"})
public class SensorMapperTests {
	
	protected static Logger logger = Logger.getLogger(SensorMapperTests.class);

	
	@Autowired
	private SensorMapper sensorMapper;
	
	
	@Test
	@Transactional
	public void InsertSensorTest(){
		SensorImpl sensor = getMockSensor("id900");
		
		sensorMapper.Insert(sensor);
		
		List<SensorImpl> sensorResults = sensorMapper.SelectByName("id900");
		
		assertTrue(sensorResults.size() == 1);
	}

	private SensorImpl getMockSensor(String sensorName) {
		SensorImpl sensor = new SensorImpl();
		sensor.setSensorName(sensorName);
		sensor.setX(10);
		sensor.setY(20);
		sensor.setHeartRate(120);
		sensor.setDirection(0);
		sensor.setSpeed(0);
		sensor.setTemperature(36);
		return sensor;
	}
	
	@Test
	@Transactional
	public void RemoveSensorTest() {
		SensorImpl sensor = getMockSensor("id900");
		
		sensorMapper.Insert(sensor);
		
		sensor.setActive(0);
		sensorMapper.Remove(sensor);
		
		List<SensorImpl> sensorResults = sensorMapper.SelectByName("id900");
		
		assertTrue(sensorResults.size() == 1);
		assertTrue(sensorResults.get(0).getActive() == 0);
		
	}
	
	@Test
	@Transactional
	public void SelectAllSensorsTest() {
		SensorImpl sensor1 = getMockSensor("id900");
		SensorImpl sensor2 = getMockSensor("id901");
		SensorImpl sensor3 = getMockSensor("id902");
		
		sensorMapper.Insert(sensor1);
		sensorMapper.Insert(sensor2);
		sensorMapper.Insert(sensor3);
		
		List<SensorImpl> sensorResults = sensorMapper.SelectAll();
		
		assertTrue(sensorResults.size() >= 3);
	}
	
	@Test
	@Transactional
	public void UpdateSensorTest() {
		SensorImpl sensor = getMockSensor("id900");
		
		sensorMapper.Insert(sensor);
		
		sensor.setX(50);
		sensor.setY(100);
		sensor.setHeartRate(150);
		sensor.setDirection(50);
		sensor.setSpeed(5);
		sensor.setTemperature(38);
		
		sensorMapper.Update(sensor);
		
		List<SensorImpl> sensorResults = sensorMapper.SelectByName("id900");
		
		assertTrue(sensorResults.size() == 1);
		SensorImpl sensorResult = sensorResults.get(0);
		assertTrue(sensorResult.getX() == 50f);
		assertTrue(sensorResult.getY() == 100f);
		assertTrue(sensorResult.getHeartRate() == 150);
		assertTrue(sensorResult.getDirection() == 50);
		assertTrue(sensorResult.getSpeed() == 5);
		assertTrue(sensorResult.getTemperature() == 38);
		
	}
	
	@Test
	@Transactional
	public void SelectNextIdTest() {
		int sensorId = sensorMapper.SelectNextId();
		String sensorIdString = Integer.toString(sensorId);
		
		assertTrue(!sensorIdString.isEmpty());
	}
}
