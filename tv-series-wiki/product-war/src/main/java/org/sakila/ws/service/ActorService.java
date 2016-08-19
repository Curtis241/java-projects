package org.sakila.ws.service;

import java.util.UUID;

import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.sakila.ws.data.Actor;
import org.sakila.ws.data.Series;
import org.sakila.ws.mapper.ActorMapper;
import org.sakila.ws.mapper.SeriesMapper;
import org.springframework.stereotype.Service;

@Service
public class ActorService extends AbstractBaseService<Actor, ActorMapper> implements MapperInitializer {

	protected static Logger logger = Logger.getLogger(ActorService.class);

	private ActorMapper mapper;
	private SeriesMapper seriesMapper;
	
	@Override
	public void initialize() {
		super.logMapperStatus("ActorMapper", "ActorService", mapper);
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
	public Response select(Actor actor) {
		return super.select(actor);
	};
	
	@Override
	public Response insert(Actor actor) {
			
		if(actor == null) {
			throw new IllegalArgumentException("actor is null");
		}
		
		try {
			actor.setId(UUID.randomUUID().toString());
			Series series = seriesMapper.selectByName(actor.getSeriesName());
			actor.setSeriesId(series.getId());
			super.insert(actor); 
			
			return super.selectById(actor.getId());
		} 
		catch(Exception e) {
			return super.getServerErrorResponse(e.getStackTrace().toString());
		}
	};
	
	@Override
	public Response delete(Actor actor) {
		
		if(actor == null) {
			throw new IllegalArgumentException("actor is null");
		}
		
		return super.delete(actor); 
	};
	
	@Override
	public Response update(Actor actor) {
		
		if(actor == null) {
			throw new IllegalArgumentException("actor is null");
		}
		
		if(actor.getSeriesName() == null){
			return super.getNullParameterResponse();
		}
			
		Series series = seriesMapper.selectByName(actor.getSeriesName());
		actor.setSeriesId(series.getId());
		super.update(actor);
		
		return super.selectById(actor.getId());
	}

	public ActorMapper getMapper() {
		return mapper;
	}

	public void setMapper(ActorMapper mapper) {
		this.mapper = mapper;
	}

	public SeriesMapper getSeriesMapper() {
		return seriesMapper;
	}

	public void setSeriesMapper(SeriesMapper seriesMapper) {
		this.seriesMapper = seriesMapper;
	};

	
		
	
}
