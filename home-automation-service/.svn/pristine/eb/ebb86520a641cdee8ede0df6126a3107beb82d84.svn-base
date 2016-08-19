package org.sakila.util;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"test-util-configuration.xml"})
public class PropertyConfigurationTests {

	
	@Autowired
	private PropertyConfiguration propertyConfiguration;
	
	@Autowired
	private Environment env;
	
	@Before
	public void Setup() {
		propertyConfiguration.intialize();
	}
	
	@Test
	public void getPropertyTest() { 
		
		String url = env.getProperty("weather.service.url");
		
		assertNotNull(url);
	}

	/**
	 * @param propertyConfiguration the propertyConfiguration to set
	 */
	public void setPropertyConfiguration(final PropertyConfiguration propertyConfiguration) {
		this.propertyConfiguration = propertyConfiguration;
	}
	
	
	
}
