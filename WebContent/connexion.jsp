<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>GLHF</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	</head>
	<body>
		<h1 class="h3 font-weight-normal mt-3 ml-3">Bienvenue ! Veuillez vous connecter !</h1>
		<!--  <form action="ConnexionServlet" method="post">-->
		<div class="container mt-5"><div class="row justify-content-center"><div class="col-4 text-center">
		<form action="Connexion" method="post">
			<div>
				<input type="text" name="login" placeholder="Ton nom !" class="form-control mb-1">
			</div>
			<div>
				<input type="password" name="password" placeholder="Ton mot de passe !" class="form-control mb-1">
			</div>
			<div>
				<input type="submit" value="Connexion" class="btn btn-primary mb-1">
			</div>
		</form>
		<form action="LoginQuestionSecrete" method="get">
			<div>
				<input type="submit" value="J'ai oublié mon mot de passe" class="btn btn-sm btn-outline-primary">
			</div>
		</form>
		</div></div></div>
	</body>
</html>