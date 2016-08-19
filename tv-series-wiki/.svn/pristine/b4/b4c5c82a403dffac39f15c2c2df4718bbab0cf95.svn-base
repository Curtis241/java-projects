package org.sakila.ws.service;

import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import org.sakila.ws.mapper.CommonMapper;
import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public abstract class AbstractBaseService<T, M extends CommonMapper<T>> implements BaseService<T> {

	@Value("${exception.jsonprocessing}")
	private String mappingException;
	
	@Value("${exception.io}")
	private String ioException;
	
	@Value("${exception.requestnotfound}")
	private String requestNotFound;
	
	@Value("${exception.nullparameter}")
	private String nullParameter;
	
	
	protected static Logger logger = Logger.getLogger(AbstractBaseService.class);	
	
	private CommonMapper<T> mapper;
	
	public void setMapper(CommonMapper<T> mapper) {
		this.mapper = mapper;
	}
	
	public void logMapperStatus(String mapperName,String serviceName,CommonMapper<T> mapper) {
		
		if(mapper != null){
			String message = "Setting " + mapperName + " in " + serviceName + ": ( mapper result " + mapper.toString() + " )";
			logger.debug(message);
		}
		else
		{
			logger.debug(mapperName + " is null");
		}
	}
	
	@Override
	public Response selectById(String guid) {
		
		if(guid == null) {
			throw new IllegalArgumentException("null guid argument");
		}
			
		return getResponse(mapper.selectById(guid));
	}
	
	@Override
	public Response selectByName(String name) {
		
		if(name == null) {
			throw new IllegalArgumentException("null name argument");
		}
		
		return getResponse(mapper.selectByName(name));
	}

	@Override
	public Response selectAll() {
		
		return getResponse(mapper.selectAll());
	}
	
	@Override
	public Response select(T obj) {
		
		if(obj == null) {
			throw new IllegalArgumentException("null obj argument");
		}
		
		return getResponse(mapper.select(obj));
	}

	@Override
	public Response insert(T obj) {
		
		try {
			mapper.insert(obj);
		}
		catch(Exception e) {
			return getServerErrorResponse(e.getStackTrace().toString());
		}
	
		return getOkResponse();
	}

	@Override
	public Response delete(T obj) {

		try {
			mapper.delete(obj);
		}
		catch(Exception e) {
			return getServerErrorResponse(e.getStackTrace().toString());
		}
		
		return getOkResponse();
	}

	@Override
	public Response update(T obj) {
		
		try {
			mapper.update(obj);
		}
		catch(Exception e) {
			return getServerErrorResponse(e.getStackTrace().toString());
		}
		
		return getOkResponse();
	}

	public Response getResponse(List<T> list) {
		
		Response contentResponse = checkListForContent(list); 
		int ok = Status.OK.getStatusCode();
		
		if(ok == contentResponse.getStatus()) {
			return convertListToJson(list);
		}
		else
		{
			return contentResponse;
		}
	}

	public Response getResponse(T object) {
		
		Response contentResponse = checkObjectForContent(object); 
		int ok = Status.OK.getStatusCode();
		
		if(ok == contentResponse.getStatus()) {
			return convertObjectToJson(object);
		}
		else
		{
			return contentResponse;
		}
		
	}
	
	public Response convertListToJson(List<T> list) {
		ObjectMapper mapper = new ObjectMapper();
		String json;
		try {
			json = mapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			logger.error(e);
			return getServerErrorResponse(e.getStackTrace().toString());
		}

		return getOkResponse(json);
	}
	
	public Response convertObjectToJson(T object) {
		ObjectWriter writer = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json;
		try {
			json = writer.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			logger.error(e);
			return getServerErrorResponse(e.getStackTrace().toString());
		}

		return getOkResponse(json);
	}
	
	public Response checkListForContent(List<T> list ){
		if(list == null || list.size() == 0) {
			return getRequestNotFoundReponse();
		}
		return getOkResponse();
	}
	
	public Response checkObjectForContent(T object ){
		if(object == null) {
			return getNotFoundResponse();
		}
		return getOkResponse();
	}
	
	public Response getIoExceptionResponse(String exception) {
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(exception).build();
	}
	
	public Response getNullParameterResponse() {
		return Response.serverError().entity(nullParameter).build();
	}
	
	public Response getNullParameterResponse(String field) {
		return Response.serverError().entity(field + " is null").build();
	}
	
	public Response getRequestNotFoundReponse() {
		return Response.status(Response.Status.NOT_FOUND).entity(requestNotFound).build();
	}
	
	public Response getOkResponse(String json) {
		return Response.ok(json, MediaType.APPLICATION_JSON).build();
	}
	
	public Response getOkResponse() {
		return Response.status(Status.OK).build();
	}
	
	public Response getNotFoundResponse() {
		return Response.status(Status.NOT_FOUND).build();
	}
	
	public Response getServerErrorResponse(String exception) {
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(exception).build();
	}
}
