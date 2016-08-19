package org.sakila.ws.data.mapper;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sakila.ws.data.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = {"test-mapper-configuration.xml"})
public class ConfigurationMapperTests {

protected static Logger logger = Logger.getLogger(ConfigurationMapperTests.class);
	
	@Autowired
	private ConfigurationMapper configurationMapper;
	
	@Test
	@Transactional
	public void GetPropertiesTest(){
	
		List<Property> properties = configurationMapper.getProperties();
		
		assertNotNull(properties);
		assertNotNull(properties.get(0));
		
		
	}
}
