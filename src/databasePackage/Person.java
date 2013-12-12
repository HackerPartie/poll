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
	private PreparedStatement preparedStatementSave = null;	
	private ResultSet resultSetRows = null;
	private PreparedStatement preparedStatementsRows = null;
	private ResultSet resultSetRowsQsum = null;
	private PreparedStatement preparedStatementsQsum = null;

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
			
			//PreparedStatement für SQL-Befehl
			preparedStatementSave = connect.prepareStatement("INSERT INTO person VALUES(default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			//Namen setzen
			preparedStatementSave.setString(1, personName);

			//Antworten setzen
			for (int i = 0; i < personAnswers.length; i++) {
				preparedStatementSave.setInt(i + 2, personAnswers[i]);
			}

			//Punkteanzahl setzen
			preparedStatementSave.setInt(11, personSum);

			//Ausfuehren des Speichern
			preparedStatementSave.executeUpdate();
			

		} catch (Exception e) {
			System.out.println(e.toString());
			
		} finally {
			close();
		}	

	}
	
	// get the average of all saved scores
	public double getAverage() {

		double numRows = 0.0;    //Anzahl der Datensaetze
		double allScores = 0.0;  //Summe der Punkteanzahl
		double average = 0.0;    //Durchschnitt
		
		try {
			//Datenbankverbindung
			this.connectDB();
					
			//Anzahl der Datensaetze ermitteln
			preparedStatementsRows = connect.prepareStatement("SELECT COUNT(*) FROM person");
			resultSetRows = preparedStatementsRows.executeQuery();
			
			while (resultSetRows.next()) {
				numRows = resultSetRows.getInt("count(*)");
			}
						
			//Gesamtsumme der Punkteanzahl ermitteln
			preparedStatementsQsum = connect.prepareStatement("SELECT qsum FROM poll.person");
			resultSetRowsQsum = preparedStatementsQsum.executeQuery();
			
			while (resultSetRowsQsum.next()) {
				int tempSum = resultSetRowsQsum.getInt("qsum");	
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
	
	
	private void close() {
		try {
			
			if (resultSetRows != null) {
				resultSetRows.close();
			}
			
			if (resultSetRowsQsum != null) {
				resultSetRowsQsum.close();
			}
			
			if (preparedStatementSave != null) {
				preparedStatementSave.close();
			}
			
			if (preparedStatementsRows != null) {
				preparedStatementsRows.close();
			}
			
			if (preparedStatementsQsum != null) {
				preparedStatementsQsum.close();
			}

			if (connect != null) {
				connect.close();
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());

		}
	}
		
}