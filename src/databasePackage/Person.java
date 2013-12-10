package databasePackage;

public class Person {

	public void savePersonScore(
			String personName,
			int q1, int q2, int q3,
			int q4, int q5, int q6,
			int q7, int q8, int q9,
			int Sum) {
		// put the stuff in the database
		// aka INSERT INTO person VALUES (default, 'lars', 1 , 2, 3, 1, 2, 3, 1, 2, 3, 1, 18);
		String queryString = "INSERT INTO person VALUES (default, personName, q1, q2, q3, q4, q5, q6, q7, q8, q9, Sum)";
		System.out.println(queryString);
	}
	
	public double getAverage(){
		return 25.0;
	}
	
}