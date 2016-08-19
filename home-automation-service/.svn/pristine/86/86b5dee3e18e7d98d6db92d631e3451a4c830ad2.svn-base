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
import org.sakila.ws.data.Location;
import org.sakila.ws.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@Path("/ws")
public class LocationController {

	protected static Logger logger = Logger.getLogger(TemperatureController.class);
	
	@Context HttpResponse response;

	@Autowired(required = true)
	private LocationService service;
	
	@GET
	@Path("location/names")
	@Produces("application/json")
	public List<Location> getLocationNames(){
		return service.getLocationNames();
	}
	
	@GET
	@Path("location/thermometers")
	@Produces("application/json")
	public List<Location> getThermometerLocations() {
		return service.getThermometerLocations();
	}
	
	@POST
	@Path("location")
	@Produces("application/json")
	public Response setLocationName(@QueryParam("name") String name) {
		
		ResponseObject obj = new ResponseObject(STATUS.SUCCESS);
		
		try{
			service.setLocationName(name);
			response.setStatus(200);
		}
		catch (Exception ex)
		{
			obj.setStatus(STATUS.FAILED);
			return Response.status(500).entity(obj).build();
		}
			
		return Response.status(200).entity(obj).build();
		
	}
	
	@GET
	@Path("location")
	@Produces("application/json")
	public List<Location> getThermometerLocation(@QueryParam("thermometerId") int thermometerId) {
		return service.getThermometerLocation(thermometerId);
	}

	
	@POST
	@Path("thermometer")
	@Produces("application/json")
	public Response setThermometer(@QueryParam("locationId") int locationId,
			@QueryParam("thermometerId") int thermometerId) {

		ResponseObject obj = new ResponseObject(STATUS.SUCCESS);
		
		try{
			service.setThermometer(locationId,thermometerId);
			response.setStatus(200);
		}
		catch (Exception ex)
		{
			obj.setStatus(STATUS.FAILED);
			return Response.status(500).entity(obj).build();
		}
			
		return Response.status(200).entity(obj).build();
	}

	
	@POST
	@Path("thermometer/move")
	@Produces("application/json")
	public Response moveThermometer(@QueryParam("fromLocationId") int fromLocationId,
			@QueryParam("toLocationId") int toLocationId,
			@QueryParam("thermometerId") int thermometerId){
		
		ResponseObject obj = new ResponseObject(STATUS.SUCCESS);
		
		try{
			service.moveThermometer(fromLocationId,toLocationId,thermometerId);
			response.setStatus(200);
		}
		catch (Exception ex)
		{
			obj.setStatus(STATUS.FAILED);
			return Response.status(500).entity(obj).build();
		}
			
		return Response.status(200).entity(obj).build();
	}
}
