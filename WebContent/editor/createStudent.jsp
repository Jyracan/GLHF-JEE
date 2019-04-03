<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List,DataAccessObjects.Etudiant"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Création d'un étudiant</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<div class="mt-3 ml-3 mb-4">
		<form action="StudentVisualizationServlet">
			<input type="submit" name="retour" value = "Retourner à la liste des étudiants" class="btn btn-outline-secondary btn-sm">
		</form>
	</div>
	<h3 class="h5 font-weight-normal ml-3">Bienvenue dans l'outil de création d'un étudiant</h3>
	<p class="text-danger ml-3"> Les champs avec (*) sont obligatoires </p>
	
<form action = "StudentCreation" method = "post" class="ml-3">
	<div class="container-fluid">
	<div class="row mb-1">
		<div class="col-1">ID (*) :</div>
		<div class="col-5"><input type="text" name="id" placeholder="9 characters (figures and letters)" class="form-control"></div>
	</div>
	<div class="row mb-1">
		<div class="col-1">Sexe : </div>
		<div class="col-5"><input type="text" name="sexe" placeholder="M/F" class="form-control mb-1"></div>
	</div>
	<div class="row mb-1">	
		<div class="col-1">Nom (*) : </div>
		<div class="col-5"><input type="text" name="nom" placeholder="nom" class="form-control mb-1"></div>
	</div>
	<div class="row mb-1">
		<div class="col-1">Prénom (*) : </div>
		<div class="col-5"><input type="text" name="prenom" placeholder="prenom" class="form-control mb-1"></div>
	</div>
	<div class="row mb-1">
		<div class="col-1">Date de naissance :</div>
		<div class="col-5"><input type="text" name="dateNaissance" placeholder="M/DD/YYYY" class="form-control mb-1"></div>
	</div>
	<div class="row mb-1">
		<div class="col-1">Serie Bac : </div>
		<div class="col-5"><input type="text" name="serieBac" placeholder="serieBac" class="form-control mb-1"></div>
	</div>
	<div class="row mb-1">
		<div class="col-1">Année Bac :</div>
		<div class="col-5"><input type="text" name="anneeBac" placeholder="YYYY" class="form-control mb-1"></div>
	</div>
	<div class="row mb-1">
		<div class="col-1">Mention Bac : </div>
		<div class="col-5"><input type="text" name="mentionBac" placeholder="mentionBac" class="form-control mb-1"></div>
	</div>
	<div class="row mb-1">
		<div class="col-1">Diplôme : </div>
		<div class="col-5"><input type="text" name="diplome" placeholder="diplome" class="form-control mb-1"></div>
	</div>
	<div class="row mb-1">
		<div class="col-1">Année du diplôme :</div>
		<div class="col-5"><input type="text" name="anneeDiplome" placeholder="YYYY" class="form-control mb-1"></div>
	</div>
	<div class="row mb-1">
		<div class="col-1">Ville du diplôme : </div>
		<div class="col-5"><input type="text" name="villeDiplome" placeholder="villeDiplome" class="form-control mb-1"></div>
	</div>
	<div class="row mb-1">
		<div class="col-1">Année d'inscription : </div>
		<div class="col-5"><input type="text" name="inscription" placeholder="YYYY" class="form-control mb-1"></div>
	</div>
	<div class="row mb-1">
		<div class="col-1">Courriel professionnel : </div>
		<div class="col-5"><input type="text" name="courrielPro" placeholder="*@*.*" class="form-control mb-1"></div>
	</div>
	<div class="row mb-2">
		<div class="col-1">Courriel personnel : </div>
		<div class="col-5"><input type="text" name="courrielPerso" placeholder="*@*.*" class="form-control mb-1"></div>
	</div>	
	<div class="row mb-3">
		<input type="submit" name="creerEtudiant" value="Créer l'étudiant" class="btn btn-success">
	</div>
	</div>
</form>
</body>
</html>