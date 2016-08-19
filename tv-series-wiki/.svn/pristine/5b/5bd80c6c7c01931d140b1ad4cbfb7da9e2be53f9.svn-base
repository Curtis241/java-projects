package org.sakila.ws.mapper;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sakila.ws.data.Series;
import org.sakila.ws.mapper.SeriesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations="test-mapper-configuration.xml")
public class SeriesMapperTests extends AbstractTransactionalJUnit4SpringContextTests{

	@Autowired
	private SeriesMapper seriesMapper;
	
	@Test
	@Transactional
	public void SelectSeriesByNameTest() {
		
		Series series = seriesMapper.selectByName("Stargate SG-1");
		
		assertNotNull(series);
		assertNotNull(series.getId());
		assertNotNull(series.getSeasonCount());
		assertNotNull(series.getStartDate());
		assertNotNull(series.getEndDate());
		
	}
	
	@Test
	@Transactional
	public void SelectSeriesByIdTest() {
		
		Series series = seriesMapper.selectById("b7587dfe-8d58-498c-b4273f84ef9c5889");
		
		assertNotNull(series);
		assertNotNull(series.getId());
		assertNotNull(series.getSeasonCount());
		assertNotNull(series.getStartDate());
		assertNotNull(series.getEndDate());
	}
	
	@Test
	@Transactional
	public void InsertTest() {
		
		Series series = getMockSeriesObject();
		seriesMapper.insert(series);
		
		Series returnedSeries = seriesMapper.selectByName("New Series Name");
		assertNotNull(returnedSeries);
		assertNotNull(returnedSeries.getId());
		assertNotNull(returnedSeries.getName());
		assertNotNull(returnedSeries.getSeasonCount());
		assertNotNull(returnedSeries.getStartDate());
		assertNotNull(returnedSeries.getEndDate());
		
	}

	private Series getMockSeriesObject() {
		Series series = new Series();
		series.setId("0057813a-a6a8-4cdb-beca-3b2ea48533d4");
		series.setName("New Series Name");
		series.setSeasonCount(1);
		series.setStartDate(DateTime.now().toDate());
		series.setEndDate(DateTime.now().toDate());
		return series;
	}
	
	@Test
	@Transactional
	public void DeleteTest() {
		
		Series series = getMockSeriesObject();
		seriesMapper.delete(series);
		
		Series returnedSeries = seriesMapper.selectByName(series.getName());
		assertTrue(returnedSeries == null);
	
	}
	
	@Test
	@Transactional
	public void UpdateTest() {
		
		String seriesName = "Stargate SG-1";
		Series series = seriesMapper.selectByName(seriesName);
		series.setName("New Name");
		
		seriesMapper.update(series);
		
		Series returnedSeries = seriesMapper.selectByName("New Name");
		assertNotNull(returnedSeries);
		assertNotNull(returnedSeries.getId());
		assertNotNull(returnedSeries.getName());
		assertNotNull(returnedSeries.getSeasonCount());
		assertNotNull(returnedSeries.getStartDate());
		assertNotNull(returnedSeries.getEndDate());
	}
}
