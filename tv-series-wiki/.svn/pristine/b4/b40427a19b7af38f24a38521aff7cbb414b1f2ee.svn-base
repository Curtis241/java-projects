package org.sakila.ws.service;

import java.util.List;
import java.util.UUID;

import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.jboss.resteasy.spi.NotImplementedYetException;
import org.sakila.ws.data.Actor;
import org.sakila.ws.data.FirstBilledCast;
import org.sakila.ws.mapper.ActorMapper;
import org.sakila.ws.mapper.FirstBilledCastMapper;

public class FirstBilledCastService extends AbstractBaseService<FirstBilledCast, FirstBilledCastMapper> implements MapperInitializer {

	protected static Logger logger = Logger.getLogger(FirstBilledCastService.class);
	
	private ActorMapper actorMapper;
	private FirstBilledCastMapper mapper;
	
	@Override
	public void initialize() {
		super.logMapperStatus("FirstBilledCastMapper", "FirstBilledCastService", mapper);
		super.setMapper(mapper);
	}

	@Override
	public Response selectById(String guid) {
		return super.getResponse(mapper.selectById(guid));
	}

	@Override
	public Response selectByName(String name) {
		return super.getResponse(mapper.selectByName(name));
	}

	@Override
	public Response select(FirstBilledCast firstBilledCast) {
		return super.getResponse(mapper.select(firstBilledCast));
	}

	@Override
	public Response insert(FirstBilledCast firstBilledCast) {
		
		if(firstBilledCast == null) {
			throw new IllegalArgumentException("firstBilledCast is null");
		}
		
		if(firstBilledCast.getName() == null){
			return super.getNullParameterResponse("name");
		}
		
		if(firstBilledCast.getActorName() == null){
			return super.getNullParameterResponse("actor");
		}
		
		try {
			Actor actor = actorMapper.selectByName(firstBilledCast.getActorName());
			
			if(actor == null) { 
				return super.getNotFoundResponse();
			}
			
			firstBilledCast.setActorId(actor.getId());			
			firstBilledCast.setId(UUID.randomUUID().toString());
			super.insert(firstBilledCast); 
		
			return super.selectById(firstBilledCast.getId());
			
		} 
		catch(Exception e) {
			return super.getServerErrorResponse(e.getStackTrace().toString());
		}
	}

	@Override
	public Response delete(FirstBilledCast firstBilledCast) {

		if(firstBilledCast == null) {
			throw new IllegalArgumentException("firstBilledCast is null");
		}
		
		return super.delete(firstBilledCast); 
	}

	public Response update(FirstBilledCast firstBilledCast,String expectedName) {
		
		if(firstBilledCast == null) {
			throw new IllegalArgumentException("firstBilledCast is null");
		}
		
		List<FirstBilledCast> firstBilledCastList = mapper.select(firstBilledCast);
		
		for(FirstBilledCast f:firstBilledCastList) {
			f.setName(expectedName);
			mapper.update(f);
		}
		
		firstBilledCast.setName(expectedName);
		return super.getResponse(mapper.select(firstBilledCast));
	}

	@Override
	public Response update(FirstBilledCast firstBilledCast) {
		throw new NotImplementedYetException();
	}
	
	public ActorMapper getActorMapper() {
		return actorMapper;
	}

	public void setActorMapper(ActorMapper actorMapper) {
		this.actorMapper = actorMapper;
	}
	
	public FirstBilledCastMapper getMapper() {
		return mapper;
	}
	
	public void setMapper(FirstBilledCastMapper mapper) {
		this.mapper = mapper;
	}
}