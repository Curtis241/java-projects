package org.sakila.ws.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FeaturesImpl implements Features {

	@JsonProperty("conditions")
	private int conditions;
	
	@Override
	public int getConditions() {
		return conditions;
	}

	@Override
	public void setConditions(int conditions) {
		this.conditions = conditions;
	}

}
