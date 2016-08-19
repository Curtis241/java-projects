package org.sakila.ws.controller;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="response")
public class ResponseObject {
	
	public enum STATUS {SUCCESS,FAILED}

	private STATUS status;;
	
	public ResponseObject(STATUS status){
		this.status = status;
	}
	
	public ResponseObject(){
		
	}
	
	public void setStatus(STATUS status){
		this.status = status;
	}
	
	@XmlElement
	public String getStatus(){
		return status.toString();
	}
}
