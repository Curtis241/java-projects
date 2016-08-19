package org.sakila.ws.mapper;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sakila.ws.data.Director;
import org.sakila.ws.mapper.DirectorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;



@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations="test-mapper-configuration.xml")
public class DirectorMapperTests extends AbstractTransactionalJUnit4SpringContextTests{

	
	@Autowired
	private DirectorMapper directorMapper;
	
	@Test
	@Transactional
	public void SelectDirectorByNameTest(){
		
		Director director = directorMapper.selectByName("Ken Girotti");
		
		assertNotNull(director);
		assertNotNull(director.getId());
		assertNotNull(director.getName());
		assertNotNull(director.getSeriesId());
		assertNotNull(director.getSeriesName());
	}
	
	@Test
	@Transactional
	public void SelectDirectorByIdTest() {
		
		Director director = directorMapper.selectById("11161c6a-fda5-4d1f-aa36-d8719d4a0933");
		
		assertNotNull(director);
		assertNotNull(director.getId());
		assertNotNull(director.getName());
		assertNotNull(director.getSeriesId());
		assertNotNull(director.getSeriesName());
	}
	
	@Test
	@Transactional
	public void SelectDirectorBySeriesNameTest() {
		
		Director director = new Director();
		director.setSeriesName("Stargate SG-1");
		
		List<Director> directors = directorMapper.select(director);
		
		assertNotNull(directors);
		assertTrue(directors.size() > 0);
	}
	
	@Test
	@Transactional
	public void SelectDirectorBySeriesIdTest() {
		
		Director director = new Director();
		director.setSeriesId("b7587dfe-8d58-498c-b4273f84ef9c5889");
		
		List<Director> directors = directorMapper.select(director);
		
		assertNotNull(directors);
		assertTrue(directors.size() > 0);
	}
	
	@Test
	@Transactional
	public void InsertTest() {
		
		Director director = new Director();
		director.setName("New Director Name");
		director.setSeriesId("b7587dfe-8d58-498c-b4273f84ef9c5889");
		director.setSeriesName("Stargate SG-1");
		
		directorMapper.insert(director);
		
		Director returnedDirector = directorMapper.selectByName("New Director Name");
		assertNotNull(returnedDirector);
		assertNotNull(returnedDirector.getId());
		assertNotNull(returnedDirector.getName());
		assertNotNull(returnedDirector.getSeriesId());
		assertNotNull(returnedDirector.getSeriesName());
	}
	
	@Test
	@Transactional
	public void DeleteTest() {
		
		String name = "Ken Girotti";
		Director director = directorMapper.selectByName(name);
		
		directorMapper.delete(director);
		
		Director returnedDirector = directorMapper.selectByName(name);
		assertTrue(returnedDirector == null);
	
	}
	
	@Test
	@Transactional
	public void UpdateTest() {
		
		String directorName = "Ken Girotti";
		Director director = directorMapper.selectByName(directorName);
		director.setName("New Name");
		
		directorMapper.update(director);
		
		Director returnedDirector = directorMapper.selectByName("New Name");
		assertNotNull(returnedDirector);
		assertNotNull(returnedDirector.getId());
		assertNotNull(returnedDirector.getName());
		assertNotNull(returnedDirector.getSeriesId());
		assertNotNull(returnedDirector.getSeriesName());
	}
}
