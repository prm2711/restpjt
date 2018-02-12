function validateForm() {
	var user = document.getElementById("username").value;
	var password = document.getElementById("password").value;

	if (user.length == 0) {
		alert("Enter username");
		return false;
	}
	else if(password.length == 0) {
		alert("Enter password");
		return false;
	}
	else {

		return true;
	}
}
