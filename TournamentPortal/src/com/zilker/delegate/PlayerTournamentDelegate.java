package com.zilker.delegate;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zilker.dao.FindPlayerMatches;
import com.zilker.bean.Matches;
import com.zilker.dao.FindPlayer;
import com.zilker.dao.FindTournament;

public class PlayerTournamentDelegate {
     
	public boolean checkValidity(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		String player = request.getParameter("player");
		int playerid, tourid;
		String tour = request.getParameter("tour");
		FindPlayer findPlayer = new FindPlayer();
		FindPlayerMatches findPlayerMatch = new FindPlayerMatches();
		FindTournament findTour = new FindTournament();
		ArrayList<Matches> matches = new ArrayList<Matches>();
	
			playerid = findPlayer.retrievePlayerID(player);
			tourid = findTour.retrieveTournamentID(tour);
			if (playerid == -1) {
				request.setAttribute("msg", "Enter valid Player");
				return false;
			} else if (tourid == -1) {
				request.setAttribute("msg", "Enter valid Tournament");
				return false;
			} else {
				matches = findPlayerMatch.retrieveMatch(playerid, tourid);
				if (matches.isEmpty() == false) {
					request.setAttribute("list", matches);
					return true;
				} else {
					request.setAttribute("msg", "No such match");
					return false;
				}
			
		}

	}
}
