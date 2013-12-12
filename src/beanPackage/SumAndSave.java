package beanPackage;

import javax.servlet.http.HttpServletRequest;

import databasePackage.Person;

/**
 * - liefert erreichte Punkteanzahl
 * - liefert nicht beantwortete Fragen
 * - wenn alle Fragen beantwortet wurden, wird Abspeichern des Datensatzes veranlasst
 * 
 * @author Bergsocke
 * 
 */

public class SumAndSave {
	
	private int sumQuestions;
	private int[] myIntAnswers = new int[9];
	private String txtWrongAnswers ="";

	
	public void additionAndSave(HttpServletRequest myRequest) {
		
		// Uebernahme der Antworten 
		String[] myArrayAnswers = new String[9];
		myArrayAnswers[0] = myRequest.getParameter("question_1");
		myArrayAnswers[1] = myRequest.getParameter("question_2");
		myArrayAnswers[2] = myRequest.getParameter("question_3");
		myArrayAnswers[3] = myRequest.getParameter("question_4");
		myArrayAnswers[4] = myRequest.getParameter("question_5");
		myArrayAnswers[5] = myRequest.getParameter("question_6");
		myArrayAnswers[6] = myRequest.getParameter("question_7");
		myArrayAnswers[7] = myRequest.getParameter("question_8");
		myArrayAnswers[8] = myRequest.getParameter("question_9");
		

		for (int i = 0; i < myArrayAnswers.length; i++) {
			try {
				//Umwandlung der Strings in Integer-Zahlen und Summenbildung
				myIntAnswers[i]= Integer.parseInt(myArrayAnswers[i]);
				sumQuestions += myIntAnswers[i];
				
			//falls eine Frage nicht beantwortet wurde -> Nummer der Frage wird in String für Ausgabetext gespeichert
			} catch (Exception error) {
				txtWrongAnswers += i+1 + ", ";
			}
		}
				
		//User-Name uebernehmen
		String userName = myRequest.getParameter("txtUsername");
		
		//Sicherstellen, dass Datensaetze nur gespeichert werden, wenn alle Fragen beantwortet wurden
		if (txtWrongAnswers.equals("")) {
			//Speichern in die Datenbank
			new Person().savePersonScore(userName, myIntAnswers, sumQuestions);
		}
	}
	
		
	//Getter	
	public int getSumQuestions() {
		return sumQuestions;
	}

	public String getTxtWrongAnswers() {
		return txtWrongAnswers;
	}	

}
