package com.zilker.delegate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.zilker.bean.Match;
import com.zilker.bean.Player;
import com.zilker.dao.FindCountry;
import com.zilker.dao.FindPlayer;
import com.zilker.dao.FindTournament;
import com.zilker.dao.InsertData;

public class InsertPlayerDelegate {

	public boolean checkValidity(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		String player = request.getParameter("player");
		String country = request.getParameter("country");
		Gson gson = new Gson();
		int origpoints=0,newpoints=0,numbermatch=0,won=0,lost=0,draw=0;
		String prefix = "http://localhost:8080/TournamentRestApplication/rest";
		
		try {
		origpoints = Integer.parseInt(request.getParameter("origpoints"));
		newpoints = Integer.parseInt(request.getParameter("newpoints"));
		numbermatch = Integer.parseInt(request.getParameter("numbermatch"));
		won = Integer.parseInt(request.getParameter("won"));
		lost = Integer.parseInt(request.getParameter("lost"));
		draw = Integer.parseInt(request.getParameter("draw"));
		}
		catch(NumberFormatException e) {
			request.setAttribute("msg", "Enter valid Number");
			return false;
		}
		Player play=new Player();
		// check valid
		boolean validPlayer = Pattern.compile("([a-zA-Z\\s]+)").matcher(player).matches();
		boolean validCountry = Pattern.compile("([a-zA-Z\\s]+)").matcher(country).matches();
		// set data
		if (validPlayer == true && validCountry == true) {
			play.setPlayerName(player);
			play.setCountry(country);
			play.setOrigPoints(origpoints);
			play.setNewPoints(newpoints);
			play.setNumberMatch(numbermatch);
			play.setWon(won);
			play.setLost(lost);
			play.setDraw(draw);
			
			String JSONString = gson.toJson(play);
			URL url = null;
			String output;
			StringBuffer buffer = new StringBuffer();
			HttpURLConnection httpCon = null;
			try {
				url = new URL(prefix +"/players/player");
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
		} else {
			request.setAttribute("msg", "Enter valid data");
			return false;
		}

	}

}
