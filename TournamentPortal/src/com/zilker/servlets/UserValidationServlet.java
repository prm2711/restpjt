package com.zilker.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.lang.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zilker.bean.Player;
import com.zilker.dao.RetrieveData;
import com.zilker.delegate.UserTypeDelegate;
import com.zilker.delegate.UserValidationDelegate;
/**
 * Servlet implementation class UserValidationServlet
 */
@WebServlet("/UserValidationServlet")
public class UserValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserValidationServlet() {
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
		HttpSession session = request.getSession();
		ArrayList<Player> play = new ArrayList<Player>();
		RetrieveData retrieveData = new RetrieveData();
		play=retrieveData.retrievePlayer();
		UserValidationDelegate userValid = new UserValidationDelegate();
		String testString = userValid.checkValidity(request, response);
		String userTypefind=null;
		UserTypeDelegate userType=new UserTypeDelegate();
		if(testString.equals("admin")) {
		session.setAttribute("name", "admin");
		session.setAttribute("username", "admin");
		session.setAttribute("play",play);
		userTypefind=userType.findUserType(request,response);
		session.setAttribute("type", userTypefind);
		rd = request.getRequestDispatcher("/jsp/home.jsp");
		rd.forward(request, response);
		}
		else if(testString.equals("false")) {
			rd = request.getRequestDispatcher("/index.jsp");
			rd.include(request, response);
		}
		else {
		session.setAttribute("name", "user");
		session.setAttribute("username", testString);
		userTypefind=userType.findUserType(request,response);
		session.setAttribute("type", userTypefind);
		session.setAttribute("play",play);
		rd = request.getRequestDispatcher("/jsp/userhome.jsp");
		rd.forward(request, response);
		}	
	}

}
