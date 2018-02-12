function validateForm() {
	var player = document.getElementById("player").value;
	var country = document.getElementById("country").value;
	var origpoints = document.getElementById("origpoints").value;
	var newpoints = document.getElementById("newpoints").value;
	var numbermatch = document.getElementById("numbermatch").value;
	var won= document.getElementById("won").value;
	var lost = document.getElementById("lost").value;
	var draw = document.getElementById("draw").value;
	if( player.length==0) {
		alert("Enter player name");
		return false;
	}
	else if(country.length==0 ) {
		alert("Enter country");
		return false;
	}
	else if(origpoints.length==0 ) {
		alert("Enter original points");
		return false;
	}
	else if(newpoints.length==0 ) {
		alert("Enter new points");
		return false;
	}
	else if(numbermatch.length==0 ) {
		alert("Enter number of matches");
		return false;
	}
	else if(won.length==0 ) {
		alert("Enter matches won");
		return false;
	}
	else if(lost.length==0 ) {
		alert("Enter matches lost");
		return false;
	}
	else if(draw.length==0 ) {
		alert("Enter matches drawn");
		return false;
	}
	else {

		return true;
	}
}