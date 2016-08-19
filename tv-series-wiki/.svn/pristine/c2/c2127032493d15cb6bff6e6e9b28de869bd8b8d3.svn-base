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
import org.sakila.ws.data.Director;
import org.sakila.ws.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@Path("/director")
public class DirectorController {

	protected static Logger logger = Logger.getLogger(DirectorController.class);
	
	@Autowired(required = true)
	private DirectorService service;
	
	@GET
	@Produces("application/json")
	public Response selectAll(){
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
		
	@GET
	@Path("series/name/{name}")
	@Produces("application/json")
	public Response selectDirectorsBySeriesName(@PathParam("name") String seriesName) {
		
		Director director = new Director();
		director.setSeriesName(seriesName);
		
		return service.select(director);
	}
	
	@GET
	@Path("series/id/{id}")
	@Produces("application/json")
	public Response selectDirectorsBySeriesId(@PathParam("id") String seriesId){
		
		Director director = new Director();
		director.setSeriesId(seriesId);
		
		return service.select(director);
	}
	
	@POST
	@Consumes("application/json")
	public Response insert(String json) {
		
		Director director = new Director();
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			director = mapper.readValue(json,Director.class);
		}
		catch (JsonProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();	
		} 
		catch (IOException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
		}
		return service.insert(director);
			
	}

	@DELETE
	@Path("id/{id}")
	@Produces("application/json")
	public Response delete(@PathParam("id") String id) {
		
		Director director = new Director();
		director.setId(id);
		
		return service.delete(director);
	}
	
	@PUT
	@Produces("application/json")
	@Consumes("application/json")
	public Response update(String json) {
		
		Director director = new Director();
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			director = mapper.readValue(json,Director.class);
		}
		catch (JsonProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();	
		} 
		catch (IOException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
		}
		
		return service.update(director);
	}
	
	
	public void setDirectorService(DirectorService service) {
		this.service = service;
	}
}
