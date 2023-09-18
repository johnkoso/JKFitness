package jkfitness.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.annotation.WebServlet;
import jkfitness.utility.ServletUtility;
import jkfitness.utility.ReturnResults;
import jkfitness.executedprocedures.LoginUser;
import jkfitness.model.Clients;
/**
 * Servlet implementation class LoginSrvlt
 */
@WebServlet(name = "LoginSrvlt", urlPatterns= {"/LoginSrvlt"})
public class LoginSrvlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginSrvlt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		ServletUtility.forward(jkfView.LoginJspUrlForServlet, request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Boolean ContinueFlag ;
		String CurrentClientPk;
		String Email          = request.getParameter("Email");
		String Password       = request.getParameter("Password");
		
		ContinueFlag = true;
		ReturnResults returnResults = new ReturnResults();
		HttpSession session=request.getSession(true);
		
		
		if (ContinueFlag)
	  	  {
	  	    returnResults  = LoginUser.LoginUser( Email, Password);
	  	  
	  	    if (returnResults.getFunctionResult() == false)
	  	    {
	  	      ContinueFlag = false;
	  	    }
	  	  }
		if (ContinueFlag)
	    { 
		  
		  if (returnResults.getStringResults().get(0).equals("Client"))
		  {	  
		    CurrentClientPk = returnResults.getIntResults().get(0).toString();
            session.setAttribute("CurrentClientPk", CurrentClientPk);
	        ServletUtility.redirect(jkfView.ClientViewJspUrlForServlet, request, response);
		  }
		  else
		  {
			   ServletUtility.redirect(jkfView.AdminViewJspUrlForServlet, request, response);  
		  }	  
	    }
	    else
	    {
	      ServletUtility.setErrorMessage("Error: "+returnResults.getErrorMsgs().get(0), request);
	      ServletUtility.forward(jkfView.LoginJspUrlForServlet, request, response);
	    }
	    
	}

}
