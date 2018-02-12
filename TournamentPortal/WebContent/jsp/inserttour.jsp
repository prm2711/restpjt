<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="nav.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add a Tournament</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/css/insertpage.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/css/media-query.css"/>">
</head>
<body>
	<div class="insert-data" id="container">
		<h1>${msg }</h1>
		<h2>Add a Tournament</h2>
		<form method="post"
			action="<c:url value = "/InsertTournamentServlet"/>"
			onsubmit="return validateForm()">
			
			<div class="row">
				<div class="set-width col-xs-12 col-sm-10 col-md-8 col-lg-4">
					<input type="text" name="tourname" id="tourname"
						placeholder="Tournament Name" /> <br>
				</div>
			</div>
			<div class="row">
				<div class="set-width col-xs-12 col-sm-10 col-md-8 col-lg-4">
					<input class="submitButton" type="submit" value="Add Tournament">
				</div>
			</div>
		</form>
		<script src="<c:url value = "/js/validateinserttour.js"/>"></script>
	</div>
</body>
</html>