<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>E-Tournica</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/css/login.css"/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value = "/css/media-query.css"/>">
</head>
<body>
	<h1>
		<img
			src="images/logo.png"
			alt="logo" class="logo-img"> @ E-Tournica
	</h1>
	<h2>
		<i>Your stop for badminton updates</i>
	</h2>
	<div class="login-card">
		<center>
			<h5>${msg }</h5>
		</center>
		<h1>
			<b>Login</b>
		</h1>
		<br>
		<form method="post" action="<c:url value = "/UserValidationServlet"/>"
			onsubmit="return validateForm()">
			<div class="row">
				<div class="set-width col-xs-12 col-sm-10 col-md-8 col-lg-4">
					<input type="text" name="username" placeholder="Username"
						id="username">
				</div>
			</div>
			<div class="row">
				<div class="set-width col-xs-12 col-sm-10 col-md-8 col-lg-4">
					<input type="password" name="password" placeholder="Password"
						id="password">
				</div>
			</div>
			<div class="row">
				<div class="set-width col-xs-12 col-sm-10 col-md-8 col-lg-4">
					<input type="submit" name="login" class="login login-submit"
						value="Login">
				</div>
			</div>
		</form>
	</div>
	<script src="<c:url value = "/js/validate.js"/>"></script>

</body>
</html>