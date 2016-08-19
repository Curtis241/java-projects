package org.sakila.ws.controller;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.sakila.ws.data.FirstBilledCast;
import org.sakila.ws.service.FirstBilledCastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@Path("/firstbilledcast")
public class FirstBilledCastController {
	
	protected static Logger logger = Logger.getLogger(FirstBilledCastController.class);
	
	@Autowired(required = true)
	private FirstBilledCastService service;
	
	
	@GET
	@Path("name/{name}")
	@Produces("application/json")
	public Response selectByName(@PathParam("name") String name) {
		
		FirstBilledCast firstBilledCast = new FirstBilledCast();
		firstBilledCast.setName(name);
		
		return service.select(firstBilledCast);
	}
	
	@POST
	@Consumes("application/json")
	public Response insert(String json) {
		
		FirstBilledCast firstBilledCast = new FirstBilledCast();
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			firstBilledCast = mapper.readValue(json,FirstBilledCast.class);
		}
		catch (JsonProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();	
		} 
		catch (IOException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
		}
		return service.insert(firstBilledCast);
			
	}
	
	@DELETE
	@Path("name/{name}")
	@Produces("application/json")
	public Response deleteByName(@PathParam("name") String name) {
		
		FirstBilledCast firstBilledCast = new FirstBilledCast();
		firstBilledCast.setName(name);
		
		return service.delete(firstBilledCast);
	}
	
	@DELETE
	@Path("id/{id}")
	@Produces("application/json")
	public Response deleteById(@PathParam("id") String id) {
		
		FirstBilledCast firstBilledCast = new FirstBilledCast();
		firstBilledCast.setId(id);
		
		return service.delete(firstBilledCast);
	}
	
	@PUT
	@Path("name/{name}")
	@Produces("application/json")
	@Consumes("application/json")
	public Response update(String json,@PathParam("name") String name) {
		
		FirstBilledCast firstBilledCast = new FirstBilledCast();
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			firstBilledCast = mapper.readValue(json,FirstBilledCast.class);
		}
		catch (JsonProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();	
		} 
		catch (IOException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
		}
		
		return service.update(firstBilledCast, name);
	}

}
