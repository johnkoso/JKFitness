package jkfitness.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jkfitness.utility.ServletUtility;

import java.io.IOException;

/**
 * Servlet implementation class HomeSrvlt
 */
@WebServlet(name = "HomeSrvlt", urlPatterns= {"/HomeSrvlt"})
public class HomeSrvlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeSrvlt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String op = request.getParameter("operation").toString();
	    HttpSession session=request.getSession(false);
	    if("logout".equalsIgnoreCase(op)) {
	      session.invalidate();
	      ServletUtility.setSuccessMessage("LogoutSucessfully",request);
	      
	    }
	    ServletUtility.forward(jkfView.HomeJspUrl, request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
