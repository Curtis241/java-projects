package org.sakila.ws.controller;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.log4j.Logger;
import org.jboss.resteasy.spi.interception.MessageBodyWriterContext;
import org.jboss.resteasy.spi.interception.MessageBodyWriterInterceptor;
import org.sakila.ws.data.Series;
import org.sakila.ws.service.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@Path("/series")
public class SeriesController implements MessageBodyWriterInterceptor {

	protected static Logger logger = Logger.getLogger(SeriesController.class);
	
	@Autowired(required = true)
	private SeriesService service;
	
	
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
		
		Series series = new Series();
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			series = mapper.readValue(json,Series.class);
		}
		catch (JsonProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();	
		} 
		catch (IOException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
		}
		return service.insert(series);
			
	}

	@DELETE
	@Path("id/{id}")
	@Produces("application/json")
	public Response delete(@PathParam("id") String id) {
		
		Series series = new Series();
		series.setId(id);
		
		return service.delete(series);
	}
	
	@OPTIONS
	@Path("id/{id}")
	public Response handleDeleteCORSRequest(
	        @HeaderParam("Access-Control-Request-Method") final String requestMethod,
	        @HeaderParam("Access-Control-Request-Headers") final String requestHeaders) {
	    final ResponseBuilder retValue = Response.ok();

	    if (requestHeaders != null)
	        retValue.header("Access-Control-Allow-Headers", requestHeaders);

	    if (requestMethod != null)
	        retValue.header("Access-Control-Allow-Methods", requestMethod);

	    retValue.header("Access-Control-Allow-Origin", "*");

	    return retValue.build();
	}
	
	@PUT
	@Produces("application/json")
	@Consumes("application/json")
	public Response update(String json) {
		
		Series series = new Series();
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			series = mapper.readValue(json,Series.class);
		}
		catch (JsonProcessingException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();	
		} 
		catch (IOException e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
		}
		
		return service.update(series); 
	}
	
	@OPTIONS
	public Response handleCORSRequest(
	        @HeaderParam("Access-Control-Request-Method") final String requestMethod,
	        @HeaderParam("Access-Control-Request-Headers") final String requestHeaders) {
	    final ResponseBuilder retValue = Response.ok();

	    if (requestHeaders != null)
	        retValue.header("Access-Control-Allow-Headers", requestHeaders);

	    if (requestMethod != null)
	        retValue.header("Access-Control-Allow-Methods", requestMethod);

	    retValue.header("Access-Control-Allow-Origin", "*");

	    return retValue.build();
	}
	
	@Override
	public void write(MessageBodyWriterContext context) throws IOException, WebApplicationException {
	    context.getHeaders().add("Access-Control-Allow-Origin", "*");
	    context.proceed();
	}
	
	public void setSeriesService(SeriesService service) {
		this.service = service;
	}
	
}
