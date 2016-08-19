package org.sakila.ws.service;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.sakila.ws.data.CurrentObservationImpl;
import org.sakila.ws.data.WeatherImpl;
import org.sakila.ws.data.mapper.WeatherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class WeatherService {

	protected static Logger logger = Logger.getLogger(WeatherService.class);

	@Autowired
	private WeatherMapper weatherMapper;
	
		
	@Autowired
	private Environment env;
	
	
	public WeatherImpl getWeather() {
		String url = env.getProperty("weather.service.url");
		return getWeather(url);
	}
	
	public WeatherImpl deserializeJsonResponse(String response) {
		
		WeatherImpl weatherObject = new WeatherImpl();
		
		if(response.isEmpty()) {
			throw new IllegalArgumentException("String response cannot be empty");
		}
		
		try {
			
			ObjectMapper mapper = new ObjectMapper();
			weatherObject = mapper.readValue(response, WeatherImpl.class);
			
		} catch (JsonParseException e) {
			logger.error(e.getMessage(),e);
			
		} catch (JsonMappingException e) {
			logger.error(e.getMessage(),e);
			
		} catch (IOException e) {
			logger.error(e.getMessage(),e);
			
		}
		
		return weatherObject;
	}
	
	
	public WeatherImpl getWeather(String url){
		
		WeatherImpl weatherObject = null;
		
		if(url.isEmpty()) {
			throw new IllegalArgumentException("String url cannot be empty");
		}
		
		String response;
		try {
			response = getWeatherHttpResponse(url);
			weatherObject = deserializeJsonResponse(response);
		} catch (IOException e) {
			logger.error(e);
		}

		return weatherObject;
		
	}
	
	public String getWeatherHttpResponse(String url) throws IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String responseBody = null;
		try {
			HttpGet httpget = new HttpGet(url);
	
			logger.debug("Executing request " + httpget.getRequestLine());
			
			 ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
			
					@Override
					public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
		
						int status = response.getStatusLine().getStatusCode();
		                if (status >= 200 && status < 300) {
		                    HttpEntity entity = response.getEntity();
		                    return entity != null ? EntityUtils.toString(entity) : null;
		                } else {
		                	String errorMessage = "Unexpected response status: " + status;
		                	logger.error(errorMessage);
		                    throw new ClientProtocolException(errorMessage);
		                }
					}
			
			 };
			 
			 responseBody = httpclient.execute(httpget, responseHandler);
	         logger.debug(responseBody);
	            
	     } finally {
	         httpclient.close();
	     }
		     
		return responseBody;
	}

	public void saveWeather(CurrentObservationImpl CurrentObservation){
		
		if(CurrentObservation != null){
			weatherMapper.insertWeather(CurrentObservation);	
		}
	}
	
	public void setWeatherMapper(final WeatherMapper weatherMapper){
		this.weatherMapper = weatherMapper;
	}

	
	
	
	
	
}
