package org.sakila.ws.service;

import java.util.UUID;

import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.sakila.ws.data.Tag;
import org.sakila.ws.data.Series;
import org.sakila.ws.mapper.TagMapper;
import org.sakila.ws.mapper.SeriesMapper;

public class TagService extends AbstractBaseService<Tag,TagMapper> implements MapperInitializer {

	protected static Logger logger = Logger.getLogger(TagService.class);
	
	private TagMapper mapper;
	private SeriesMapper seriesMapper;
	
	@Override
	public void initialize() {
		super.logMapperStatus("TagMapper", "TagService", mapper);
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
	public Response select(Tag tag) {
		return super.select(tag);
	};
	
	@Override
	public Response insert(Tag tag) {
			
		if(tag == null) {
			throw new IllegalArgumentException("tag is null");
		}
		
		try {
			tag.setId(UUID.randomUUID().toString());
			Series series = seriesMapper.selectByName(tag.getSeriesName());
			tag.setSeriesId(series.getId());
			
			super.insert(tag);
			
			return super.selectById(tag.getId());
		} 
		catch(Exception e) {
			return super.getServerErrorResponse(e.getStackTrace().toString());
		}
	};
	
	@Override
	public Response delete(Tag tag) {
		
		if(tag == null) {
			throw new IllegalArgumentException("tag is null");
		}
		
		return super.delete(tag); 
	};
	
	@Override
	public Response update(Tag tag) {
		
		if(tag == null) {
			throw new IllegalArgumentException("tag is null");
		}
		
		super.update(tag);
		return super.selectById(tag.getId());
	}

	public TagMapper getMapper() {
		return mapper;
	}

	public void setMapper(TagMapper mapper) {
		this.mapper = mapper;
	};
	
	public SeriesMapper getSeriesMapper() {
		return seriesMapper;
	}

	public void setSeriesMapper(SeriesMapper seriesMapper) {
		this.seriesMapper = seriesMapper;
	};
}
