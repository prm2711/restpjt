package com.zilker.delegate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.zilker.bean.Matches;
import com.zilker.bean.Player;
import com.zilker.dao.FindCountry;
import com.zilker.dao.FindPlayer;
import com.zilker.dao.RetrieveData;

public class PlayerCountryDelegate {

	public boolean checkValidity(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		String country = request.getParameter("country");
		boolean valid = Pattern.compile("([a-zA-Z\\s]+)").matcher(country).matches();
		RetrieveData retrieveData = new RetrieveData();
		FindCountry findCountry = new FindCountry();
		
		boolean check = findCountry.checkCountry(country);
		StringBuffer stringBuffer = new StringBuffer();
		String line = null;
		boolean playerExists = false;
		String prefix = "http://localhost:8080/TournamentRestApplication/rest";
		ArrayList<Player> play = new ArrayList<Player>();
		if (valid == true) {

			//play = retrieveData.retrievePlayerByCountry(country);
				HttpURLConnection conn = null;
				String playerName = null, countryName = null;
				int origPoints = 0, newPoints = 0, numberMatch = 0, won = 0, lost = 0, draw = 0;
				try {
					URL url = new URL(prefix +"/players/country/"+country);
					conn = (HttpURLConnection) url.openConnection();
					conn.setRequestMethod("GET");
					conn.setRequestProperty("Accept", "application/json");
					conn.setRequestProperty("Content-Type", "application/json");
					BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
					while ((line = reader.readLine()) != null) {
						playerExists = true;
						stringBuffer.append(line);
						System.out.println(line);
					}
                    if(playerExists==true) {
					JSONParser parse = new JSONParser();
					JSONArray array = (JSONArray) parse.parse(stringBuffer.toString());
					for (int i = 0; i < array.size(); i++) {
						JSONObject object = (JSONObject) array.get(i);
						playerName = object.get("playerName").toString();
						countryName = object.get("country").toString();
						origPoints = Integer.parseInt(object.get("origPoints").toString());
						newPoints = Integer.parseInt(object.get("newPoints").toString());
						numberMatch = Integer.parseInt(object.get("numberMatch").toString());
						won = Integer.parseInt(object.get("won").toString());
						lost = Integer.parseInt(object.get("lost").toString());
						draw = Integer.parseInt(object.get("draw").toString());
						Player player = new Player(playerName, countryName, origPoints, newPoints, numberMatch, won,
								lost, draw);
						play.add(player);
					}
					request.setAttribute("play", play);
					return true;
                    }
                    else {
                    	request.setAttribute("msg", "no player from country");
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

		else {
			request.setAttribute("msg", "Enter valid Country");
			return false;
		}
return true;
	}

}
