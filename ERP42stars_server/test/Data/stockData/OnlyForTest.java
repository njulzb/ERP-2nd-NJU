package Data.stockData;

public class OnlyForTest {
	
	public static void main(String[] args) {
		java.util.Date javadate = new java.util.Date();
		System.out.println(javadate.toString());
		
		java.sql.Date sqldate = new java.sql.Date(javadate.getTime());
		System.out.println(sqldate.toString());
		
		System.out.println(OnlyForTest.class.getName());
	}
}