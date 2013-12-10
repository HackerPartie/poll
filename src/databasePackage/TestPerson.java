package databasePackage;

public class TestPerson {

	/**
	 * This class is here to test the database connection, and nothing else
	 */
	public static void main(String[] args) {
		
		System.out.println(new Person().getAverage());
		new Person().connectDB();
				
		// new Person().savePersonScore("manu", 1, 2, 3, 3, 3, 3, 3, 1, 3, 25);
		
		
		
		

	}

}
