function validateForm() {
	var tour = document.getElementById("tourname").value;
	var player1 = document.getElementById("player1").value;
	var player2 = document.getElementById("player2").value;
	var winner = document.getElementById("winner").value;
	var loser = document.getElementById("loser").value;
	var status= document.getElementById("status").value;
	var score = document.getElementById("score").value;
	if( tour.length==0 ) {
		alert("Enter tournament");
		return false;
	}
	else if(player1.length==0 ) {
		alert("Enter player1 name");
		return false;
	}
	else if(player2.length==0 ) {
		alert("Enter player2 name");
		return false;
	}
	else if(winner.length==0 ) {
		alert("Enter winner");
		return false;
	}
	else if(loser.length==0 ) {
		alert("Enter loser");
		return false;
	}
	else if(status.length==0 ) {
		alert("Enter status");
		return false;
	}
	else if(score.length==0 ) {
		alert("Enter score");
		return false;
	}
	else {

		return true;
	}
}