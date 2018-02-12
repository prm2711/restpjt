package com.zilker.delegate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.zilker.bean.Player;
public class RetrievePlayerDelegate {

String prefix = "http://localhost:8080/TournamentRestApplication/rest";
	
	StringBuffer stringBuffer = new StringBuffer();
	String line = null;
	ArrayList<Player> play= new ArrayList<Player>();

	
	public ArrayList<Player> retrievePlayers() {
		// TODO Auto-generated method stub

		HttpURLConnection conn = null;
		String playerName=null,country=null;
		int origPoints=0,newPoints=0,numberMatch=0,won=0,lost=0,draw=0;
		try {
			URL url = new URL(prefix + "/players");
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Type", "application/json");
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((line = reader.readLine()) != null) {
				stringBuffer.append(line);
				System.out.println(line);
			}

			JSONParser parse = new JSONParser();
			JSONArray array = (JSONArray) parse.parse(stringBuffer.toString());
			for (int i = 0; i < array.size(); i++) {
				JSONObject object = (JSONObject) array.get(i);
				playerName=object.get("playerName").toString();
				country=object.get("country").toString();
				origPoints=Integer.parseInt(object.get("origPoints").toString());
				newPoints=Integer.parseInt(object.get("newPoints").toString());
				numberMatch=Integer.parseInt(object.get("numberMatch").toString());
				won=Integer.parseInt(object.get("won").toString());
				lost=Integer.parseInt(object.get("lost").toString());
				draw=Integer.parseInt(object.get("draw").toString());
				Player player = new Player(playerName,country,origPoints,newPoints,numberMatch,won,lost,draw);
				play.add(player);
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
		
	return play;
	}

}
