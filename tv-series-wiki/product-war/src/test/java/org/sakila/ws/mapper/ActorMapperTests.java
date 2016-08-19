package org.sakila.ws.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sakila.ws.data.Actor;
import org.sakila.ws.mapper.ActorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;



@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations="test-mapper-configuration.xml")
public class ActorMapperTests extends AbstractTransactionalJUnit4SpringContextTests{

	
	@Autowired
	private ActorMapper actorMapper;
	
	@Test
	@Transactional
	public void SelectActorByNameTest(){
		
		Actor actor = actorMapper.selectByName("Ian Robison");
		
		assertNotNull(actor);
		assertNotNull(actor.getId());
		assertNotNull(actor.getName());
		assertNotNull(actor.getSeriesId());
		assertNotNull(actor.getSeriesName());
		assertNotNull(actor.getCharacterName());
		
	}
	
	@Test
	@Transactional
	public void SelectActorByIdTest() {
		
		Actor actor = actorMapper.selectById("00e59dba-289a-4607-a775-6f5d489ffb4c");
		
		assertNotNull(actor);
		assertNotNull(actor.getId());
		assertNotNull(actor.getName());
		assertNotNull(actor.getSeriesId());
		assertNotNull(actor.getSeriesName());
		assertNotNull(actor.getCharacterName());
	}
	
	@Test
	@Transactional
	public void SelectActorByCharacterNameTest() {
		
		Actor actor = new Actor();
		actor.setCharacterName("Abydonian Leader");
		
		List<Actor> actors = actorMapper.select(actor);
		
		assertNotNull(actors);
		assertTrue(actors.size() == 1);
		
	}
	
	@Test
	@Transactional
	public void SelectActorBySeriesNameTest() {
		
		Actor actor = new Actor();
		actor.setSeriesName("Stargate SG-1");
		
		List<Actor> actors = actorMapper.select(actor);
		
		assertNotNull(actors);
		assertTrue(actors.size() > 0);
	}
	
	@Test
	@Transactional
	public void SelectActorBySeriesIdTest() {
		
		Actor actor = new Actor();
		actor.setSeriesId("b7587dfe-8d58-498c-b4273f84ef9c5889");
		
		List<Actor> actors = actorMapper.select(actor);
		
		assertNotNull(actors);
		assertTrue(actors.size() > 0);
	}
	
	@Test
	@Transactional
	public void InsertTest() {
		
		Actor actor = new Actor();
		actor.setName("New Actor Name");
		actor.setSeriesId("b7587dfe-8d58-498c-b4273f84ef9c5889");
		actor.setSeriesName("Stargate SG-1");
		actor.setCharacterName("New Character Name");
		
		actorMapper.insert(actor);
		
		Actor returnedActor = actorMapper.selectByName("New Actor Name");
		assertNotNull(returnedActor);
		assertNotNull(returnedActor.getId());
		assertNotNull(returnedActor.getName());
		assertNotNull(returnedActor.getSeriesId());
		assertNotNull(returnedActor.getSeriesName());
		assertNotNull(returnedActor.getCharacterName());
		
	}
	
	@Test
	@Transactional
	public void DeleteTest() {
		
		String name = "Ian Robison";
		Actor actor = actorMapper.selectByName(name);
		
		actorMapper.delete(actor);
		
		Actor returnedActor = actorMapper.selectByName(name);
		assertTrue(returnedActor == null);
	
	}
	
	@Test
	@Transactional
	public void UpdateTest() {
		
		Actor actor = actorMapper.selectByName("Ian Robison");
		actor.setCharacterName("New Character Name");
		actor.setName("New Name");
		
		actorMapper.update(actor);
		
		Actor returnedActor = actorMapper.selectByName("New Name");
		assertNotNull(returnedActor);
		assertNotNull(returnedActor.getId());
		assertNotNull(returnedActor.getName());
		assertNotNull(returnedActor.getSeriesId());
		assertNotNull(returnedActor.getSeriesName());
		assertNotNull(returnedActor.getCharacterName());
	}
}
