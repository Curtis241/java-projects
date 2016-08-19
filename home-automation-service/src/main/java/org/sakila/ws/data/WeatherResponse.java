package org.sakila.ws.data;

public interface WeatherResponse {
	public String getVersion();
	public void setVersion(String version);
	
	public String getTermsOfService();
	public void setTermsOfService(String termsOfService);
	
	public FeaturesImpl getFeatures();
	public void setFeatures(FeaturesImpl features);
}
