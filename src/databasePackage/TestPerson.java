package databasePackage;

public class TestPerson {

	/**
	 * This class is here to test the database connection, and nothing else
	 */
	public static void main(String[] args) {
		

		// try to write Ulrich to the database
		String ulrichName = "Ulrich";
		int[] ulrichAnswers = {1, 2, 3, 1, 2, 3, 1, 2, 3};
		int ulrichScore = 18;
		
		new Person().savePersonScore(ulrichName, ulrichAnswers, ulrichScore);
//		
//		ulrichScore = 25;
//		new Person().savePersonScore(ulrichName, ulrichAnswers, ulrichScore);
//		
//		ulrichScore = 26;
//		new Person().savePersonScore(ulrichName, ulrichAnswers, ulrichScore);
		
		System.out.println(new Person().getAverage());
		System.exit(0);
		
				
		// new Person().savePersonScore("manu", 1, 2, 3, 3, 3, 3, 3, 1, 3, 25);
		
		
		
		

	}

}
