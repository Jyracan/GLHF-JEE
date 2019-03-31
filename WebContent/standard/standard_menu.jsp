<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GLHF-Menu</title>
</head>
<body>
	<div>Bienvenue !</div>
	<form action = "StudentVisualizationServlet" method = "post">
		<input type="submit" value="visualisation des étudiants">
	</form>
	<form action="">
		<input type="submit" value="visualisation des groupes">
	</form>
	<form action="/ProjetJEE/Deconnexion">
		<input type="submit" value="deconnexion">
	</form>
</body>
</html>