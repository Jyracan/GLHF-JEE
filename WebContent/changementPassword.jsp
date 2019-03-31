<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Changement de mot de passe</title>
</head>
<body>
	<div>Veuillez modifier votre mot de passe</div>
	<form action="ChangementPassword" method="post">
			<div>
				<input type="password" name="psw" placeholder="quel est le nouveau mot de passe">
			</div>
			<div>
				<input type="password" name="pswConfirmation" placeholder="confirmez le nouveau mot de passe">
			</div>
			<div>
				<input type="submit" value="Valider le nouveau mot de passe">
			</div>
	</form>
</body>
</html>