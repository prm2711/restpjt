package com.zilker.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;

import com.zilker.bean.Matches;
import com.zilker.dao.ListPlayerTournament;
import com.zilker.dao.RetrieveData;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/ListServlet")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListServlet() {
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
		ListPlayerTournament list = new ListPlayerTournament();
		ArrayList<String> player = new ArrayList<String>();
		ArrayList<String> tour = new ArrayList<String>();
		HttpSession session=request.getSession();
		RequestDispatcher rd = null;
		String link = request.getParameter("link");
		player = list.retrievePlayerList();
		tour = list.retrieveTourList();
		JSONArray jsonPlayer=new JSONArray(player);
		JSONArray jsonTour=new JSONArray(tour);
		session.setAttribute("player", jsonPlayer);
		session.setAttribute("tour",jsonTour);
		if (link.equals("Match")) {
			rd = request.getRequestDispatcher("/jsp/insertmatch.jsp");
			rd.forward(request, response);
		} else if (link.equals("PlayervsPlayer")) {
			rd = request.getRequestDispatcher("/jsp/twoplayermatch.jsp");
			rd.forward(request, response);
		} else if (link.equals("PlayerinTournament")) {
			rd = request.getRequestDispatcher("/jsp/playertour.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		
	}

}
