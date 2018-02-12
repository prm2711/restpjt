package com.zilker.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zilker.delegate.InsertDataDelegate;
import com.zilker.delegate.InsertTournamentDelegate;

/**
 * Servlet implementation class InsertTournamentServlet
 */
@WebServlet("/InsertTournamentServlet")
public class InsertTournamentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertTournamentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		RequestDispatcher rd;
		InsertTournamentDelegate insertDelegate = new InsertTournamentDelegate();
		boolean value=insertDelegate.checkValidity(request, response);
		if(value==false) {
		rd = request.getRequestDispatcher("/jsp/inserttour.jsp");
		rd.include(request, response);
		}
		else {
		rd = request.getRequestDispatcher("/jsp/home.jsp");
		rd.include(request, response);
		}
	}

}
