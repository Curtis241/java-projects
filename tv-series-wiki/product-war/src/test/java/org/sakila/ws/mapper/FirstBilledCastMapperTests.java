package org.sakila.ws.mapper;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sakila.ws.data.Actor;
import org.sakila.ws.data.FirstBilledCast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations="test-mapper-configuration.xml")
public class FirstBilledCastMapperTests {

	@Autowired
	private FirstBilledCastMapper firstBilledCastMapper;
	
	@Autowired
	private ActorMapper actorMapper;
	
	@Test
	@Transactional
	public void SelectFirstBilledCastByNameTest(){
		
		FirstBilledCast firstBilledCast = new FirstBilledCast();
		firstBilledCast.setName("Stargate SG-1 Season 6");
		
		List<FirstBilledCast> firstBilledCastList = firstBilledCastMapper.select(firstBilledCast);
		
		assertNotNull(firstBilledCastList);
		assertTrue(firstBilledCastList.size() > 0);
		FirstBilledCast returnedFirstBilledCast = firstBilledCastList.get(0);
		
		assertNotNull(returnedFirstBilledCast.getId());
		assertNotNull(returnedFirstBilledCast.getName());
		assertNotNull(returnedFirstBilledCast.getActorName());
		assertNotNull(returnedFirstBilledCast.getCharacterName());
		assertNotNull(returnedFirstBilledCast.getSeriesName());
		
	}
	
	@Test
	@Transactional
	public void SelectFirstBilledCastByIdTest(){
		
		FirstBilledCast firstBilledCast = firstBilledCastMapper.selectById("02897322-2098-4572-b2b0-6d5fe87c8e2b");
		
		assertNotNull(firstBilledCast);
		assertNotNull(firstBilledCast.getId());
		assertNotNull(firstBilledCast.getName());
		assertNotNull(firstBilledCast.getActorName());
		assertNotNull(firstBilledCast.getCharacterName());
		assertNotNull(firstBilledCast.getSeriesName());
	}
	
	@Test
	@Transactional
	public void SelectFirstBilledCastBySeriesNameTest() {
		
		FirstBilledCast firstBilledCast = new FirstBilledCast();
		firstBilledCast.setSeriesName("Stargate SG-1");
		
		List<FirstBilledCast> returnedFirstBilledCastList = firstBilledCastMapper.select(firstBilledCast);
		
		assertNotNull(returnedFirstBilledCastList);
		assertTrue(returnedFirstBilledCastList.size() > 0);
		
	}
	
	@Test
	@Transactional
	public void SelectFirstBilledCastByCharacterNameTest() {
		
		FirstBilledCast firstBilledCast = new FirstBilledCast();
		firstBilledCast.setCharacterName("Captain Samantha Carter");
		
		List<FirstBilledCast> returnedFirstBilledCastList = firstBilledCastMapper.select(firstBilledCast);
		
		assertNotNull(returnedFirstBilledCastList);
		assertTrue(returnedFirstBilledCastList.size() > 0);
	}
	
	@Test
	@Transactional
	public void SelectFirstBilledCastByActorNameTest() {
	
		FirstBilledCast firstBilledCast = new FirstBilledCast();
		firstBilledCast.setActorName("Amanda Tapping");
		
		List<FirstBilledCast> returnedFirstBilledCastList = firstBilledCastMapper.select(firstBilledCast);
		
		assertNotNull(returnedFirstBilledCastList);
		assertTrue(returnedFirstBilledCastList.size() > 0);
		
	}
	
	@Test
	@Transactional
	public void InsertTest() {
		
		String name = "New FirstBilledCast Name";
		FirstBilledCast firstBilledCast = new FirstBilledCast();
		
		Actor actor = actorMapper.selectByName("Amanda Tapping");
		
		firstBilledCast.setActorId(actor.getId());
		firstBilledCast.setName(name);
		
		firstBilledCastMapper.insert(firstBilledCast);
		
		FirstBilledCast returnedFirstBilledCast = firstBilledCastMapper.selectByName(name);
		assertNotNull(returnedFirstBilledCast);
		assertNotNull(returnedFirstBilledCast.getId());
		assertNotNull(returnedFirstBilledCast.getName());
		assertNotNull(returnedFirstBilledCast.getActorName());
		assertNotNull(returnedFirstBilledCast.getCharacterName());
		assertNotNull(returnedFirstBilledCast.getSeriesName());
		
	}
	
	@Test
	@Transactional
	public void DeleteTest() {
		
		String name = "Stargate SG-1 Season 6";
		FirstBilledCast firstBilledCast = new FirstBilledCast();
		firstBilledCast.setActorId(UUID.randomUUID().toString());
		firstBilledCast.setName(name);
			
		firstBilledCastMapper.delete(firstBilledCast);
		
		List<FirstBilledCast> returnedFirstBilledCastList = firstBilledCastMapper.select(firstBilledCast);
		assertTrue(returnedFirstBilledCastList.size() == 0);
	}
}
