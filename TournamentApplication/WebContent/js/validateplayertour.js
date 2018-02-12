function validateForm() {
	var player = document.getElementById("player").value;
	var tour = document.getElementById("tour").value;
	if( player.length==0) {
		alert("Enter player name");
		return false;
	}
	else if(tour.length==0 ) {
		alert("Enter tournament name");
		return false;
	}
	else {

		return true;
	}
}