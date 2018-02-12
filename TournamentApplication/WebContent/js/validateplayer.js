function validateForm() {
	var player = document.getElementById("player").value;
	if( player.length==0) {
		alert("Enter player");
		return false;
	}

	else {

		return true;
	}
}