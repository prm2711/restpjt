package com.zilker.delegate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.zilker.bean.*;
import com.zilker.dao.FindCountry;
import com.zilker.dao.FindPlayer;
import com.zilker.dao.FindTournament;
import com.zilker.dao.RetrieveAllMatches;
import com.zilker.dao.RetrieveData;

public class InsertDataDelegate {
	// Check if details of match are valid
	public boolean checkValidity(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		String tourname = request.getParameter("tourname");
		String player1 = request.getParameter("player1");
		String player2 = request.getParameter("player2");
		String winner = request.getParameter("winner");
		String loser = request.getParameter("loser");
		String status = request.getParameter("status");
		String score = request.getParameter("score");
		String country1, country2;
		Gson gson = new Gson();
		String prefix = "http://localhost:8080/TournamentRestApplication/rest";
		Match match = new Match();
		FindTournament findTour = new FindTournament();
		FindPlayer findPlayer = new FindPlayer();
		FindCountry findCountry = new FindCountry();
		RetrieveAllMatches retrieveData = new RetrieveAllMatches();
		ArrayList<Matches> matchList = new ArrayList<Matches>();
		int tour, play1, play2, win, lose;
		boolean check = true;
		// Score must be correct
		boolean validScore = Pattern.compile("(^[0-9]{1,2}-[0-9]{1,2}$)").matcher(score).matches();
		matchList = retrieveData.retrieveMatch();
		//Check for duplicate entries
		for (Matches m : matchList) {
			if (m.getTour().equals(tourname)) {
				if ((m.getPlay1().equals(player1) && m.getPlay2().equals(player2))
						|| (m.getPlay2().equals(player1) && m.getPlay1().equals(player2))) {
					check = false;
					break;
				}
			}
		}
		if (check == false) {
			request.setAttribute("msg", "Duplicate Match");
			return false;
		} else {
			tour = findTour.retrieveTournamentID(tourname);
			play1 = findPlayer.retrievePlayerID(player1);
			play2 = findPlayer.retrievePlayerID(player2);
			win = findPlayer.retrievePlayerID(winner);
			lose = findPlayer.retrievePlayerID(loser);
			country1 = findCountry.retrieveCountry(play1);
			country2 = findCountry.retrieveCountry(play2);
			//No tournament
			if (tour == -1) {
				request.setAttribute("msg", "Enter valid Tournament");
				return false;
			} else if (play1 == -1 || play2 == -1 || win == -1 || lose == -1) {
				request.setAttribute("msg", "Enter valid Player");
				return false;
			} else if (status.equals("Complete") == false && status.equals("Suspended") == false) {
				request.setAttribute("msg", "Enter valid Status");
				return false;
			} else if (findCountry.compareCountry(country1, country2) == false) {
				request.setAttribute("msg", "Players are from same country.");
				return false;
			} else if (!winner.equals(player1) && !winner.equals(player2)) {
				request.setAttribute("msg", "Enter valid winner.");
				return false;
			} else if (!loser.equals(player1) && !loser.equals(player2)) {
				request.setAttribute("msg", "Enter valid loser.");
				return false;
			} else if (validScore == false) {
				request.setAttribute("msg", "Enter valid score");
				return false;
			} else {
				match.setTourId(tour);
				match.setPlay1Id(play1);
				match.setPlay2Id(play2);
				match.setWinner(win);
				match.setLoser(lose);
				match.setStatus(status);
				match.setScore(score);
				/*insertData.insertMatch(match);*/
				String JSONString = gson.toJson(match);
				URL url = null;
				String output;
				StringBuffer buffer = new StringBuffer();
				HttpURLConnection httpCon = null;
				try {
					url = new URL(prefix +"/matches/match");
					httpCon = (HttpURLConnection) url.openConnection();
					httpCon.setDoOutput(true);
					httpCon.setRequestMethod("POST");
					httpCon.setRequestProperty("Accept", "application/json");
					httpCon.setRequestProperty("Content-type", "application/json");

					OutputStreamWriter out = new OutputStreamWriter(httpCon.getOutputStream());
					out.write(JSONString);
					out.close();
					BufferedReader br = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
					while ((output = br.readLine()) != null) {
						buffer.append(output);
					}
					System.out.println("buffer content = " + buffer.toString());
					
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("msg", "Data inserted successfully");
				return true;
			}
		}

	}
}
