package org.sakila.ws.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sakila.ws.data.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations="test-mapper-configuration.xml")
public class SearchResultMapperTests extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private SearchResultMapper searchResultMapper;
	
	@Test
	@Transactional
	public void SelectSearchResultByEpisodeName() {
		
		List<SearchResult> searchResults = searchResultMapper.getResultsByEpisodeName("Children Of The Gods");
		
		assertNotNull(searchResults);
		assertTrue(searchResults.size() == 1);
	}
	
	@Test
	@Transactional
	public void SelectSearchResultByEpisodeNumber() {
		
		List<SearchResult> searchResults = searchResultMapper.getResultsByEpisodeNumber(520);
		
		assertNotNull(searchResults);
		assertTrue(searchResults.size() == 1);
	}
	
	@Test
	@Transactional
	public void SelectSearchResultBySeriesName() {
		
		List<SearchResult> searchResults = searchResultMapper.getResultsBySeriesName("Stargate SG-1");
		
		assertNotNull(searchResults);
		assertTrue(searchResults.size() > 1);
	}
	
	@Test
	@Transactional
	public void SelectSearchResultByGenreName() {
		
		List<SearchResult> searchResults = searchResultMapper.getResultsByGenreName("Action");
		
		assertNotNull(searchResults);
		assertTrue(searchResults.size() > 1);
	}
	
	@Test
	@Transactional
	public void SelectSearchResultByRatingName() {
		
		List<SearchResult> searchResults = searchResultMapper.getResultsByRatingName("Good");
		
		assertNotNull(searchResults);
		assertTrue(searchResults.size() > 1);
	}
	
}
