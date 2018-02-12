package com.zilker.delegate;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zilker.bean.Matches;
import com.zilker.factory.RetrieveMatchesFactory;
import com.zilker.interfaces.RetrieveMatchesInterface;

public class RetrieveMatchesFactoryDelegate {

	public ArrayList<Matches> findMatches(HttpServletRequest request, HttpServletResponse response) {
		RetrieveMatchesFactory factory = new RetrieveMatchesFactory();
		String type = (String)request.getSession().getAttribute("type");
		RetrieveMatchesInterface interfaceMatch = factory.getType(type);
		ArrayList<Matches> matchList = new ArrayList<Matches>();
		matchList=interfaceMatch.retrieveMatch();
		return matchList;
	}
}
