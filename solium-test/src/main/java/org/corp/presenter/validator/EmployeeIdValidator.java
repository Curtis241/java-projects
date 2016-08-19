package org.corp.presenter.validator;


public class EmployeeIdValidator implements Strategy {

	@Override
	public boolean validate(String entity) {
		return entity.matches("([0-9]{3}[A-Z]{1})");
	}

}
