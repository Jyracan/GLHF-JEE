<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GLHF-Menu</title>
</head>
<body>
	<div>Bienvenue!</div>
	<form action = "StudentVisualizationServlet" method = "post">
		<input type="submit" value="visualisation des étudiants">
	</form>
	<form action="">
		<input type="submit" value="visualisation des groupes">
	</form>
	<form action="UsersManagement">
		<input type="submit" value="Gestion des utilisateurs">
	</form>
	<form action="/ProjetJEE/Deconnexion">
		<input type="submit" value="deconnexion">
	</form>
	<form action="GestionGroupe" method="get">
		<input type="submit" value="gestion de groupe">
	</form>
</body>
</html>