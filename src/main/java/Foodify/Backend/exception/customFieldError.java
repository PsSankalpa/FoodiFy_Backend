//-------------error response object----------------

package Foodify.Backend.exception;


public class customFieldError {

	private String field;
	private String message;
	
	public customFieldError() {
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
