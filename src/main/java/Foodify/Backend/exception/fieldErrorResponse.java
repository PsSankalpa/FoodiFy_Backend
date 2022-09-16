//---------------for field validation error response--------

package Foodify.Backend.exception;

import java.util.List;

public class fieldErrorResponse {
	public List<customFieldError> fieldErrors;

	public fieldErrorResponse() {
	}

	public List<customFieldError> getFieldErrors() {
		return fieldErrors;
	}

	public void setFieldErrors(List<customFieldError> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}
}
