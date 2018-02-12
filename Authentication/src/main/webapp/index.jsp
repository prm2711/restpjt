<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<body>
<h1>Login</h1>
<h2>${msg }</h2>
    <form action="LoginServlet" method="post">
    <input type="text" name="username"><br>
    <input type="password" name="password"><br>
    <input type="submit" value="Login">
    
    </form>
</body>
</html>
