package org.corp.presenter.validator;

import org.apache.commons.validator.routines.RegexValidator;

public class TypeValidator implements Strategy {

	@Override
	public boolean validate(String entity) {
		return new RegexValidator(entity).isValid("VEST");
	}

}
