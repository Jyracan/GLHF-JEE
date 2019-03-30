<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>GLHF</title>
	</head>
	<body>
		<div>Bienvenue ! Veuillez vous connecter !</div>
		<!--  <form action="ConnexionServlet" method="post">-->
		<form action="Connexion" method="post">
			<div>
				<input type="text" name="login" placeholder="Ton nom !">
			</div>
			<div>
				<input type="password" name="password" placeholder="Ton mot de passe !">
			</div>
			<div>
				<input type="submit" value="Connexion">
			</div>
		</form>
		<form action="QuestionSecrete" method="post">
			<div>
				<input type="submit" value="J'ai oublié mon mot de passe">
			</div>
		</form>
		
	</body>
</html>