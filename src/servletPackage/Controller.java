package servletPackage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databasePackage.Person;

import beanPackage.SumAndSave;
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
	
		SumAndSave mySumAndSave = new SumAndSave();
		
		//Punkteanzahl ermitteln und Datensatz abspeichern
		mySumAndSave.additionAndSave(myRequest);
		int mySumQuestions = mySumAndSave.getSumQuestions();
		
	    //Ausgabetext holen
		String outputResult = new TextResult().outputText(mySumQuestions, mySumAndSave.getTxtWrongAnswers());
	
	    //Weiterleitung des Ergebnisses, des Textes und dem Durchschnitt an result.jsp
		myRequest.setAttribute("sum", mySumQuestions);
		myRequest.setAttribute("outputResult", outputResult );
		myRequest.setAttribute("average", new Person().getAverage());
		RequestDispatcher rdp = myRequest.getRequestDispatcher("result.jsp");
		rdp.forward(myRequest, myResponse);
				
	}

}
