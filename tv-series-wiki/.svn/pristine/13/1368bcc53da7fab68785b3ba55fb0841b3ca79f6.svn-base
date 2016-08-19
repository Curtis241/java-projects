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
import org.sakila.ws.data.Actor;
import org.sakila.ws.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@Path("/actor")
public class ActorController {

	protected static Logger logger = Logger.getLogger(ActorController.class);
	
	@Autowired(required = true)
	private ActorService service;
			
	@GET
	@Path("name/{name}")
	@Produces("application/json")
	public Response selectByName(@PathParam("name") String name){
		return service.selectByName(name);
	}
	
	@GET
	@Path("character/{character}")
	@Produces("application/json")
	public Response selectByCharacterName(@PathParam("character") String character){
		
		Actor actor = new Actor();
		actor.setCharacterName(character);
		
		return service.select(actor);
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
	public Response selectActorsBySeriesName(@PathParam("name") String seriesName) {
		
		Actor actor = new Actor();
		actor.setSeriesName(seriesName);
		
		return service.select(actor);
	}
	
	@GET
	@Path("series/id/{id}")
	@Produces("application/json")
	public Response selectActorsBySeriesId(@PathParam("id") String seriesId){
		
		Actor actor = new Actor();
		actor.setSeriesId(seriesId);
		
		return service.select(actor);
	}
	
	@POST
	@Consumes("application/json")
	public Response insert(String json) {
		
		Actor actor = new Actor();
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			actor = mapper.readValue(json,Actor.class);
		}
		catch (JsonProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();	
		} 
		catch (IOException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
		}
		return service.insert(actor);
			
	}

	@DELETE
	@Path("id/{id}")
	@Produces("application/json")
	public Response delete(@PathParam("id") String id) {
		
		Actor actor = new Actor();
		actor.setId(id);
		
		return service.delete(actor);
	}
	
	@PUT
	@Produces("application/json")
	@Consumes("application/json")
	public Response update(String json) {
		
		Actor actor = new Actor();
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			actor = mapper.readValue(json,Actor.class);
		}
		catch (JsonProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();	
		} 
		catch (IOException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
		}
		
		return service.update(actor);
	}
	
	
	public void setActorService(ActorService service) {
		this.service = service;
	}
}
