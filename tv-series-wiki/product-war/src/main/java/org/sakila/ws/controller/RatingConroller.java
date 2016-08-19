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
import org.sakila.ws.data.Rating;
import org.sakila.ws.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@Path("/rating")
public class RatingConroller {

	protected static Logger logger = Logger.getLogger(RatingConroller.class);
	
	@Autowired(required = true)
	private RatingService service;
	
	@GET
	@Produces("application/json")
	public Response selectAll() {
		return service.selectAll();
	}
	
	@GET
	@Path("name/{name}")
	@Produces("application/json")
	public Response selectByName(@PathParam("name") String name){
		return service.selectByName(name);
	}
	
	@GET
	@Path("id/{id}")
	@Produces("application/json")
	public Response selectById(@PathParam("id") String guid){
		return service.selectById(guid);
	}
		
	@POST
	@Consumes("application/json")
	public Response insert(String json) {
		
		Rating rating = new Rating();
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			rating = mapper.readValue(json,Rating.class);
		}
		catch (JsonProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();	
		} 
		catch (IOException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
		}
		return service.insert(rating);
			
	}

	@DELETE
	@Path("id/{id}")
	@Produces("application/json")
	public Response delete(@PathParam("id") String id) {
		
		Rating rating = new Rating();
		rating.setId(id);
		
		return service.delete(rating);
	}
	
	@PUT
	@Produces("application/json")
	@Consumes("application/json")
	public Response update(String json) {
		
		Rating rating = new Rating();
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			rating = mapper.readValue(json,Rating.class);
		}
		catch (JsonProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();	
		} 
		catch (IOException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
		}
		
		return service.update(rating);
	}
	
	
	public void setRatingService(RatingService service) {
		this.service = service;
	}
}
