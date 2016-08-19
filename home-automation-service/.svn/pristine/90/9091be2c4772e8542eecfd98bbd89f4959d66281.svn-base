package org.sakila.ws.service;

import java.util.List;

import org.sakila.ws.data.Property;
import org.sakila.ws.data.mapper.ConfigurationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConfigurationService {

	@Autowired(required = true)
	private ConfigurationMapper configurationMapper;
	
	
	public List<Property> getProperties() {
		return getConfigurationMapper().getProperties();
	}

	/**
	 * @return the configurationMapper
	 */
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
