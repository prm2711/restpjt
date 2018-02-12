package com.zilker.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zilker.bean.Match;
import com.zilker.dao.FindCountry;
import com.zilker.dao.FindPlayer;
import com.zilker.dao.FindTournament;
import com.zilker.dao.InsertData;
import com.zilker.delegate.InsertDataDelegate;

/**
 * Servlet implementation class InsertMatchServlet
 */
@WebServlet("/InsertMatchServlet")
public class InsertMatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertMatchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		RequestDispatcher rd;
		InsertDataDelegate insertDelegate = new InsertDataDelegate();
		boolean value=insertDelegate.checkValidity(request, response);
		if(value==false) {
		rd = request.getRequestDispatcher("/jsp/insertmatch.jsp");
		rd.include(request, response);
		}
		else {
		rd = request.getRequestDispatcher("/jsp/home.jsp");
		rd.include(request, response);
		}
	}

}
