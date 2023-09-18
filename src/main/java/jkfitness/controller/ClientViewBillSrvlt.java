package jkfitness.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jkfitness.dbfunctions.DeleteBill;
import jkfitness.executedprocedures.PayBill;
import jkfitness.utility.InputDataValidator;
import jkfitness.utility.ReturnResults;
import jkfitness.utility.ServletUtility;

import java.io.IOException;

import org.hibernate.Session;
@WebServlet(name = "ClientViewBillSrvlt", urlPatterns= {"/ClientViewBillSrvlt"})
/**
 * Servlet implementation class ClientViewBillSrvlt
 */
public class ClientViewBillSrvlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientViewBillSrvlt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		ServletUtility.forward(jkfView.ClientViewBillJspUrlForServlet, request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession httpsession=request.getSession(true);
		ReturnResults returnResults = new ReturnResults();
		boolean ContinueFlag;
	
		String ClientPk        = httpsession.getAttribute("CurrentClientPk").toString();
		String Amount          = request.getParameter("Amount"); 
		
		
         ContinueFlag = true;
		
		returnResults = PayBill.PayBill(ClientPk, Amount);
		if (!returnResults.getFunctionResult())
	  	 {
	  	   ContinueFlag = false;
	  	 }
	    
	    if (ContinueFlag)
	      {
	    	  ServletUtility.setSuccessMessage("Succesful Payment", request);  
	    	  ServletUtility.redirect(jkfView.ClientViewBillJspUrlForServlet, request, response);
	      }  
	      else 
	      {
	    	  ServletUtility.setErrorMessage("Error: "+returnResults.getErrorMsgs().get(0), request);
	    	  ServletUtility.forward(jkfView.ClientViewBillJspUrlForServlet, request, response);
	      }
	      
		
	}

}
