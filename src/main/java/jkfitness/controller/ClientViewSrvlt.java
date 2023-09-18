package jkfitness.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jkfitness.utility.DataUtility;
import jkfitness.utility.InputDataValidator;
import jkfitness.utility.ReturnResults;
import jkfitness.utility.ServletUtility;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jkfitness.model.Clients;
import jkfitness.dbfunctions.GetClients;
import jkfitness.dbfunctions.UpdateClient;

/**
 * Servlet implementation class ClientViewSrvlt
 */
@WebServlet(name = "ClientViewSrvlt", urlPatterns= {"/ClientViewSrvlt"})
public class ClientViewSrvlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientViewSrvlt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	
	   
		ServletUtility.forward(jkfView.ClientViewJspUrlForServlet, request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Boolean ContinueFlag = true;
		// TODO Auto-generated method stub
		

	    ServletUtility.forward(jkfView.ClientViewCredentialsJspUrlForServlet, request, response);
	}

}
