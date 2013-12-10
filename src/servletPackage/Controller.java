package servletPackage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databasePackage.Person;

import beanPackage.QuestionSum;
import beanPackage.TextResult;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/myController")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest myRequest, HttpServletResponse myResponse) throws ServletException, IOException {
	
		QuestionSum myQuestionSum = new QuestionSum();
		
		//Ermittlung des User-Namens
		String userName = myRequest.getParameter("txtUsername");
		
		//Ermittlung des Ergebnisses
		myQuestionSum.addition(myRequest);
		int mySumQuestions = myQuestionSum.getSumQuestions();
		
		//Ermittlung der Integer-Werte der Antworten		
		int[] tempArray = myQuestionSum.getMyIntAnswers();
		//Array-Kopie erstellen
		int[] intQ = new int[tempArray.length];
		System.arraycopy(tempArray, 0, intQ, 0, intQ.length);

		//Datensatz abspeichern
		Person myPerson = new Person();
		myPerson.savePersonScore(userName, intQ[0], intQ[1], intQ[2], intQ[3], intQ[4], intQ[5], intQ[6], intQ[7], intQ[8], mySumQuestions);
	    
	    //Fehlende Antworten ermitteln
		int[] pWrong = myQuestionSum.getWrongAnswers();
    
	    //Ausgabetext ermitteln
		String outputResult = new TextResult().outputText(mySumQuestions, pWrong);
		
		//Average ermitteln
		double myAverage = new Person().getAverage();
	
	    //Weiterleitung des Ergebnisses, des Textes und dem Durchschnitt an result.jsp
		myRequest.setAttribute("sum", mySumQuestions);
		myRequest.setAttribute("outputResult", outputResult );
		myRequest.setAttribute("average", myAverage);
		RequestDispatcher rdp = myRequest.getRequestDispatcher("result.jsp");
		rdp.forward(myRequest, myResponse);
				
	}

}
