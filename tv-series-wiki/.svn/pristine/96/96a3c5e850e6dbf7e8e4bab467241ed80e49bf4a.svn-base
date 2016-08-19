package org.sakila.ws.mapper;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sakila.ws.data.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;



@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations="test-mapper-configuration.xml")
public class RatingMapperTests extends AbstractTransactionalJUnit4SpringContextTests{

	
	@Autowired
	private RatingMapper ratingMapper;
	
	@Test
	@Transactional
	public void SelectRatingByNameTest(){
		
		Rating rating = ratingMapper.selectByName("Excellent");
		
		assertNotNull(rating);
		assertNotNull(rating.getId());
		assertNotNull(rating.getName());
	}
	
	@Test
	@Transactional
	public void SelectRatingByIdTest() {
		
		Rating rating = ratingMapper.selectById("2f3ea59b-859b-45a2-bccd-0e40ddd912f9");
		
		assertNotNull(rating);
		assertNotNull(rating.getId());
		assertNotNull(rating.getName());
	}
		
	@Test
	@Transactional
	public void InsertTest() {
		
		Rating rating = new Rating();
		rating.setName("New Rating Name");
		
		ratingMapper.insert(rating);
		
		Rating returnedRating = ratingMapper.selectByName("New Rating Name");
		assertNotNull(returnedRating);
		assertNotNull(returnedRating.getId());
		assertNotNull(returnedRating.getName());
	}
	
	@Test
	@Transactional
	public void DeleteTest() {
		
		String name = "Excellent";
		Rating rating = ratingMapper.selectByName(name);
		
		ratingMapper.delete(rating);
		
		Rating returnedRating = ratingMapper.selectByName(name);
		assertTrue(returnedRating == null);
	
	}
	
	@Test
	@Transactional
	public void UpdateTest() {
		
		Rating rating = ratingMapper.selectByName("Excellent");
		rating.setName("New Name");
		
		ratingMapper.update(rating);
		
		Rating returnedRating = ratingMapper.selectByName("New Name");
		assertNotNull(returnedRating);
		assertNotNull(returnedRating.getId());
		assertNotNull(returnedRating.getName());
	}
}
