<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="nav.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert Match</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/css/insertpage.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/css/button-style.css"/>">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/css/media-query.css"/>">
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
			$("#winner").autocomplete({
				source : player
			});
			$("#loser").autocomplete({
				source : player
			});
			$("#tourname").autocomplete({
				source : tour
			});
		});

	}
</script>
</head>
<body>
	<div class="insert-data">
		<h1>${msg }</h1>
		<form method="post" action="<c:url value = "/InsertMatchServlet"/>"
			class="insert-form" onsubmit="return validateForm()">
			<h2>Insert a Match</h2>
			<br>
			<div class="row">
				<div class="set-width col-xs-12 col-sm-10 col-md-8 col-lg-4">
					<input id="tourname" name="tourname" class="ui-autocomplete-input"
						placeholder="Tournament Name">
				</div>
			</div>
			<br>
			<div class="row">
				<div class="set-width col-xs-12 col-sm-10 col-md-8 col-lg-4">
					<input id="player1" name="player1" class="ui-autocomplete-input"
						placeholder="Player1 Name">
				</div>
			</div>
			<br>
			<div class="row">
				<div class="set-width col-xs-12 col-sm-10 col-md-8 col-lg-4">
					<input id="player2" name="player2" class="ui-autocomplete-input"
						placeholder="Player2 Name">
				</div>
			</div>
			<br>
			<div class="row">
				<div class="set-width col-xs-12 col-sm-10 col-md-8 col-lg-4">
					<input id="winner" name="winner" class="ui-autocomplete-input"
						placeholder="Winner">
				</div>
			</div>
			<br>
			<div class="row">
				<div class="set-width col-xs-12 col-sm-10 col-md-8 col-lg-4">
					<input id="loser" name="loser" class="ui-autocomplete-input"
						placeholder="Loser">
				</div>
			</div>
			<br>
			<div class="row">
				<div class="set-width col-xs-12 col-sm-10 col-md-8 col-lg-4">
					<input type="text" name="status" id="status" placeholder="Status" /><br>
				</div>
			</div>
			<div class="row">
				<div class="set-width col-xs-12 col-sm-10 col-md-8 col-lg-4">
					<input type="text" name="score" id="score" placeholder="Score" />
				</div>
			</div>
			<br>
			<div class="row">
				<div class="set-width col-xs-12 col-sm-10 col-md-8 col-lg-4">
					<input class="submitButton" type="submit" value="Insert Match">
				</div>
			</div>
		</form>
	</div>
	<script src="<c:url value = "/js/validateinsert.js"/>"></script>
</body>
</html>