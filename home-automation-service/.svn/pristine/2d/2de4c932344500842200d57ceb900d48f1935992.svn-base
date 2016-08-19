package org.sakila.util;
import java.util.List;

import javax.annotation.PostConstruct;

import org.sakila.ws.data.Property;
import org.sakila.ws.data.mapper.ConfigurationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.StandardEnvironment;

@Configuration
public class PropertyConfiguration {

	
	@Autowired(required = true)
	private ConfigurationMapper configurationMapper;
	
	@PostConstruct
	public void intialize() {
		ConfigurableEnvironment environment = new StandardEnvironment();
		//MutablePropertySources propertySources = environment.getPropertySources();
		   
		List<Property> properties = configurationMapper.getProperties();
		
		try {
			for(Property property : properties) {
				//Map<String, Object> map = new HashMap<String, Object>();
				//map.put(property.getKey(), property.getValue());
				//propertySources.addLast(new MapPropertySource("systemProperties", map));
				environment.getSystemProperties().put(property.getKey(), property.getValue());
			}
			
			/*Set<String> keys = environment.getSystemProperties().keySet();
			
			for(String key: keys) { 
				System.out.print("System Property Keys: " + key);
			}*/
		
		}
		catch (Exception ex)
		{
			System.out.print(ex.getMessage());
		}
		
	}
	
	public ConfigurationMapper getConfigurationMapper() {
		return configurationMapper;
	}

	/**
	 * @param configurationMapper the configurationMapper to set
	 */
	public void setConfigurationMapper(ConfigurationMapper configurationMapper) {
		this.configurationMapper = configurationMapper;
	}
}
