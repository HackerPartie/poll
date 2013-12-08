package servletPackage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		//Ermittlung des Ergebnisses
		myQuestionSum.addition(myRequest);
		int mySumQuestions = myQuestionSum.getSumQuestions();
	    
	    //Fehlende Antworten ermitteln
		int[] pWrong = myQuestionSum.getWrongAnswers();

	    
	    //Ausgabetext holen
		String outputResult = new TextResult().outputText(mySumQuestions, pWrong);
	
	    //Weiterleitung des Ergebnisses und des Textes an result.jsp
		myRequest.setAttribute("sum", mySumQuestions);
		myRequest.setAttribute("outputResult", outputResult );
		RequestDispatcher rdp = myRequest.getRequestDispatcher("result.jsp");
		rdp.forward(myRequest, myResponse);
		
	}

}
