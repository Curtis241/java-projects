package org.sakila.ws.data;

import javax.xml.bind.annotation.XmlElement;

public class Location {

	private int locationId;
	private int thermometerLocationId;
	private String locationName;
	private int thermometerId;
	private int trash;
	
	public Location() {
		
	}
	
	public Location(int locationId, int thermometerId) {
		this.locationId = locationId;
		this.thermometerId = thermometerId;
	}
	
	@XmlElement
	public int getThermometerLocationId() {
		return thermometerLocationId;
	}
	public void setThermometerLocationId(int thermometerLocationId) {
		this.thermometerLocationId = thermometerLocationId;
	}
	@XmlElement
	public int getLocationId() {
		return locationId;
	}
	@XmlElement
	public String getLocationName() {
		return locationName;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	@XmlElement
	public int getThermometerId() {
		return thermometerId;
	}
	public void setThermometerId(int thermometerId) {
		this.thermometerId = thermometerId;
	}
	@XmlElement
	public int getTrash() {
		return trash;
	}
	public void setTrash(int trash) {
		this.trash = trash;
	}
	
}
