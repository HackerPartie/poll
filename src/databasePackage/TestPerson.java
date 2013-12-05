package databasePackage;

public class TestPerson {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Person manu = new Person();
		
		System.out.println(manu.getAverage());
		manu.savePersonScore("manu", 1, 2, 3, 3, 3, 3, 3, 1, 3, 25);
		
		
		

	}

}
