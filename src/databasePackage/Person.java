package databasePackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * - Verbindungsaufbau zur Datenbank (poll.person) - Speichern des Datensatz in
 * die Datenbank - Ermittlung des Durchschnitts der Punkteanzahlen
 * 
 * @author manu & bergsocke
 * 
 */

public class Person {

	private Connection connect = null;
	private PreparedStatement myPreparedStatement = null;
	private ResultSet myResultSet = null;

	/*
	 * Verbindungsaufbau zur Datenbank
	 * Basiert auf http://www.mkyong.com/java/java-properties-file-examples/
	teil 3
	 */
	public void connectDB() {

		try {
			
			/* Manual method, without property file
		 	 
			 Class.forName("com.mysql.jdbc.Driver");
						 
			 connect =
			 DriverManager.getConnection("jdbc:mysql://localhost/poll",
			 "polluser", "pollpassword");
			 
			 */

			Properties myProperties = new Properties();

			try {
				//load a properties file from class path, inside static method
				myProperties.load(Person.class.getClassLoader()
						.getResourceAsStream("database.properties"));

			} catch (Exception e) {
				System.out.println(e.toString());
			}

			String drivers = myProperties.getProperty("jdbc.driver");
			String connectionURL = myProperties.getProperty("jdbc.url");
			String username = myProperties.getProperty("jdbc.username");
			String password = myProperties.getProperty("jdbc.password");

			Class.forName(drivers);
			connect = DriverManager.getConnection(connectionURL, username,
					password);

		} catch (Exception e) {
			System.err.println(e.toString());
			System.err.println("Unable to connect to your database.");
			System.err.println("Have you supplied the right credentials in the database.properties file ?");
		}

	}

	// Speichert Datensatz in die Datenbank
	public void savePersonScore(String personName, int[] personAnswers,
			int personSum) {

		try {
			// Datenbankverbindung
			this.connectDB();

			// PreparedStatement f�r SQL-Befehl
			myPreparedStatement = connect
					.prepareStatement("INSERT INTO person VALUES(default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

			// Namen setzen
			myPreparedStatement.setString(1, personName);

			// Antworten setzen
			for (int i = 0; i < personAnswers.length; i++) {
				myPreparedStatement.setInt(i + 2, personAnswers[i]);
			}

			// Punkteanzahl setzen
			myPreparedStatement.setInt(11, personSum);

			// Ausfuehren des Speichern
			myPreparedStatement.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.toString());
			
		} finally {
			close();
		}

	}

	// Ermittlung des Durchschnitts der Punkteanzahlen
	public double getAverage() {

		double numRows = 0.0; // Anzahl der Datensaetze
		double allScores = 0.0; // Summe der Punkteanzahl
		double average = 0.0; // Durchschnitt

		try {
			// Datenbankverbindung
			this.connectDB();

			// Anzahl der Datensaetze ermitteln
			myPreparedStatement = connect
					.prepareStatement("SELECT COUNT(*) AS count FROM person");
			myResultSet = myPreparedStatement.executeQuery();

			while (myResultSet.next()) {
				numRows = myResultSet.getInt("count");
			}

			// Gesamtsumme der Punkteanzahl ermitteln
			myPreparedStatement = connect
					.prepareStatement("SELECT qsum FROM person");
			myResultSet = myPreparedStatement.executeQuery();

			while (myResultSet.next()) {
				int tempSum = myResultSet.getInt("qsum");
				allScores += tempSum;
			}

			// Durchschnitt errechnen
			average = allScores / numRows;

			// Durchschnitt runden auf 2 Nachkommastellen
			average = Math.round(average * 100.) / 100.;

			return average;

		} catch (Exception e) {
			return 0.0;

		} finally {
			close();
		}
	}

	/*
	 * Eine debug method um alles in der db anzuzeigen
	 */
	void displayAll() {
		try {
			this.connectDB();
			myPreparedStatement = connect
					.prepareStatement("SELECT name, qsum FROM person;");
			myResultSet = myPreparedStatement.executeQuery();

			while (myResultSet.next()) {
				String name = myResultSet.getString("name");
				int qsum = myResultSet.getInt("qsum");
				System.out.println(name + " " + qsum);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	private void close() {
		try {

			if (myResultSet != null) {
				myResultSet.close();
			}

			if (myPreparedStatement != null) {
				myPreparedStatement.close();
			}

			if (connect != null) {
				connect.close();
			}

		} catch (Exception e) {
			System.out.println(e.toString());

		}
	}

}