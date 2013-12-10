package databasePackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Person {
	
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement =null;
	private ResultSet resultSet = null;
	
	public void connectDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.
					getConnection("jdbc:mysql://localhost/poll", "polluser", "pollpassword");
			// Statements allow to issueSQL queries to the Database
			statement = connect.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM person");
			writeResultSet(resultSet);
		} 
		catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}
	
	public void writeResultSet(ResultSet resultSet) throws SQLException {
		while (resultSet.next()) {
			String name = resultSet.getString("NAME");
			String qsum = resultSet.getString("qsum");
			System.out.println("Person Name: " + name);
			System.out.println("Person Score: " + qsum);
			
			
		}
	}

	public void savePersonScore(
			String personName,
			int[] personAnswers,
			int personSum) {
		// put the stuff in the database
		// aka INSERT INTO person VALUES (default, 'lars', 1 , 2, 3, 1, 2, 3, 1, 2, 3, 1, 18);
		String queryString = "INSERT INTO person VALUES (default, personName, q1, q2, q3, q4, q5, q6, q7, q8, q9, Sum)";
	}
	
	public double getAverage(){
		return 25.0;
	}
	
}