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
import org.sakila.ws.data.Genre;
import org.sakila.ws.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@Path("/genre")
public class GenreConroller {

	protected static Logger logger = Logger.getLogger(GenreConroller.class);
	
	@Autowired(required = true)
	private GenreService service;
	
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
		
	@POST
	@Consumes("application/json")
	public Response insert(String json) {
		
		Genre genre = new Genre();
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			genre = mapper.readValue(json,Genre.class);
		}
		catch (JsonProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();	
		} 
		catch (IOException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
		}
		return service.insert(genre);
			
	}

	@DELETE
	@Path("id/{id}")
	@Produces("application/json")
	public Response delete(@PathParam("id") String id) {
		
		Genre genre = new Genre();
		genre.setId(id);
		
		return service.delete(genre);
	}
	
	@PUT
	@Produces("application/json")
	@Consumes("application/json")
	public Response update(String json) {
		
		Genre director = new Genre();
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			director = mapper.readValue(json,Genre.class);
		}
		catch (JsonProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();	
		} 
		catch (IOException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
		}
		
		return service.update(director);
	}
	
	
	public void setGenreService(GenreService service) {
		this.service = service;
	}
}
