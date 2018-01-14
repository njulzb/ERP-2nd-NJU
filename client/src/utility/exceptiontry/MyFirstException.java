package utility.exceptiontry;

public class MyFirstException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public MyFirstException(String message) {
		super(message);
	}
	
	
	public static void main(String[] args) {
		try {
			throw new MyFirstException("this is my first exception");
		} catch (MyFirstException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
