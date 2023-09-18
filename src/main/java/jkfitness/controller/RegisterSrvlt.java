package jkfitness.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jkfitness.utility.ServletUtility;
import jkfitness.executedprocedures.RegisterUser;
import jkfitness.utility.ReturnResults;
/**
 * Servlet implementation class RegisterSrvlt
 */
@WebServlet(name = "RegisterSrvlt", urlPatterns= {"/RegisterSrvlt"})
public class RegisterSrvlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterSrvlt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        ServletUtility.forward(jkfView.RegisterJspUrlForServlet, request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Boolean ContinueFlag;
		ReturnResults returnResults = new ReturnResults();
		// TODO Auto-generated method stub
	    String Password       = request.getParameter("Password");
	    String retypePassword = request.getParameter("retypePassword");
	    String Name           = request.getParameter("Name");
	    String Surname        = request.getParameter("Surname");
	    String StreetAddress  = request.getParameter("StreetAddress");
	    String PostCode       = request.getParameter("PostCode");
	    String Email          = request.getParameter("Email");
	    String PhoneNumber    = request.getParameter("PhoneNumber");
	    
	    ContinueFlag = true;
	    
	    returnResults = RegisterUser.RegisterUser(Password, retypePassword, Name, Surname, Email, StreetAddress, PostCode, PhoneNumber);
	    if (returnResults.getFunctionResult() == false)
	    {
	     ContinueFlag = false;
	    }
	    
	    if (ContinueFlag)
	    {
	      ServletUtility.setSuccessMessage("Your Registration was Successful", request);	
	      ServletUtility.redirect(jkfView.LoginJspUrlForServlet, request, response);
	    }
	    else
	    {
	      ServletUtility.setErrorMessage("Error: "+returnResults.getErrorMsgs().get(0), request);
	      ServletUtility.forward(jkfView.RegisterJspUrlForServlet, request, response);
	    }
	    
	}


}
