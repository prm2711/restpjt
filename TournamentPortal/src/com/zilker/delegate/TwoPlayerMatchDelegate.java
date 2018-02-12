package com.zilker.delegate;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zilker.dao.FindPlayerMatches;
import com.zilker.bean.Matches;
import com.zilker.dao.FindPlayer;
import com.zilker.dao.FindTournament;
import com.zilker.dao.FindTwoPlayersMatches;

public class TwoPlayerMatchDelegate {
	public boolean checkValidity(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		String player1 = request.getParameter("player1");
		int player1id, player2id, tourid;
		String player2 = request.getParameter("player2");
		String tour = request.getParameter("tour");
		FindTwoPlayersMatches findPlayerMatch = new FindTwoPlayersMatches();
		FindPlayer findPlayer = new FindPlayer();
		ArrayList<Matches> matchname = new ArrayList<Matches>();
		FindTournament findTour = new FindTournament();
		tourid = findTour.retrieveTournamentID(tour);
		player1id = findPlayer.retrievePlayerID(player1);
		player2id = findPlayer.retrievePlayerID(player2);
		if (player1id == -1 || player2id == -1) {
			request.setAttribute("msg", "Enter valid Player");
			return false;
		} else if (tourid == -1) {
			request.setAttribute("msg", "Enter valid Tournament");
			return false;
		} else {
			matchname = findPlayerMatch.retrieveMatch(player1id, player2id,tourid);
			if (matchname.isEmpty() == false) {
				request.setAttribute("list", matchname);
				return true;

			} else {
				request.setAttribute("msg", "No such match");
				return false;
			}

		}
	}
}
