function validateForm() {
	var player1 = document.getElementById("player1").value;
	var player2 = document.getElementById("player2").value;
	var tour = document.getElementById("tour").value;
	if (player1.length == 0) {
		alert("Enter player1");
		return false;
	} else if (player2.length == 0) {
		alert("Enter player2");
		return false;
	} else if (tour.length == 0) {
		alert("Enter tournament");
		return false;
	} else {

		return true;
	}
}