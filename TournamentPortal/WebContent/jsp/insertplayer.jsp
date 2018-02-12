<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="nav.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add Player</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/css/insertpage.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/css/button-style.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/css/media-query.css"/>">
</head>
<body>
	<div class="insert-data" id="container">
		<h1>${msg }</h1>
		<form method="post" action="<c:url value = "/InsertPlayerServlet"/>"
			class="insert-form" onsubmit="return validateForm()">
			<h2>Add Player</h2>
			<div class="row">
				<div class="set-width col-xs-12 col-sm-10 col-md-8 col-lg-4">
					<input type="text" name="player" id="player"
						placeholder="Player Name" />
				</div>
			</div>
			<br>
			<div class="row">
				<div class="set-width col-xs-12 col-sm-10 col-md-8 col-lg-4">
					<input type="text" name="country" id="country"
						placeholder="Country" /><br>
				</div>
			</div>
			<div class="row">
				<div class="set-width col-xs-12 col-sm-10 col-md-8 col-lg-4">
					<input type="text" name="origpoints" id="origpoints"
						placeholder="Original Points" /><br>
				</div>
			</div>
			<div class="row">
				<div class="set-width col-xs-12 col-sm-10 col-md-8 col-lg-4">
					<input type="text" name="newpoints" id="newpoints"
						placeholder="New Points" /><br>
				</div>
			</div>
			<div class="row">
				<div class="set-width col-xs-12 col-sm-10 col-md-8 col-lg-4">
					<input type="text" name="numbermatch" id="numbermatch"
						placeholder="Number of Matches" /><br>
				</div>
			</div>
			<div class="row">
				<div class="set-width col-xs-12 col-sm-10 col-md-8 col-lg-4">
					<input type="text" name="won" id="won" placeholder="Matches Won" /><br>
				</div>
			</div>
			<div class="row">
				<div class="set-width col-xs-12 col-sm-10 col-md-8 col-lg-4">
					<input type="text" name="lost" id="lost" placeholder="Matches Lost" /><br>
				</div>
			</div>
			<div class="row">
				<div class="set-width col-xs-12 col-sm-10 col-md-8 col-lg-4">
					<input type="text" name="draw" id="draw" placeholder="Matches Draw" /><br>
				</div>
			</div>
			<div class="row">
				<div class="set-width col-xs-12 col-sm-10 col-md-8 col-lg-4">
					<input class="submitButton" type="submit" value="Add Player">
				</div>
			</div>
		</form>
	</div>
	<script src="<c:url value = "/js/validateinsertplayer.js"/>"></script>
</body>
</html>