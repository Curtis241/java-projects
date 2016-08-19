package org.sakila.ws.service;

import java.util.UUID;

import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.sakila.ws.data.Director;
import org.sakila.ws.data.Series;
import org.sakila.ws.mapper.DirectorMapper;
import org.sakila.ws.mapper.SeriesMapper;

public class DirectorService extends AbstractBaseService<Director,DirectorMapper> implements MapperInitializer{

	protected static Logger logger = Logger.getLogger(DirectorService.class);
	
	private DirectorMapper mapper;
	private SeriesMapper seriesMapper;
	
	@Override
	public void initialize() {
		super.logMapperStatus("DirectorMapper", "DirectorService", mapper);
		super.setMapper(mapper);
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
	public Response select(Director director) {
		return super.select(director);
	};
	
	@Override
	public Response insert(Director director) {
			
		if(director == null) {
			throw new IllegalArgumentException("director is null");
		}
		
		try {
			director.setId(UUID.randomUUID().toString());
			Series series = seriesMapper.selectByName(director.getSeriesName());
			director.setSeriesId(series.getId());
			
			super.insert(director);
			
			return super.selectById(director.getId());
		} 
		catch(Exception e) {
			return super.getServerErrorResponse(e.getStackTrace().toString());
		}
	};
	
	@Override
	public Response delete(Director director) {
		
		if(director == null) {
			throw new IllegalArgumentException("director is null");
		}
		
		return super.delete(director); 
	};
	
	@Override
	public Response update(Director director) {
		
		if(director == null) {
			throw new IllegalArgumentException("director is null");
		}
		
		super.update(director);
		return super.selectById(director.getId());
	}

	public DirectorMapper getMapper() {
		return mapper;
	}

	public void setMapper(DirectorMapper mapper) {
		this.mapper = mapper;
	};
	
	public SeriesMapper getSeriesMapper() {
		return seriesMapper;
	}

	public void setSeriesMapper(SeriesMapper seriesMapper) {
		this.seriesMapper = seriesMapper;
	};
}
