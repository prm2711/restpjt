package com.zilker.bean;

public class Player {
	private String player_name;
	private String country;
	private int origpoints, newpoints, numbermatch, won, lost, draw;

	public Player(String p,String c,int o,int n,int num,int w,int l,int d) {
		player_name = p;
		country = c;
		origpoints = o;
		newpoints=n;
		numbermatch=num;
		won=w;
		lost=l;
		draw=d;
	}

	public String getPlayerName() {
		return player_name;
	}

	public void setPlayerName(String player) {
		this.player_name = player;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getOrig() {
		return origpoints;
	}

	public void setOrig(int orig) {
		this.origpoints = orig;
	}

	public int getNew() {
		return newpoints;
	}

	public void setNew(int newp) {
		this.newpoints = newp;
	}

	public int getNumber() {
		return numbermatch;
	}

	public void setNumber(int num) {
		this.numbermatch = num;
	}

	public int getWon() {
		return won;
	}

	public void setWon(int won) {
		this.won = won;
	}

	public int getLost() {
		return lost;
	}

	public void setLost(int lost) {
		this.lost = lost;
	}

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}
}
