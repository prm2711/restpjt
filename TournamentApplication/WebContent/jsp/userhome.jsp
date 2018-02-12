<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.zilker.bean.*"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="navuser.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>User Home</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/css/styles.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/css/button-style.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/css/home.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/css/media-query.css"/>">
</head>
<body>
	<center>
		<h1 class="head">
			Welcome to E-Tournica <img class="shuttle"
				src="images/logoshuttle.png"
				alt="shuttle">
		</h1>
	</center>
	<h2 class="head">Welcome ${username}</h2>
	<div class="updates">
		<img
			src="images/badge.png"
			alt="rank" class="rank-img">
		<p class="update">
			<b>${play.get(0).getPlayerName() } has maximum points and is #1
				!!</b>
		</p>
	</div>
	<p class="heading1">Top 5 Players</p>
	<table>
		<tr>
			<th>Player</th>
			<th>Points</th>
		</tr>
		<c:forEach var="p" begin="0" end="4" items="${play}">
			<tr>
				<td>${p.getPlayerName()}</td>
				<td>${p.getNewPoints()}</td>

			</tr>
		</c:forEach>
	</table>
	<div class="event-list">
		<p class="heading">Tournaments</p>
		<div class="events">
			<img
				src="images/london.jpg"
				alt="shuttle" class="event-img"> <br>
			<p class="text">London Open</p>
		</div>
		<div class="events">
			<img
				src="images/asia.png"
				alt="shuttle" class="event-img"> <br>
			<p class="text">Asian Open</p>
		</div>
		<div class="events">
			<img src="images/us.png"
				alt="shuttle" class="event-img"> <br>
			<p class="text">US Open</p>
		</div>
		<p class="text-more">And More...</p>
	</div>
</body>
</html>