package org.sakila.ws.mapper;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sakila.ws.data.Tag;
import org.sakila.ws.mapper.TagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;



@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations="test-mapper-configuration.xml")
public class TagMapperTests extends AbstractTransactionalJUnit4SpringContextTests{

	
	@Autowired
	private TagMapper tagMapper;
	
	@Test
	@Transactional
	public void SelectTagByNameTest(){
		
		Tag tag = tagMapper.selectByName("Nirrti");
		
		assertNotNull(tag);
		assertNotNull(tag.getId());
		assertNotNull(tag.getName());
		assertNotNull(tag.getSeriesId());
		assertNotNull(tag.getSeriesName());
	}
	
	@Test
	@Transactional
	public void SelectTagByIdTest() {
		
		Tag tag = tagMapper.selectById("02b38b92-148a-4a12-92fd-bd5d98a4484c");
		
		assertNotNull(tag);
		assertNotNull(tag.getId());
		assertNotNull(tag.getName());
		assertNotNull(tag.getSeriesId());
		assertNotNull(tag.getSeriesName());
	}
	
	@Test
	@Transactional
	public void SelectTagBySeriesNameTest() {
		
		Tag tag = new Tag();
		tag.setSeriesName("Stargate SG-1");
		
		List<Tag> tags = tagMapper.select(tag);
		
		assertNotNull(tags);
		assertTrue(tags.size() > 0);
	}
	
	@Test
	@Transactional
	public void SelectTagBySeriesIdTest() {
		
		Tag tag = new Tag();
		tag.setSeriesId("b7587dfe-8d58-498c-b4273f84ef9c5889");
		
		List<Tag> tags = tagMapper.select(tag);
		
		assertNotNull(tags);
		assertTrue(tags.size() > 0);
	}
	
	@Test
	@Transactional
	public void InsertTest() {
		
		Tag tag = new Tag();
		tag.setName("New Tag Name");
		tag.setSeriesId("b7587dfe-8d58-498c-b4273f84ef9c5889");
		tag.setSeriesName("Stargate SG-1");
		
		tagMapper.insert(tag);
		
		Tag returnedTag = tagMapper.selectByName("New Tag Name");
		assertNotNull(returnedTag);
		assertNotNull(returnedTag.getId());
		assertNotNull(returnedTag.getName());
		assertNotNull(returnedTag.getSeriesId());
		assertNotNull(returnedTag.getSeriesName());
	}
	
	@Test
	@Transactional
	public void DeleteTest() {
		
		String name = "Nirrti";
		Tag tag = tagMapper.selectByName(name);
		
		tagMapper.delete(tag);
		
		Tag returnedTag = tagMapper.selectByName(name);
		assertTrue(returnedTag == null);
	
	}
	
	@Test
	@Transactional
	public void UpdateTest() {
		
		String tagName = "Nirrti";
		Tag tag = tagMapper.selectByName(tagName);
		tag.setName("New Name");
		
		tagMapper.update(tag);
		
		Tag returnedTag = tagMapper.selectByName("New Name");
		assertNotNull(returnedTag);
		assertNotNull(returnedTag.getId());
		assertNotNull(returnedTag.getName());
		assertNotNull(returnedTag.getSeriesId());
		assertNotNull(returnedTag.getSeriesName());
	}
}
