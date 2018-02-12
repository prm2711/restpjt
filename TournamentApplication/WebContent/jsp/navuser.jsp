
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/css/nav.css"/>">
	<nav class="menu">
		<ul class="active">

			<li>
				<%
					if (session.getAttribute("name").equals("admin")) {
				%> <a href="<c:url value = "/jsp/home.jsp"/>" class="current">Home</a>
				<%
					} else if (session.getAttribute("name").equals("user")) {
				%> <a href="<c:url value = "/jsp/userhome.jsp"/>" class="current">Home</a>
				<%
					}
				%>
			</li>

			<li><a href="<c:url value = "/RetrievePlayerServlet"/>">Retrieve
					Players</a></li>
			<li>
				<div class="dropdown">
					<div class="dropbtn">View Match</div>
					<div class="dropdown-content">
						<a href="<c:url value = "/RetrieveMatchServlet"/>">All Matches</a>
						<a href="<c:url value = "/ListServlet?link=PlayervsPlayer"/>">Player
							vs Player</a> <a
							href="<c:url value = "/ListServlet?link=PlayerinTournament"/>">Player
							in Tournament</a>
					</div>
				</div>
			</li>
			<li><a href="<c:url value = "/jsp/playercountry.jsp"/>">View
					Player by Country</a></li>
			<li><a href="<c:url value = "/LogoutServlet"/>">Logout</a></li>

		</ul>
		<a class="toggle-nav" href="#">&#9776;</a>
	</nav>
