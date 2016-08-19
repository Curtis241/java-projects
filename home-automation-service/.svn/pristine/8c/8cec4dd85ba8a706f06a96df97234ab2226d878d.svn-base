package org.sakila.ws.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponseImpl implements WeatherResponse
{

	@JsonProperty("version")
	private String version;
	
	@JsonProperty("termsofService")
	private String termsOfService;
	
	@JsonProperty("features")
	private FeaturesImpl features;
	
	@Override
	public String getVersion() {
		return version;
	}

	@Override
	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public String getTermsOfService() {
		return termsOfService;
	}

	@Override
	public void setTermsOfService(String termsOfService) {
		this.termsOfService = termsOfService;
	}

	@Override
	public FeaturesImpl getFeatures() {
		return features;
	}

	@Override
	public void setFeatures(FeaturesImpl features) {
		this.features = features;
	}
	
}