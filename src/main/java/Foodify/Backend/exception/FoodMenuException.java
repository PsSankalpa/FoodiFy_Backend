package Foodify.Backend.exception;

public class FoodMenuException extends Exception{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    public FoodMenuException(String message) {
		super(message);
	}
    
    public static String FoodMemuAlreadyExists() {
		return "Resturant already have menu";
	}

	public static String FoodMemuCategoryAlreadyExists() {
		return "This Food Category already have exists";
	}

	public static String FoodMemuCategoryItemAlreadyExists() {
		return "This Food already have exists";
	}

	public static String FoodMemuNotFound() {
		return "Menu Name not Found";
	}

}
