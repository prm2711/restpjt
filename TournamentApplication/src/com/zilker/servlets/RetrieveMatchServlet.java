package com.zilker.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zilker.bean.Match;
import com.zilker.bean.Matches;
import com.zilker.bean.Player;
import com.zilker.dao.RetrieveAllMatches;
import com.zilker.dao.RetrieveData;
import com.zilker.delegate.RetrieveMatchesFactoryDelegate;

/**
 * Servlet implementation class RetrieveMatchServlet
 */
@WebServlet("/RetrieveMatchServlet")
public class RetrieveMatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetrieveMatchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RetrieveMatchesFactoryDelegate retrieveMatch =new RetrieveMatchesFactoryDelegate();
		ArrayList<Matches> matchList = new ArrayList<Matches>();
		RequestDispatcher rd;
		matchList=retrieveMatch.findMatches(request,response);
		rd = request.getRequestDispatcher("/jsp/matchesplayer.jsp");
		request.setAttribute("list",matchList);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
