package org.sakila.ws.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.jboss.resteasy.spi.HttpResponse;
import org.sakila.ws.controller.ResponseObject.STATUS;
import org.sakila.ws.data.Temperature;
import org.sakila.ws.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@Path("/ws")
public class TemperatureController {
	
	protected static Logger logger = Logger.getLogger(TemperatureController.class);
	
	@Context HttpResponse response;

	@Autowired(required = true)
	private TemperatureService service;
	

	public TemperatureController(){
		
	}
	
	@GET
	@Path("temperatures")
	@Produces("application/json")
	public List<Temperature> getTemperaturesByLocation(@QueryParam("location") String location){
		return service.getTemperaturesByLocation(location);
	}
	
	@POST
	@Path("temperature")
	@Produces("application/json")
	public Response setTemperature(@QueryParam("value") float value, @QueryParam("id") int thermometerId) {
		
		ResponseObject obj = new ResponseObject(STATUS.SUCCESS);
		
		try{
			service.setTemperatureToMessageStore(value, thermometerId);
			response.setStatus(200);
		}
		catch (Exception ex)
		{
			obj.setStatus(STATUS.FAILED);
			return Response.status(500).entity(obj).build();
		}
			
		return Response.status(200).entity(obj).build();
		
	}
	
	public void TemperatureService(TemperatureService service){
		this.service = service;
	}
	
	
	
}
