function validateForm() {
	var tour = document.getElementById("tourname").value;
	if( tour.length==0) {
		alert("Enter tournament");
		return false;
	}

	else {

		return true;
	}
}