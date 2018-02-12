package com.zilker.bean;

public class Matches {
	private String play1, play2, winner, loser,tour;
	private String status, score;

	public String getTour() {
		return tour;
	}

	public void setTour(String tour) {
		this.tour = tour;
	}
	// get and set id
	public String getPlay1() {
		return play1;
	}

	public void setPlay1(String p1id) {
		this.play1= p1id;
	}

	public String getPlay2() {
		return play2;
	}

	public void setPlay2(String p2id) {
		this.play2= p2id;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String win) {
		this.winner = win;
	}

	public String getLoser() {
		return loser;
	}

	public void setLoser(String loser) {
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
