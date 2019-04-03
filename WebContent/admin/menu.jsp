<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GLHF-Menu</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<form action="/ProjetJEE/Deconnexion">
		<input type="submit" value="Déconnexion" class="btn btn-sm btn-outline-secondary mt-3 ml-3">
	</form>
	<h1 class="h4 font-weight-normal mt-3 mb-5 text-center">Bonjour, que puis-je faire pour vous ?</h1>
	<div class="container">
		<div class="row justify-content-center mb-5">
			<div class="col-5 mr-4 text-center bg-info rounded-pill p-2">
				<form action="UsersManagement">
					<input type="submit" value="Modifier des droits utilisateurs" class="btn btn-lg btn-light">
				</form>
			</div>
			<div class="col-5 text-center bg-info rounded-pill p-2">
				<form action = "StudentVisualizationServlet" method = "post">
					<input type="submit" value="Voir la liste des étudiants" class="btn btn-lg btn-light">
				</form>
			</div>
		</div>
		<div class="row justify-content-center mb-5">
			<div class="col-5 mr-4 text-center bg-info rounded-pill p-2">
				<form action="VisualisationGroupeServlet">
					<input type="submit" value="Voir la liste des groupes" class="btn btn-lg btn-light">
				</form>
			</div>
		</div>
	</div>
</body>
</html>