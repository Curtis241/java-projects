package org.sakila.ws.service;

import java.util.UUID;

import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.sakila.ws.data.Series;
import org.sakila.ws.mapper.SeriesMapper;
import org.springframework.stereotype.Service;

@Service
public class SeriesService extends AbstractBaseService<Series,SeriesMapper> implements MapperInitializer {

	protected static Logger logger = Logger.getLogger(SeriesService.class);

	private SeriesMapper mapper;
	
	@Override
	public void initialize() {
		super.logMapperStatus("SeriesMapper", "SeriesService", mapper);
		super.setMapper(mapper);
	}
	
	@Override
	public Response selectAll() {
		return super.selectAll();
	}
	
	@Override
	public Response selectById(String guid) {
		return super.selectById(guid);
	};
	
	@Override
	public Response selectByName(String name) {
		return super.selectByName(name);
	};
	
	@Override
	public Response select(Series series) {
		return super.select(series);
	};
	
	@Override
	public Response insert(Series series) {
			
		if(series == null) {
			throw new IllegalArgumentException("series is null");
		}
		
		try {
			series.setId(UUID.randomUUID().toString());
			return super.insert(series); 
		} 
		catch(Exception e) {
			return super.getServerErrorResponse(e.getStackTrace().toString());
		}
	};
	
	@Override
	public Response delete(Series series) {
		
		if(series == null) {
			throw new IllegalArgumentException("series is null");
		}
		
		return super.delete(series); 
	};
	
	@Override
	public Response update(Series series) {
		
		if(series == null) {
			throw new IllegalArgumentException("series is null");
		}
		
		Response response = super.selectById(series.getId());
		
		if(response.getStatus() == Response.Status.NOT_FOUND.getStatusCode() ) {
			super.insert(series);
		}
		else
		{
			super.update(series);		
		}
		
		return super.selectById(series.getId());
	}

	public SeriesMapper getMapper() {
		return mapper;
	}

	public void setMapper(SeriesMapper mapper) {
		this.mapper = mapper;
	};
	
}
