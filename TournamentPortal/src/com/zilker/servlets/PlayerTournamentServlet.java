package com.zilker.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zilker.dao.FindPlayerMatches;
import com.zilker.bean.Match;
import com.zilker.bean.Matches;
import com.zilker.dao.FindPlayer;
import com.zilker.dao.FindTournament;
import com.zilker.delegate.PlayerTournamentDelegate;

/**
 * Servlet implementation class PlayerTournamentServlet
 */
@WebServlet("/PlayerTournamentServlet")
public class PlayerTournamentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PlayerTournamentServlet() {
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
		PlayerTournamentDelegate playerTournament = new PlayerTournamentDelegate();
		boolean valid=playerTournament.checkValidity(request, response);
		if(valid==false) {
		rd = request.getRequestDispatcher("/jsp/playertour.jsp");
		rd.include(request, response);
		}
		else {
		rd = request.getRequestDispatcher("/jsp/matchesplayer.jsp");
		rd.forward(request, response);
		}
	}

}
