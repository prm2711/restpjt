<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.zilker.bean.*"%>
<%@ page import="com.zilker.dao.*"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Player Matches List</title>
<link rel="stylesheet" type="text/css" href="<c:url value = "/css/styles.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value = "/css/button-style.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value = "/css/display.css"/>">
<link
	href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css">
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
	<table id="example" class="display">
		<thead>
			<tr>
				<th>Tournament Name</th>
				<th>Player 1</th>
				<th>Player 2</th>
				<th>Winner</th>
				<th>Loser</th>
				<th>Status</th>
				<th>Score</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="m" items="${list}">
				<tr>

					<td>${m.tour}</td>
					<td>${m.play1 }</td>
					<td>${m.play2 }</td>
					<c:choose>
						<c:when test="${m.status == 'Complete'}">
							<td>${m.winner }</td>
							<td>${m.loser }</td>
						</c:when>
						<c:otherwise>
							<td>Nil</td>
							<td>Nil</td>
						</c:otherwise>
					</c:choose>
					<td>${m.status }</td>
					<td>${m.score}</td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<br>
	<br>

	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
	<script>
		$(document).ready(function() {
			$('#example').DataTable();
		});
	</script>
</body>
</html>