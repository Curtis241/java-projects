package org.sakila.ws.mapper;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sakila.ws.data.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;



@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations="test-mapper-configuration.xml")
public class GenreMapperTests extends AbstractTransactionalJUnit4SpringContextTests{

	
	@Autowired
	private GenreMapper genreMapper;
	
	@Test
	@Transactional
	public void SelectGenreByNameTest(){
		
		Genre genre = genreMapper.selectByName("Medical Mystery");
		
		assertNotNull(genre);
		assertNotNull(genre.getId());
		assertNotNull(genre.getName());
	}
	
	@Test
	@Transactional
	public void SelectGenreByIdTest() {
		
		Genre genre = genreMapper.selectById("229f6c90-fa5e-4de4-841c-c1c6b5b851c3");
		
		assertNotNull(genre);
		assertNotNull(genre.getId());
		assertNotNull(genre.getName());
	}
		
	@Test
	@Transactional
	public void InsertTest() {
		
		Genre genre = new Genre();
		genre.setName("New Genre Name");
		
		genreMapper.insert(genre);
		
		Genre returnedGenre = genreMapper.selectByName("New Genre Name");
		assertNotNull(returnedGenre);
		assertNotNull(returnedGenre.getId());
		assertNotNull(returnedGenre.getName());
	}
	
	@Test
	@Transactional
	public void DeleteTest() {
		
		String name = "Medical Mystery";
		Genre genre = genreMapper.selectByName(name);
		
		genreMapper.delete(genre);
		
		Genre returnedGenre = genreMapper.selectByName(name);
		assertTrue(returnedGenre == null);
	
	}
	
	@Test
	@Transactional
	public void UpdateTest() {
		
		Genre genre = genreMapper.selectByName("Medical Mystery");
		genre.setName("New Name");
		
		genreMapper.update(genre);
		
		Genre returnedGenre = genreMapper.selectByName("New Name");
		assertNotNull(returnedGenre);
		assertNotNull(returnedGenre.getId());
		assertNotNull(returnedGenre.getName());
	}
}
