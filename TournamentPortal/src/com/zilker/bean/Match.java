package com.zilker.bean;

public class Match {
	private int play1id, play2id, winner, loser,tourid;
	private String status, score;

	public Match() {
		tourid=0;
		play1id = 0;
		play2id = 0;
		winner = 0;
		loser = 0;
		status = null;
		score = null;

	}

	public int getTourId() {
		return tourid;
	}

	public void setTourId(int tour) {
		this.tourid = tour;
	}
	// get and set id
	public int getPlay1Id() {
		return play1id;
	}

	public void setPlay1Id(int p1id) {
		this.play1id = p1id;
	}

	public int getPlay2Id() {
		return play2id;
	}

	public void setPlay2Id(int p2id) {
		this.play2id = p2id;
	}

	public int getWinner() {
		return winner;
	}

	public void setWinner(int win) {
		this.winner = win;
	}

	public int getLoser() {
		return loser;
	}

	public void setLoser(int loser) {
		this.loser = loser;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;

	}

}
