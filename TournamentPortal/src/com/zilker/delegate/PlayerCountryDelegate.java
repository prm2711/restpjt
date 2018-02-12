package com.zilker.delegate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zilker.bean.Matches;
import com.zilker.bean.Player;
import com.zilker.dao.FindCountry;
import com.zilker.dao.FindPlayerMatches;
import com.zilker.dao.FindPlayer;
import com.zilker.dao.RetrieveData;

public class PlayerCountryDelegate {

	public boolean checkValidity(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setContentType("text/html");
		String country = request.getParameter("country");
		boolean valid = Pattern.compile("([a-zA-Z\\s]+)").matcher(country).matches();
		RetrieveData retrieveData=new RetrieveData();
		FindCountry findCountry = new FindCountry();
		ArrayList<Player> play = new ArrayList<Player>();
		boolean check=findCountry.checkCountry(country);
		if(valid==true) {
			if(check==true) {
			play=retrieveData.retrievePlayerByCountry(country);
			if(play==null) {
				request.setAttribute("msg", "No Player from Country");
				return false;
			}
			else {
			request.setAttribute("play",play);
			return true;
			}
		}
			else {
				request.setAttribute("msg", "No Player from Country");
				return false;
				}
			
			}
		else {
			request.setAttribute("msg", "Enter valid Country");
			return false;
		}
	}

}
