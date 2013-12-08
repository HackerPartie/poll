package beanPackage;

import javax.servlet.http.HttpServletRequest;


public class QuestionSum {
	
	private int sumQuestions;
	private int wrongAnswers = 0;
	private int[] myIntAnswers = new int[9];
	
	public void addition(HttpServletRequest myRequest) {
		
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
				//Umwandlung der Strings in Integer-Zahlen
				myIntAnswers[i]= Integer.parseInt(myArrayAnswers[i]);
				sumQuestions += myIntAnswers[i];
				
			//falls eine Frage nicht beantwortet wurde, wird Wert auf 0 gesetzt
			} catch (Exception e) {
				wrongAnswers = i+1;
			}

		}
	}

	public int getWrongAnswers() {
		return wrongAnswers;
	}

	public int getSumQuestions() {
		return sumQuestions;
	}
	
	
	
	

}
