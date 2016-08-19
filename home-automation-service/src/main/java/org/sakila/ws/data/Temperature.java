package org.sakila.ws.data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="temperature")
public class Temperature {

	private int id;
	private float value;
	private String location;
	private int thermometerId;
	private int sampleCount;
	private float sampleMax;
	private float sampleMin;
	
	public Temperature()
	{
		
	}
	
	public Temperature(float value, int thermometerId)
	{
		this.value = value;
		this.thermometerId = thermometerId;
	}
	
	public Temperature(float value, int thermometerId, String location, int count, float min, float max)
	{
		this.value = value;
		this.thermometerId = thermometerId;
		this.location = location;
		this.sampleCount = count;
		this.sampleMin = min;
		this.sampleMax = max;
	}
	
	@XmlElement
	public int getId()
	{
		return this.id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	@XmlElement
	public float getValue(){
		return this.value;
	}
	
	public void setValue(float value){
		this.value = value;
	}
	
	@XmlElement
	public String getLocation(){
		return this.location;
	}
	
	public void setLocation(String location){
		this.location = location;
	}
	
	@XmlElement
	public int getSampleCount() {
		return sampleCount;
	}

	public void setSampleCount(int sampleCount) {
		this.sampleCount = sampleCount;
	}

	@XmlElement
	public float getSampleMax() {
		return sampleMax;
	}

	public void setSampleMax(float sampleMax) {
		this.sampleMax = sampleMax;
	}

	@XmlElement
	public float getSampleMin() {
		return sampleMin;
	}

	public void setSampleMin(float sampleMin) {
		this.sampleMin = sampleMin;
	}

	@XmlElement
	public int getThermometerId() {
		return thermometerId;
	}

	public void setThermometerId(int thermometerId) {
		this.thermometerId = thermometerId;
	}
	
}
