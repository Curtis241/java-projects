package org.sakila.ws.service;

import java.util.UUID;

import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.sakila.ws.data.Rating;
import org.sakila.ws.mapper.RatingMapper;

public class RatingService extends AbstractBaseService<Rating,RatingMapper> implements MapperInitializer {
	
	protected static Logger logger = Logger.getLogger(RatingService.class);
	
	private RatingMapper mapper;
	
	@Override
	public void initialize() {
		super.logMapperStatus("RatingMapper", "RatingService", mapper);
		super.setMapper(mapper);
	}
	
	@Override
	public Response selectAll() {
		return super.selectAll();
	}

	@Override
	public Response selectById(String guid) {
		return super.selectById(guid);
		
	}
	
	@Override
	public Response selectByName(String name) {
		return super.selectByName(name);
		
	}
	
	@Override
	public Response select(Rating rating) {
		return super.select(rating);
		
	}
	
	@Override
	public Response insert(Rating rating) {

		if(rating == null) {
			throw new IllegalArgumentException("rating is null");
		}
		
		try {
			rating.setId(UUID.randomUUID().toString());
			super.insert(rating); 
			
			return super.selectById(rating.getId());
		} 
		catch(Exception e) {
			return super.getServerErrorResponse(e.getStackTrace().toString());
		}
		
	}
	
	@Override
	public Response delete(Rating rating) {
		
		if(rating == null) {
			throw new IllegalArgumentException("rating is null");
		}
		
		return super.delete(rating);
		
	}
	
	@Override
	public Response update(Rating rating) {
		
		if(rating == null) {
			throw new IllegalArgumentException("rating is null");
		}
		
		if(rating.getName() == null){
			return super.getNullParameterResponse();
		}
		
		super.update(rating);
		return super.selectById(rating.getId());
		
	}

	public RatingMapper getMapper() {
		return mapper;
	}

	public void setMapper(RatingMapper mapper) {
		this.mapper = mapper;
	}
}
