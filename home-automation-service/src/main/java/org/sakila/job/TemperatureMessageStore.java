package org.sakila.job;

import java.util.HashSet;
import org.sakila.ws.data.Temperature;
import org.springframework.stereotype.Component;

@Component
public class TemperatureMessageStore {

	private HashSet<Temperature> set = new HashSet<Temperature>();
	
	public TemperatureMessageStore()
	{
		
	}
		
	public void setMessage(Temperature temp ){
		
		if(set.size() > 0)
		{
			temp.setId(set.size() + 1);	
		}
		else
		{
			temp.setId(1);
		}

		set.add(temp);
	}
	
	public HashSet<Temperature> getHashSet() 
	{
		return set;
	}
	
	public void clear(){
		set.clear();
	}
}
