package org.corp.presenter.validator;

import org.apache.commons.validator.routines.DateValidator;


public class VestDateValidator implements Strategy {

	@Override
	public boolean validate(String entity) {
		return new DateValidator().isValid(entity,"yyyymmdd");
	}

}
