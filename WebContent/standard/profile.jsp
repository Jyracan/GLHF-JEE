<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="sessionManagement.User"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
</head>
<body>
	<% User usr = (User)request.getAttribute("user"); %>
	<form action="Menu">
		<input type="submit" name="retour" value = "Retourner au menu">
	</form>
	<div>Bienvenu sur votre profile <%= usr.getLogin() %></div>
	<form action="Profile" method="post">
		<input type="text" name="password" value=<%= usr.getPassword() %>>
		<input type="text" name="question" value="<%= usr.getQuestion() %>">
		<input type="text" name="answer" value=<%= usr.getAnswer() %>>
		<input type = "submit" value = "Enregistrer">
	</form>
</body>
</html>