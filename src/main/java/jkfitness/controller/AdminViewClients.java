package jkfitness.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jkfitness.executedprocedures.AddNewMembrship;
import jkfitness.executedprocedures.RemoveClient;
import jkfitness.utility.DataUtility;
import jkfitness.utility.ReturnResults;
import jkfitness.utility.ServletUtility;

import java.io.IOException;
@WebServlet(name = "AdminViewClients", urlPatterns= {"/AdminViewClients"})
/**
 * Servlet implementation class AdminViewClients
 */
public class AdminViewClients extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminViewClients() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		ServletUtility.forward(jkfView.AdminViewClientsJspUrlForServlet, request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ReturnResults returnResults = new ReturnResults();
		Boolean ContinueFlag;
		
		ContinueFlag = true;
		
		String ClientPk             = request.getParameter("buttonValue");
		returnResults  = RemoveClient.RemoveClient(ClientPk);
		if (!returnResults.getFunctionResult())
	  	{
	  	 ContinueFlag = false;
	  	}
	    if (ContinueFlag)
	      {
	    	  ServletUtility.setSuccessMessage("Client Deleted Succesfully", request);  
	    	  ServletUtility.redirect(jkfView.AdminViewClientsJspUrlForServlet, request, response);
	      }  
	      else 
	      {
	    	  ServletUtility.setErrorMessage("Error: "+returnResults.getErrorMsgs().get(0), request);
	    	  ServletUtility.forward(jkfView.AdminViewClientsJspUrlForServlet, request, response);
	      }
	      
		
	}

}
