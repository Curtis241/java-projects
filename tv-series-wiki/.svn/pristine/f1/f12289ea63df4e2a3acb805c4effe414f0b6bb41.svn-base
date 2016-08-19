package org.sakila.ws.service;

import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.sakila.ws.data.SearchResult;
import org.sakila.ws.mapper.SearchResultMapper;

public class SearchResultService extends AbstractBaseService<SearchResult,SearchResultMapper> implements MapperInitializer{

	protected static Logger logger = Logger.getLogger(SearchResultService.class);
	
	private SearchResultMapper mapper;
	
	@Override
	public void initialize() {
		super.logMapperStatus("SearchResultMapper", "SearchResultService", mapper);
		super.setMapper(mapper);
	}
	
	public Response selectByEpisodeName(String name) {
		
		if(name == null) {
			throw new IllegalArgumentException("name is null");
		}
		
		return getResponse(mapper.getResultsByEpisodeName(name));
	}
	
	public Response selectByEpisodeNumber(int number) {
		return getResponse(mapper.getResultsByEpisodeNumber(number));
	}
	
	public Response selectBySeriesName(String name) {
		
		if(name == null) {
			throw new IllegalArgumentException("name is null");
		}
		
		return getResponse(mapper.getResultsBySeriesName(name));
	}
	
	public Response selectByGenreName(String name) {
		
		if(name == null) {
			throw new IllegalArgumentException("name is null");
		}
		
		return getResponse(mapper.getResultsByGenreName(name));
	}
	
	public Response selectByRatingName(String name) {
		
		if(name == null) {
			throw new IllegalArgumentException("name is null");
		}
		
		return getResponse(mapper.getResultsByRatingName(name));
	}
	
	public SearchResultMapper getMapper() {
		return mapper;
	}

	public void setMapper(SearchResultMapper mapper) {
		this.mapper = mapper;
	};

}
