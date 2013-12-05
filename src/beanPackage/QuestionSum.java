package beanPackage;

import javax.servlet.http.HttpServletRequest;


public class QuestionSum {
	
	public int addition(HttpServletRequest myRequest) {
		
		// Uebernahme der Antworten
		String tempQuestion1 = myRequest.getParameter("question_1");
		String tempQuestion2 = myRequest.getParameter("question_2");
		String tempQuestion3 = myRequest.getParameter("question_3");
		String tempQuestion4 = myRequest.getParameter("question_4");
		String tempQuestion5 = myRequest.getParameter("question_5");
		String tempQuestion6 = myRequest.getParameter("question_6");
		String tempQuestion7 = myRequest.getParameter("question_7");
		String tempQuestion8 = myRequest.getParameter("question_8");
		String tempQuestion9 = myRequest.getParameter("question_9");
		
		//Exception-Handling, wenn nicht alle Buttons geklickt wurden
		try {
			// Umwandlung der String-Anworten in Integer
			int intQ1 = Integer.parseInt(tempQuestion1);
			int intQ2 = Integer.parseInt(tempQuestion2);
			int intQ3 = Integer.parseInt(tempQuestion3);
			int intQ4 = Integer.parseInt(tempQuestion4);
			int intQ5 = Integer.parseInt(tempQuestion5);
			int intQ6 = Integer.parseInt(tempQuestion6);
			int intQ7 = Integer.parseInt(tempQuestion7);
			int intQ8 = Integer.parseInt(tempQuestion8);
			int intQ9 = Integer.parseInt(tempQuestion9);

			// Summenbildung
			int sumQuestions = intQ1 + intQ2 + intQ3 + intQ4 + intQ5 + intQ6
					+ intQ7 + intQ8 + intQ9;

			return sumQuestions;
			
		} catch (Exception e) {
			int sumQuestions = 0;
			return sumQuestions;

		}



	}

}
