package org.sakila.ws.service;

import static org.junit.Assert.*;

import javax.ws.rs.core.Response;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sakila.ws.data.FirstBilledCast;
import org.sakila.ws.mapper.FirstBilledCastMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations="test-service-configuration.xml")
public class FirstBilledCastServiceTests {

	@Autowired
	private FirstBilledCastService service;
	
	@Autowired
	private FirstBilledCastMapper mapper;
	
	@Test
	public void updateTest() {
		
		FirstBilledCast firstBilledCast = new FirstBilledCast();
		firstBilledCast.setName("Stargate SG-1 Season 6");
		
		
		Response response = service.update(firstBilledCast,"New Name");
		
		assertTrue(response.getStatus() == 200);
	}

}
