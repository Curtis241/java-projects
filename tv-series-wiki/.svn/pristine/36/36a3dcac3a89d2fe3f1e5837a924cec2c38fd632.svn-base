package org.sakila.ws.service;

import java.util.UUID;

import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.sakila.ws.data.Genre;
import org.sakila.ws.mapper.GenreMapper;

public class GenreService extends AbstractBaseService<Genre,GenreMapper> implements MapperInitializer {
	
	protected static Logger logger = Logger.getLogger(GenreService.class);
	
	private GenreMapper mapper;
	
	@Override
	public void initialize() {
		super.logMapperStatus("GenreMapper", "GenreService", mapper);
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
	public Response select(Genre genre) {
		return super.select(genre);
		
	}
	
	@Override
	public Response insert(Genre genre) {

		if(genre == null) {
			throw new IllegalArgumentException("genre is null");
		}
		
		try {
			genre.setId(UUID.randomUUID().toString());
			super.insert(genre); 
			
			return super.selectById(genre.getId());
		} 
		catch(Exception e) {
			return super.getServerErrorResponse(e.getStackTrace().toString());
		}
		
	}
	
	@Override
	public Response delete(Genre genre) {
		
		if(genre == null) {
			throw new IllegalArgumentException("genre is null");
		}
		
		return super.delete(genre);
		
	}
	
	@Override
	public Response update(Genre genre) {
		
		if(genre == null) {
			throw new IllegalArgumentException("genre is null");
		}
		
		if(genre.getName() == null){
			return super.getNullParameterResponse();
		}
		
		super.update(genre);
		
		return super.selectById(genre.getId());
		
	}

	public GenreMapper getMapper() {
		return mapper;
	}

	public void setMapper(GenreMapper mapper) {
		this.mapper = mapper;
	}
}
