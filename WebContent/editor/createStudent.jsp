<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List,DataAccessObjects.Etudiant"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Création d'un étudiant</title>
</head>
<body>
<div>
	<h3>Bienvenue dans l'outil de création d'un étudiant</h3>
</div>
<p> Les champs avec (*) sont obligatoire </p>
<form action = "StudentCreation" method = "post">
	<div>
		<label for="id" >ID (*) : </label>
		<input type="text" name="id" placeholder="9 characters (figures and letters)" >
	</div>
	<div>
		<label for="name" >Sexe : </label>
		<input type="text" name="sexe" placeholder="M/F" >
	</div>
	<div>	
		<label for="name" >Nom (*) : </label>
		<input type="text" name="nom" placeholder="nom">
	</div>
	<div>
		<label for="name" >Prénom (*) : </label>
		<input type="text" name="prenom" placeholder="prenom">
	</div>
	<div>
		<label for="name" >Date de naissance : </label>
		<input type="text" name="dateNaissance" placeholder="M/DD/YYYY">
	</div>
	<div>
		<label for="name" >Serie Bac : </label>
		<input type="text" name="serieBac" placeholder="serieBac">
	</div>
	<div>
		<label for="name" >Année Bac : </label>
		<input type="text" name="anneeBac" placeholder="YYYY">
	</div>
	<div>
		<label for="name" >Mention Bac : </label>
		<input type="text" name="mentionBac" placeholder="mentionBac">
	</div>
	<div>
		<label for="name" >Diplôme : </label>
		<input type="text" name="diplome" placeholder="diplome">
	</div>
	<div>
		<label for="name" >Année du diplôme : </label>
		<input type="text" name="anneeDiplome" placeholder="YYYY">
	</div>
	<div>
		<label for="name" >Ville du diplôme : </label>
		<input type="text" name="villeDiplome" placeholder="villeDiplome">
	</div>
	<div>
		<label for="name" >Année d'inscription : </label>
		<input type="text" name="inscription" placeholder="YYYY">
	</div>
	<div>
		<label for="name" >Courriel professionnel : </label>
		<input type="text" name="courrielPro" placeholder="*@*.*">
	</div>
	<div>
		<label for="name" >Courriel personnel : </label>
		<input type="text" name="courrielPerso" placeholder="*@*.*">
	</div>	
	<div>
		<input type="submit" name="creerEtudiant" value="Créer l'étudiant">
	</div>
</form>
</body>
</html>