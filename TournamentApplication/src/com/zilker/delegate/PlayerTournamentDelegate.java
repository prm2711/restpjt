package com.zilker.delegate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.zilker.bean.Matches;
import com.zilker.dao.FindPlayer;
import com.zilker.dao.FindTournament;

public class PlayerTournamentDelegate {
     
	public boolean checkValidity(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		String player = request.getParameter("player");
		int playerid, tourid;
		String tourName = request.getParameter("tour");
		FindPlayer findPlayer = new FindPlayer();
		FindTournament findTour = new FindTournament();
		ArrayList<Matches> matches = new ArrayList<Matches>();
		String prefix = "http://localhost:8080/TournamentRestApplication/rest";
		String play1, play2, winner, loser,tour;
		String status, score;
		boolean check=false;
		StringBuffer stringBuffer = new StringBuffer();
		String line = null;
		
			playerid = findPlayer.retrievePlayerID(player);
			tourid = findTour.retrieveTournamentID(tourName);
			tourName=tourName.replaceAll(" ", "%20");
			if (playerid == -1) {
				request.setAttribute("msg", "Enter valid Player");
				return false;
			} else if (tourid == -1) {
				request.setAttribute("msg", "Enter valid Tournament");
				return false;
			} else {
				
				
				HttpURLConnection conn = null;
				try {
					URL url = new URL(prefix + "/matches/tournament/"+tourName+"?player="+player);
					conn = (HttpURLConnection) url.openConnection();
					conn.setRequestMethod("GET");
					conn.setRequestProperty("Accept", "application/json");
					conn.setRequestProperty("Content-Type", "application/json");
					BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
					while ((line = reader.readLine()) != null) {
						check=true;
						stringBuffer.append(line);
						System.out.println(line);
					}
	                if(check==true) {
					JSONParser parse = new JSONParser();
					JSONArray array = (JSONArray) parse.parse(stringBuffer.toString());
					for (int i = 0; i < array.size(); i++) {
						JSONObject object = (JSONObject) array.get(i);
						play1=object.get("play1").toString();
						play2=object.get("play2").toString();
						tour=object.get("tour").toString();
						winner=object.get("winner").toString();
						loser=object.get("loser").toString();
						status=object.get("status").toString();
						score=object.get("score").toString();
						Matches match=new Matches();
						match.setTour(tour);
						match.setPlay1(play1);
						match.setPlay2(play2);
						match.setWinner(winner);
						match.setLoser(loser);
						match.setStatus(status);
						match.setScore(score);
						matches.add(match);	
					}
					request.setAttribute("list", matches);
					return true;
	                }
	                else
	                {
	                	request.setAttribute("msg", "No such match");
	                	return false;
	                }
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			
				
		}
			return true;
	}
}
