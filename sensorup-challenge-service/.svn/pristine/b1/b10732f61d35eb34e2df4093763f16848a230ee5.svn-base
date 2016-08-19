package org.corp.ws.service;

import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.corp.ws.data.SensorImpl;
import org.corp.ws.data.mapper.SensorMapper;
import org.joda.time.Interval;
import org.joda.time.Period;
import org.joda.time.Seconds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.co.geolib.geolib.C2DLine;
import uk.co.geolib.geolib.C2DPoint;
import uk.co.geolib.geolib.C2DVector;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SensorService {

	protected static Logger logger = Logger.getLogger(SensorService.class);
	
	@Autowired(required = true)
	private SensorMapper sensorMapper;
	
	public Response getAllSensors() {
		return convertListToJson(getSensorMapper().SelectAll());
	}
	
	public Response getSensor(String name) {
		
		if(name.isEmpty()) {
			throw new IllegalArgumentException("sensor name cannot be null");
		}
		
		return convertListToJson(getSensorMapper().SelectByName(name));
	}
	
	public Response addSensor() {
		
		SensorImpl newSensor = new SensorImpl();
		String newSensorName = generateUniqueSensorName();
		newSensor.setSensorName(newSensorName);
		newSensor.setLastUpdate(new Date());
		getSensorMapper().Insert(newSensor);
		
		return convertListToJson(getSensorMapper().SelectByName(newSensorName));
	}
	
	public void removeSensor(String name) {
		
		if(name.isEmpty()) {
			throw new IllegalArgumentException("sensor name cannot be null");
		}
		
		SensorImpl sensor = new SensorImpl();
		sensor.setSensorName(name);
		getSensorMapper().Remove(sensor);
	}
	
	
	public Response simulateSensorMovement() {
		
		List<SensorImpl> sensors = getSensorMapper().SelectAll();
		
		if(sensors != null && sensors.size() > 0) {
			try {
				//Iterate over list of sensors
				for(SensorImpl sensor : sensors) {
					
					//Size of Saddledome Olympic ice surface 30.5m x 60.9m (100 ft x 200 ft)
					//Pick random number between 0-30 for X, and 0-60 for Y
					Random rand = new Random(); 
					int newX = rand.nextInt(30);
					int newY = rand.nextInt(60);
					
					//Calculate direction and distance
					int distance = calculateDistance(sensor,newX,newY);
					int direction = calculateDirection(sensor,newX,newY);
					
					//Calculate speed
					Date currentDate = new Date();
					int speed = calculateSpeed(distance,sensor.getLastUpdate(), currentDate);
					
					//Set heart rate and temperature based on speed.
					//If sensor (dog) is moving more than 2 m/s = resting, 4 m/s = walking, 10 m/s = running
					//Greyhound can run 18 meters per second or 65 kilometres per hour.
					//Resting heart rate for dogs approx 70-90, walking 90-120, and running 120-200.
					//Temperature for dogs approx 38.3-39.2 degrees.
					
					int heartRate = 80;
					int temperature = 37;
				
					if(speed > 4 && speed < 10) {
						heartRate = 100;
						temperature = 38;
					}
					else if (speed > 10) {
						heartRate = 150;
						temperature = 39;
					}
					
					//Set X,Y position and other calculated numbers.
					sensor.setLastUpdate(currentDate);
					sensor.setDirection(direction);
					sensor.setDistance(distance);
					sensor.setSpeed(speed);
					sensor.setHeartRate(heartRate);
					sensor.setTemperature(temperature);
					sensor.setX(newX);
					sensor.setY(newY);
					
					//Call update for sensor record and persist to database.
					getSensorMapper().Update(sensor);
				}
			} catch (Exception e) {
				logger.error(e);
				return getServerErrorResponse(e.getStackTrace().toString());
			}
		}
		
		return Response.ok().build();
	}
	
	private C2DLine createLine(SensorImpl sensor, int x, int y) {
		
		C2DLine line = new C2DLine();
		C2DPoint pointFrom = new C2DPoint(sensor.getX(),sensor.getY());
		C2DPoint pointTo = new C2DPoint(x,y);
		line.Set(pointFrom, pointTo);
		
		return line;
	}
	
	private int calculateDirection(SensorImpl sensor, int x, int y) {
		
		C2DLine line = createLine(sensor,x,y);
		C2DVector vector = line.vector;
		Double angleInRadians = vector.AngleFromNorth();
		Double degrees = Math.toDegrees(angleInRadians);
		
		return degrees.intValue();
	}
	
	
	private int calculateDistance(SensorImpl sensor, int x, int y) {
		
		C2DLine line = createLine(sensor,x,y);
		Double length = line.GetLength();
		
		return length.intValue();
	}
	
	private int calculateSpeed(int distance, Date fromDate, Date toDate) {
		
		Interval interval;
		interval = new Interval(fromDate.getTime(),toDate.getTime());
		Period period = interval.toPeriod();
		Seconds standardSeconds = period.toStandardSeconds();
		
		int seconds = standardSeconds.getSeconds();
		int speed = (int) (distance / seconds);
		
		return speed;
		
	}
	
	private String generateUniqueSensorName() {
		
		int sensorId = getSensorMapper().SelectNextId();
		
		return "id" + String.format("%03d", sensorId);
	}
	
	private Response convertListToJson(List<SensorImpl> list) {
		
		ObjectMapper mapper = new ObjectMapper();
		String json;
		try {
			json = mapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			logger.error(e);
			return getServerErrorResponse(e.getStackTrace().toString());
		}

		return getOkResponse(json);
	}

	private Response getServerErrorResponse(String exception) {
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(exception).build();
	}
	
	//Reference: http://stackoverflow.com/questions/23450494/how-to-enable-cross-domain-requests-on-jax-rs-web-services
	private Response getOkResponse(String json) {
		return Response.
				ok(json, MediaType.APPLICATION_JSON)
				.header("Access-Control-Allow-Origin", "*")
	            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
	            .header("Access-Control-Allow-Credentials", "true")
	            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
	            .header("Access-Control-Max-Age", "1209600")
				.build();
	}
	
	public SensorMapper getSensorMapper() {
		return sensorMapper;
	}

	public void setSensorMapper(SensorMapper sensorMapper) {
		this.sensorMapper = sensorMapper;
	}
}
