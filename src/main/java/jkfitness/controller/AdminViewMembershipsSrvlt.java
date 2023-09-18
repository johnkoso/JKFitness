package jkfitness.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jkfitness.dbfunctions.InsertMembership;
import jkfitness.executedprocedures.AddNewMembrship;
import jkfitness.utility.ReturnResults;
import jkfitness.utility.ServletUtility;

import java.io.IOException;
@WebServlet(name = "AdminViewMembershipsSrvlt", urlPatterns= {"/AdminViewMembershipsSrvlt"})
/**
 * Servlet implementation class AdminViewMembershipsSrvlt
 */
public class AdminViewMembershipsSrvlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminViewMembershipsSrvlt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ServletUtility.forward(jkfView.AdminViewMembershipsJspUrlForServlet, request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ReturnResults returnResults = new ReturnResults();
		Boolean ContinueFlag;
		String MembershipName       = request.getParameter("MembershipName"); 
		String MembershipDescr          = request.getParameter("MembershipDescr"); 
		String MembershipNumOfMonths       = request.getParameter("MembershipNumOfMonths"); 
		String MembershipPrice          = request.getParameter("MembershipPrice"); 
		
		ContinueFlag = true;
		
		returnResults  = AddNewMembrship.AddMembership(MembershipName, MembershipDescr, MembershipNumOfMonths, MembershipPrice);
		if (!returnResults.getFunctionResult())
	  	 {
	  	   ContinueFlag = false;
	  	 }
	    
	    if (ContinueFlag)
	      {
	    	  
	    	  ServletUtility.redirect(jkfView.AdminViewMembershipsJspUrlForServlet, request, response);
	    	  ServletUtility.setSuccessMessage("Membership Added Succesfully", request);  
	      }  
	      else 
	      {
	    	  ServletUtility.setErrorMessage("Error: "+returnResults.getErrorMsgs().get(0), request);
	    	  ServletUtility.forward(jkfView.AdminViewMembershipsJspUrlForServlet, request, response);
	      }
	      
		
	}

}
