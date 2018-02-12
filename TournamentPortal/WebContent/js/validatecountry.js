function validateForm() {
	var country = document.getElementById("country").value;
	if( country.length==0) {
		alert("Enter country");
		return false;
	}

	else {

		return true;
	}
}