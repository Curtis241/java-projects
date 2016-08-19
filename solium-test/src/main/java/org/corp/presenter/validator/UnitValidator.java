package org.corp.presenter.validator;

import org.apache.commons.validator.routines.IntegerValidator;

public class UnitValidator implements Strategy {

	@Override
	public boolean validate(String entity) {
		return new IntegerValidator().isValid(entity);
	}

}
