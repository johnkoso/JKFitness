package jkfitness.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jkfitness.dbfunctions.GetMemberships;
import jkfitness.dbfunctions.InsertBill;
import jkfitness.dbfunctions.InsertClientMembership;
import jkfitness.executedprocedures.ChooseClientMembership;
import jkfitness.executedprocedures.RemoveClient;
import jkfitness.model.Memberships;
import jkfitness.utility.ReturnResults;
import jkfitness.utility.ServletUtility;

import java.io.IOException;
@WebServlet(name = "ClientViewMembershipSrvlt", urlPatterns= {"/ClientViewMembershipSrvlt"})
/**
 * Servlet implementation class ClientViewMembershipSrvlt
 */
public class ClientViewMembershipSrvlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientViewMembershipSrvlt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ServletUtility.forward(jkfView.ClientViewMembershipJspUrlForServlet, request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession(true);
		ReturnResults returnResults = new ReturnResults();
		Boolean ContinueFlag;
		
		String ClientPk = session.getAttribute("CurrentClientPk").toString();
		String MembershipPk          = request.getParameter("buttonValue"); 
        
		ContinueFlag = true;
		
		returnResults  = ChooseClientMembership.ChooseMembershipPublishBill(ClientPk, MembershipPk);
		if (!returnResults.getFunctionResult())
	  	 {
	  	   ContinueFlag = false;
	  	 }
	    
	    if (ContinueFlag)
	      {
	    	  ServletUtility.setSuccessMessage("Membership Choosen Succesfully", request); 
	    	  ServletUtility.redirect(jkfView.ClientViewMembershipJspUrlForServlet, request, response);
	      }  
	      else 
	      {
	    	  ServletUtility.setErrorMessage("Error: "+returnResults.getErrorMsgs().get(0), request);
	    	  ServletUtility.forward(jkfView.ClientViewMembershipJspUrlForServlet, request, response);
	      }
	      
	    
	}
	
}
