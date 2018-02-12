<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Players List</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/css/styles.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/css/button-style.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/css/display.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/css/media-query.css"/>">
<link
	href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<%@ page import="com.zilker.bean.*"%>
	<%@ page import="java.util.ArrayList"%>
	<table id="example" class="display">
		<thead>
			<tr>
				<th>Player Name</th>
				<th>Country</th>
				<th>Original Points</th>
				<th>New Points</th>
				<th>Number of Matches</th>
				<th>Won</th>
				<th>Lost</th>
				<th>Draw</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="p" items="${play}">
				<tr>
					<td>${p.getPlayerName()}</td>
					<td>${p.getCountry()}</td>
					<td>${p.getOrigPoints()}</td>
					<td>${p.getNewPoints()}</td>
					<td>${p.getNumberMatch()}</td>
					<td>${p.getWon()}</td>
					<td>${p.getLost()}</td>
					<td>${p.getDraw()}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
	<script>
		$(document).ready(function() {
			$('#example').DataTable({
				"order" : [ 3, 'desc' ]
			});
		});
	</script>
</body>
</html>