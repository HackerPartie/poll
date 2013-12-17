package databasePackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * - Verbindungsaufbau zur Datenbank (poll.person)
 * - Speichern des Datensatz in die Datenbank
 * - Ermittlung des Durchschnitts der Punkteanzahlen
 * 
 * @author manu & bergsocke
 * 
 */

public class Person {
	
	private Connection connect = null;	
	private PreparedStatement myPreparedStatement = null;	
	private ResultSet myResultSet = null;

	//Verbindungsaufbau zur Datenbank
	public void connectDB() {
		
		try {
			//Treiber laden + beim DriverManager registrieren
			Class.forName("com.mysql.jdbc.Driver");

			//DriverManager verwenden + Verbindung zur DB aufbauen
			connect = DriverManager.getConnection("jdbc:mysql://localhost/poll", "polluser", "pollpassword");			

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}
	

	//Speichert Datensatz in die Datenbank
	public void savePersonScore(String personName, int[] personAnswers, int personSum) {
		
		try {
			//Datenbankverbindung
			this.connectDB();
			
			//PreparedStatement f�r SQL-Befehl
			myPreparedStatement = connect.prepareStatement("INSERT INTO person VALUES(default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			//Namen setzen
			myPreparedStatement.setString(1, personName);

			//Antworten setzen
			for (int i = 0; i < personAnswers.length; i++) {
				myPreparedStatement.setInt(i + 2, personAnswers[i]);
			}

			//Punkteanzahl setzen
			myPreparedStatement.setInt(11, personSum);

			//Ausfuehren des Speichern
			myPreparedStatement.executeUpdate();
			

		} catch (Exception e) {
			System.out.println(e.toString());
			
		} finally {
			close();
		}	

	}
	
	// Ermittlung des Durchschnitts der Punkteanzahlen
	public double getAverage() {

		double numRows = 0.0;    //Anzahl der Datensaetze
		double allScores = 0.0;  //Summe der Punkteanzahl
		double average = 0.0;    //Durchschnitt
		
		try {
			//Datenbankverbindung
			this.connectDB();
					
			//Anzahl der Datensaetze ermitteln
			myPreparedStatement = connect.prepareStatement("SELECT COUNT(*) FROM person");
			myResultSet = myPreparedStatement.executeQuery();
			
			while (myResultSet.next()) {
				numRows = myResultSet.getInt("count(*)");
			}
						
			//Gesamtsumme der Punkteanzahl ermitteln
			myPreparedStatement = connect.prepareStatement("SELECT qsum FROM poll.person");
			myResultSet = myPreparedStatement.executeQuery();
			
			while (myResultSet.next()) {
				int tempSum = myResultSet.getInt("qsum");	
				allScores += tempSum;
			}
			
			//Durchschnitt errechnen
			average = allScores/numRows;
			
			//Durchschnitt runden auf 2 Nachkommastellen
			average = Math.round(average*100.)/100.;
			
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
			myPreparedStatement = connect.prepareStatement("SELECT name, qsum FROM person;");
			myResultSet = myPreparedStatement.executeQuery();
			
			while (myResultSet.next()) {
				String name = myResultSet.getString("name");
				int qsum = myResultSet.getInt("qsum");
				System.out.println(name + " "+ qsum);
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