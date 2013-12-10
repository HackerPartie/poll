package databasePackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author manu
 * 
 */

public class Person {

	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	// count the number of saved persons,
	//  ie count number of row in the person TABLE
	private int numRows;
	private int[] allScores;
	double sumAllScores;
	
	/*
	 * put the stuff in the database aka INSERT INTO person VALUES (default,
	 * 'lars', 1 , 2, 3, 1, 2, 3, 1, 2, 3, 18);
	 */
	public void savePersonScore(String personName, int[] personAnswers,
			int personSum) {

		try {
			// load the jdbc driver
			Class.forName("com.mysql.jdbc.Driver");

			// establish a TCP/IP connection with mysql
			connect = DriverManager.getConnection(
					"jdbc:mysql://localhost/poll", "polluser", "pollpassword");

			// create a preparedStatement object, which is going to hold our SQL
			// statement
			preparedStatement = connect
					.prepareStatement("INSERT INTO person VALUES(default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

			// fill the SQL query with the paramaters we want to save,
			// starting with the personName in the first ? placeholder from
			// above
			preparedStatement.setString(1, personName);

			// this would boring
			// preparedStatement.setInt(2, personAnswers[0]);
			// preparedStatement.setInt(3, personAnswers[1]);
			// so we do it a loop
			for (int i = 0; i < personAnswers.length; i++) {
				preparedStatement.setInt(i + 2, personAnswers[i]);
			}

			// add the score as the last parameter
			preparedStatement.setInt(11, personSum);

			// execute the SQL statement
			preparedStatement.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}
	
	// get the average of all saved scores
	public double getAverage() {
		try {
			
			// load the jdbc driver
			Class.forName("com.mysql.jdbc.Driver");

			// establish a TCP/IP connection with mysql
			connect = DriverManager.getConnection(
					"jdbc:mysql://localhost/poll", "polluser", "pollpassword");

			// create a preparedStatement object, which is going to hold our SQL statement			
			// count the number of saved persons,
			//  ie count number of row in the person TABLE
			preparedStatement = connect
					.prepareStatement("SELECT COUNT(*) FROM person");
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				numRows = resultSet.getInt("count(*)");
			}
			
			// now we get to retrieve the score of all persons in the table
			// to save the scores we initialize an int array of the size of the table person itself
			allScores = new int[numRows];
			preparedStatement = connect.prepareStatement("SELECT qsum FROM person;");
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				allScores[resultSet.getRow()-1] = resultSet.getInt("qsum");	
			}
			
			// print the content of our array
			for (int i = 0; i < allScores.length; i++) {
				sumAllScores += allScores[i];
			}
						
			return sumAllScores / allScores.length;
									
			
		} catch (Exception e) {
			System.out.println(e.toString());
			return -1;
		}
	}
	
	/*
	 *  a debug method, available only the inside package scope 
	 */
	 void displayAll() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(
					"jdbc:mysql://localhost/poll", "polluser", "pollpassword");
			statement = connect.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM person");
			writeResultSet(resultSet);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	private void writeResultSet(ResultSet resultSet) throws SQLException {
		while (resultSet.next()) {
			String name = resultSet.getString("NAME");
			String qsum = resultSet.getString("qsum");
			System.out.println("Person Name: " + name);
			System.out.println("Person Score: " + qsum);

		}
	}

}