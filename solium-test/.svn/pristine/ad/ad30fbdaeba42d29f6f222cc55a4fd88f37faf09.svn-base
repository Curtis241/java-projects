package org.corp.presenter.validator;

import org.apache.commons.validator.routines.FloatValidator;

public class MarketPriceValidator implements Strategy {

	@Override
	public boolean validate(String entity) {
		return new FloatValidator().isValid(entity);
	}

}
