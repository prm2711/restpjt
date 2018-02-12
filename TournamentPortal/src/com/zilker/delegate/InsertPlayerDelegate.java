package com.zilker.delegate;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		int origpoints=0,newpoints=0,numbermatch=0,won=0,lost=0,draw=0;
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
		Player play=new Player("","",0,0,0,0,0,0);
		InsertData insertData = new InsertData();
		// check valid
		boolean validPlayer = Pattern.compile("([a-zA-Z\\s]+)").matcher(player).matches();
		boolean validCountry = Pattern.compile("([a-zA-Z\\s]+)").matcher(country).matches();
		// set data
		if (validPlayer == true && validCountry == true) {
			play.setPlayerName(player);
			play.setCountry(country);
			play.setOrig(origpoints);
			play.setNew(newpoints);
			play.setNumber(numbermatch);
			play.setWon(won);
			play.setLost(lost);
			play.setDraw(draw);
			insertData.insertPlayer(play);
			request.setAttribute("msg", "Data inserted successfully");
			return true;
		} else {
			request.setAttribute("msg", "Enter valid data");
			return false;
		}

	}

}
