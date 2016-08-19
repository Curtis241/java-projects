package org.corp.ws.controller;

import java.io.IOException;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.log4j.Logger;
import org.corp.ws.service.SensorService;
import org.jboss.resteasy.spi.HttpResponse;
import org.jboss.resteasy.spi.interception.MessageBodyWriterContext;
import org.jboss.resteasy.spi.interception.MessageBodyWriterInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@SuppressWarnings("deprecation")
@Controller
@Path("/ws")
public class SensorController  {

protected static Logger logger = Logger.getLogger(SensorController.class);
	
	@Context HttpResponse response;

	@Autowired(required = true)
	private SensorService sensorService;
	
	@GET
	@Path("sensors")
	@Produces("application/json")
	public Response getAllSensors(){
		return getSensorService().getAllSensors();
	}

	@GET
	@Path("sensor/{name}")
	public Response getSensor(@PathParam("name") String name) {
		return getSensorService().getSensor(name);
	}
	
	@POST
	@Path("sensor")
	@Produces("application/json")
	public Response addSensor() {
		return getSensorService().addSensor();
	}
	
	@DELETE
	@Path("sensor/{name}")
	public Response removeSensor(@PathParam("name") String name) {
		
		try {
			getSensorService().removeSensor(name);
			return Response.ok().build();
		}
		catch (Exception ex)
		{
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex).build();
		}

	}
	
	@POST
	@Path("simulate")
	public Response simulateSensorMovement() {
		return getSensorService().simulateSensorMovement();
	}

	public SensorService getSensorService() {
		return sensorService;
	}

	public void setSensorService(SensorService sensorService) {
		this.sensorService = sensorService;
	}

	

	
	
	
}
