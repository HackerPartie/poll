package servletPackage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beanPackage.QuestionSumme;
import beanPackage.TextErgebnis;

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
	    
		//Fehler abfangen
		
		
		//Ermittlung des Ergebnisses
	    int mySummeQuestions = new QuestionSumme().addition(myRequest);
	    
	    //Ausgabetext holen
	    String tempAusgabe = new TextErgebnis().ausgabeText(mySummeQuestions);
		
	    //Weiterleitung des Ergebnisses und des Textes an result.jsp
		myRequest.setAttribute("summe", mySummeQuestions);
		myRequest.setAttribute("summentext", tempAusgabe);
		RequestDispatcher rdp = myRequest.getRequestDispatcher("result.jsp");
		rdp.forward(myRequest, myResponse);
		
	}

}
