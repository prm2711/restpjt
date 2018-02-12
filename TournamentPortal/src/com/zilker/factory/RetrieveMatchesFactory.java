package com.zilker.factory;

import com.zilker.dao.FindPlayerMatches;
import com.zilker.dao.FindTwoPlayersMatches;
import com.zilker.dao.RetrieveAllMatches;
import com.zilker.dao.RetrieveTournamentMatches;
import com.zilker.interfaces.RetrieveMatchesInterface;

public class RetrieveMatchesFactory {
	 public RetrieveMatchesInterface getType(String userType){
	      if(userType == null){
	         return null;
	      }		
	      else if(userType.equals("Special")) {
	    	  return new RetrieveAllMatches();
	      }
	      else if(userType.equals("Normal")) {
	    	  return new RetrieveTournamentMatches();
	      }
	      return null;
	   }
}
