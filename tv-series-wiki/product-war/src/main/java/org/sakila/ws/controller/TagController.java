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
import org.sakila.ws.data.Tag;
import org.sakila.ws.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@Path("/tag")
public class TagController {

	protected static Logger logger = Logger.getLogger(TagController.class);
	
	@Autowired(required = true)
	private TagService service;
			
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
	public Response selectTagsBySeriesName(@PathParam("name") String seriesName) {
		
		Tag tag = new Tag();
		tag.setSeriesName(seriesName);
		
		return service.select(tag);
	}
	
	@GET
	@Path("series/id/{id}")
	@Produces("application/json")
	public Response selectTagsBySeriesId(@PathParam("id") String seriesId){
		
		Tag tag = new Tag();
		tag.setSeriesId(seriesId);
		
		return service.select(tag);
	}
	
	@POST
	@Consumes("application/json")
	public Response insert(String json) {
		
		Tag tag = new Tag();
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			tag = mapper.readValue(json,Tag.class);
		}
		catch (JsonProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();	
		} 
		catch (IOException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
		}
		return service.insert(tag);
			
	}

	@DELETE
	@Path("id/{id}")
	@Produces("application/json")
	public Response delete(@PathParam("id") String id) {
		
		Tag tag = new Tag();
		tag.setId(id);
		
		return service.delete(tag);
	}
	
	@PUT
	@Produces("application/json")
	@Consumes("application/json")
	public Response update(String json) {
		
		Tag tag = new Tag();
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			tag = mapper.readValue(json,Tag.class);
		}
		catch (JsonProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();	
		} 
		catch (IOException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
		}
		
		return service.update(tag);
	}
	
	
	public void setTagService(TagService service) {
		this.service = service;
	}
}
