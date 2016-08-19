package org.corp.ws.data;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SensorImpl implements Sensor {

	@JsonIgnore
	private int sensorId;
	
	@JsonProperty("name")
	private String sensorName;
	
	@JsonProperty("x")
	private int x;
	
	@JsonProperty("y")
	private int y;
	
	@JsonProperty("heartrate")
	private int heartRate;
	
	@JsonProperty("temperature")
	private int temperature;
	
	@JsonProperty("direction")
	private int direction;
	
	@JsonProperty("speed")
	private int speed;
	
	@JsonIgnore
	private int active;
	
	@JsonIgnore
	private Date lastUpdate;
	
	@JsonProperty("distance")
	private int distance;
	
	
	@Override
	public String getSensorName() {
		return sensorName;
	}

	@Override
	public void setSensorName(String sensorName) {
		this.sensorName = sensorName;

	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public void setX(int x) {
		this.x = x;

	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public int getHeartRate() {
		return heartRate;
	}

	@Override
	public void setHeartRate(int heartRate) {
		this.heartRate = heartRate;
	}

	@Override
	public int getTemperature() {
		return temperature;
	}

	@Override
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	@Override
	public int getDirection() {
		return direction;
	}

	@Override
	public void setDirection(int direction) {
		this.direction = direction;
	}

	@Override
	public int getSpeed() {
		return speed;
	}

	@Override
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public int getId() {
		return sensorId;
	}

	@Override
	public int getActive() {
		return active;
	}

	@Override
	public void setActive(int active) {
		this.active = active;
	}

	@Override
	public Date getLastUpdate() {
		return lastUpdate;
	}

	@Override
	public void setLastUpdate(Date datetime) {
		this.lastUpdate = datetime;
	}

	@Override
	public int getDistance() {
		return distance;
	}

	@Override
	public void setDistance(int distance) {
		this.distance = distance;
	}

}
