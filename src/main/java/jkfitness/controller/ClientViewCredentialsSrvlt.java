package jkfitness.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jkfitness.dbfunctions.GetClients;
import jkfitness.dbfunctions.GetUsers;

import jkfitness.dbfunctions.UpdateClient;
import jkfitness.dbfunctions.UpdateUser;
import jkfitness.executedprocedures.UpdateClientCredentials;
import jkfitness.model.Clients;
import jkfitness.model.Users;
import jkfitness.utility.CheckPassword;
import jkfitness.utility.HibernateUtil;
import jkfitness.utility.ReturnResults;
import jkfitness.utility.ServletUtility;
import jkfitness.utility.InputDataValidator;
import java.io.IOException;
import java.util.ArrayList;

import org.hibernate.Session;
@WebServlet(name = "ClientViewCredentialsSrvlt", urlPatterns= {"/ClientViewCredentialsSrvlt"})
/**
 * Servlet implementation class UpdateUserInfoServlet
 */
public class ClientViewCredentialsSrvlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientViewCredentialsSrvlt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		ServletUtility.forward(jkfView.ClientViewCredentialsJspUrlForServlet, request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Boolean ContinueFlag;
		Boolean UpdateUsersTable = false;
		Users UpdUser = null;
		ReturnResults returnResults = new ReturnResults();
		HttpSession httpsession=request.getSession(true);
		Session session =null;
		// TODO Auto-generated method stub
		String ClientPk = httpsession.getAttribute("CurrentClientPk").toString();
		String OldPassword       = request.getParameter("OldPassword");
	    String NewPassword       = request.getParameter("NewPassword");
	    String retypeNewPassword = request.getParameter("retypeNewPassword");
	    String Name              = request.getParameter("Name");
	    String Surname           = request.getParameter("Surname");
	    String StreetAddress     = request.getParameter("StreetAddress");
	    String PostCode          = request.getParameter("PostCode");
	    String Email             = request.getParameter("Email");
	    String PhoneNumber       = request.getParameter("PhoneNumber");
	    String OldEmail          = request.getParameter("OldEmail");
	    
	    ContinueFlag = true;
	    System.out.println(ClientPk);
	    returnResults = UpdateClientCredentials.UpdateClientCredentials(ClientPk, OldPassword, NewPassword, retypeNewPassword, Email, OldEmail, Name, Surname, StreetAddress, PostCode, PhoneNumber);
	    if (!returnResults.getFunctionResult())
	  	 {
	  	   ContinueFlag = false;
	  	 }
        if (ContinueFlag)
        {
    	  ServletUtility.setSuccessMessage("Your Credentials Updated Succesfully", request);  
    	  ServletUtility.redirect(jkfView.ClientViewCredentialsJspUrlForServlet, request, response);
        }  
        else 
        {
    	  ServletUtility.setErrorMessage("Error: "+returnResults.getErrorMsgs().get(0), request);
    	  ServletUtility.forward(jkfView.ClientViewCredentialsJspUrlForServlet, request, response);
        }
      
	   // ServletUtility.setErrorMessage("Error: "+returnResults.getErrorMsgs().get(0), request);
	    
	}

}
