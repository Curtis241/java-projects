package org.sakila.ws.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sakila.ws.data.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"test-service-configuration.xml"})
public class ConfigurationServiceTests {

	@Autowired
	private ConfigurationService configurationService;
		
	@Test
	public void getPropertiesTest() {
		List<Property> properties = configurationService.getProperties();
		
		String url = properties.get(0).getValue();
		
		assertNotNull(url);
	}

	public void setConfigurationService(ConfigurationService configurationService) {
		this.configurationService = configurationService;
	}
}
