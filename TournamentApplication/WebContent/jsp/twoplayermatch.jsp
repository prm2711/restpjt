<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Players Matches</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/css/styles.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/css/button-style.css"/>">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/css/insertpage.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/css/media-query.css"/>">
</head>
<body>
	<%
		if (session.getAttribute("name").equals("admin")) {
	%>
	<%@ include file="nav.jsp"%>
	<%
		} else if (session.getAttribute("name").equals("user")) {
	%><%@ include file="navuser.jsp"%>
	<%
		}
	%>
	<div class="insert-data" id="container">
	<h1>${msg }</h1>
	<form method="post" action="<c:url value = "/TwoPlayerMatchServlet"/>"
		class="insert-form" onsubmit="return validateForm()">
		<h2>View Matches between Players</h2>
		<div class="row">
			<div class="set-width col-xs-12 col-sm-10 col-md-8 col-lg-4">
				<input id="player1" name="player1" class="ui-autocomplete-input"
					placeholder="Player1 Name"><br>
			</div>
		</div>
		<div class="row">
			<div class="set-width col-xs-12 col-sm-10 col-md-8 col-lg-4">
				<input id="player2" name="player2" class="ui-autocomplete-input"
					placeholder="Player2 Name"> <br>
			</div>
		</div>
		<div class="row">
			<div class="set-width col-xs-12 col-sm-10 col-md-8 col-lg-4">
				<input id="tour" name="tour" class="ui-autocomplete-input"
					placeholder="Tournament Name"> <br>
			</div>
		</div>
		<div class="row">
			<div class="set-width col-xs-12 col-sm-10 col-md-8 col-lg-4">
				<input class="submitButton" type="submit" value="View Results"><br>
			</div>
		</div>
	</form>
	</div>
	<script>
	window.onload = function() {
		$(function call() {
			var player = ${player};
			var tour = ${tour};
			$("#player1").autocomplete({
				source : player
			});
			$("#player2").autocomplete({
				source : player
			});
			$("#tour").autocomplete({
				source : tour
			});
		});

	}
</script>
	<script src="<c:url value = "/js/validateplayers.js"/>"></script>
</body>
</html>