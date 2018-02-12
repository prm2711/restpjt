package com.zilker.constant;

public class Constants {
	public static final String DB_URL = "jdbc:mysql://localhost/tournament";
	// Database credentials
	public static final String USER = "root";
	public static final String PASS = "Ztech@123";
	public static final String PATH = "com.mysql.jdbc.Driver";
	// Match related operations
	public static final String INSERTMATCH = "insert into matches (tourid,play1id,play2id,winner,loser,status,score) values(?,?,?,?,?,?,?)";
	public static final String RETMATCH = "select tourid,play1id,play2id,winner,loser,status,score from matches";
	public static final String FINDMATCH = "select tourid,play1id,play2id,winner,loser,status,score from matches where play1id=? or play2id=?";
	public static final String FINDRESULT = "select tourid,play1id,play2id,winner,loser,status,score from matches where ((play1id=? and play2id=?) "
			+ "or (play1id=? and play2id=?)) and tourid=?";
	public static final String FINDMATCHTOURNAMENT = "select tourid,play1id,play2id,winner,loser,status,score from matches where tourid=? or tourid=?";

	
	// Player related operations
	public static final String RET = "select player_name,country,origpoints,newpoints,numbermatch,won,lost,draw"
			+ " from player order by newpoints desc";
	public static final String UPDATEPOINT = "update player set newpoints=newpoints+1000 where playerid=?";
	public static final String UPDATEMATCH = "update player set numbermatch=numbermatch+1 where playerid=?";
	public static final String UPDATEWIN = "update player set won=won+1 where playerid=?";
	public static final String UPDATELOSS = "update player set lost=lost+1 where playerid=?";
	public static final String RETSORT = "select player_name,country,origpoints,newpoints,numbermatch,won,lost,draw from player ";
	public static final String UPDATEPOINTSUS = "update player set newpoints=newpoints+500 where playerid=?";
	public static final String UPDATEDRAW = "update player set draw=draw+1 where playerid=?";
	public static final String FINDNAME = "select player_name from player where playerid=?";
	public static final String FINDPLAYER = "select playerid from player where player_name=?";
	public static final String FINDPLAYERTOURNAMENT = "select tourid,play1id,play2id,winner,loser,status,score from matches where (play1id=? or play2id=?) and tourid=?";
	public static final String MOSTIMPROVEDPLAYER = "select * from player order by (newpoints-origpoints) desc ";
	public static final String RETRIEVECOUNTRY = "select country from player where playerid=?";
	public static final String PLAYERLIST = "select player_name from player";
	public static final String INSERTPLAYER = "insert into player (player_name,country,origpoints,"
			+ "newpoints,numbermatch,won,lost,draw) values(?,?,?,?,?,?,?,?)";
	public static final String RETRIEVEPLAYERBYCOUNTRY = "select player_name,country,origpoints,newpoints,"
			+ "numbermatch,won,lost,draw from player where country=?";
	public static final String COUNTRYLIST = "select distinct country from player";
	
	// tournament
	public static final String INSERTTOURNAMENT = "insert into tour (tourname) values(?)";
	public static final String FINDTOURNAMENT = "select tourname from tour where tourid=?";
	public static final String FINDTOURNAMENTID = "select tourid from tour where tourname=?";
	public static final String TOURLIST = "select tourname from tour";
	// User details
	public static final String RETRIEVEUSER = "select username,pass from userdetails";
	public static final String RETRIEVEPRIVILEGEDUSER = "select type from userdetails where username=?";

	
	

}
