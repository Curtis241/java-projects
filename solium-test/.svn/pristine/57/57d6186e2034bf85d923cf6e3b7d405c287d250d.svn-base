package org.corp.presenter.validator;

import org.apache.commons.validator.routines.FloatValidator;

public class GrantPriceValidator implements Strategy {

	@Override
	public boolean validate(String entity) {
		return new FloatValidator().isValid(entity);
	}

}
