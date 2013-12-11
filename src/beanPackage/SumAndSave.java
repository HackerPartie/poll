package beanPackage;

import javax.servlet.http.HttpServletRequest;

import databasePackage.Person;


public class SumAndSave {
	
	private int sumQuestions;
	private int[] wrongAnswers ={0,0,0,0,0,0,0,0,0};
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
				
			//falls eine Frage nicht beantwortet wurde -> Abspeichern des IndexPlatzes
			//und der Wert wird auf 0 gesetzt
			} catch (Exception error) {
				wrongAnswers[i] = i+1;
				myIntAnswers[i] = 0;
			}

		}
		
		//Zusammenfassen der nicht-geklickten Antwortnummern in einen String für den Ausgabetext				
		for (int i : wrongAnswers) {
			if (i == 0) {
				//do nothing
			} else{
				txtWrongAnswers += i + ", ";
			}
		}
		
		//User-Name uebernehmen
		String userName = myRequest.getParameter("txtUsername");
		
		//Sicherstellen, dass Datensaetze nur gespeichert werden, wenn alle Fragen beantwortet wurden
		if (txtWrongAnswers.equals("")) {
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
