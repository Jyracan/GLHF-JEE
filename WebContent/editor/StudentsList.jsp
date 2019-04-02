<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List,DataAccessObjects.Etudiant"%>



<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Liste des étudiants</title>
		<script>
			function loadTable(){
				<%
				List<Etudiant> listStudent = (List<Etudiant>)request.getAttribute("listStudent");
				for (Etudiant etudiant:listStudent) {
					
						String id = etudiant.getId();
						String sexe = etudiant.getSexe();
		                String nom = etudiant.getNom();
		                String prenom = etudiant.getPrenom();
	             %>
					var tableau = document.getElementById("tableau");
	                var elts = ['<%=id %> ', '<%=sexe %> ','<%=nom %>','<%=prenom %>']; // Je stocke les éléments dans un tableau pour remplir les colonnes plus simplement ...
	                var ligne = tableau.insertRow(-1);//on a ajouté une ligne
	                for (i=0;i<4;i++){
	                	// On remplit chaque ligne
	                	colonne =ligne.insertCell(i);
	                	colonne.innerHTML += elts[i];
	                	console.log("Insertion de " + elts[i]);
	                }
	                
				<%}%>
			}
			
			function clear(){
				var tableau = document.getElementById("tableau");
				longueur = tableau.rows.length;
				for (i=1;i<longueur;i++){
					tableau.deleteRow(-1);
				}
			}
		
		</script>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	</head>
	<body onload="loadTable()">
		<div class="container-fluid mt-3 ml-3">
			<div class="row mb-4">
				<form action="Menu"><input type="submit" name="retour" value = "Retourner au menu" class="btn btn-sm btn-outline-secondary"></form>
			</div>
			<div class="row mb-3 ml-4">				
				<form action="StudentCreation">
					<input type = "submit" name ="creer" value = "Ajouter un nouvel étudiant" class="btn btn-primary">
				</form>
			</div>
			<div class="row align-items-center">
				<h1 class="h5 font-weight-normal mr-3">Entrez le nom d'un étudiant :</h1>
				<form action="Redirection" method="post">
					<input type="text" name="searchText" placeholder="nom [ESPACE] prenom" class="form-control mb-1">
					<input type = "submit" name="chercher" value = "Chercher l'étudiant" class="btn btn-primary">
					<input type = "submit" name ="supprimer" value = "Supprimer l'étudiant" class="btn btn-danger">
				</form>
			</div>
			<div class="row justify-content-center mt-5">
				<h1 class="h5 font-weight-normal">Liste des étudiants :</h1>
			</div>
			<div class="row justify-content-center mb-2">
				<form action = "StudentVisualizationServlet" method = "get">
					<input type = "submit" name ="refresh" value = "Rechargement Niveau Ewok" class="btn btn-secondary">
				</form>
			</div>
			<div class="row justify-content-center">
			<div class="col-6">
				<table id="tableau" class="table">
					<thead class="thead-dark">
						<tr>
							<th>id</th>
							<th>Sexe</th>
							<th>Nom</th>
							<th>Prénom</th>
						</tr>
					</thead>
				</table>
			</div>
			</div>
		</div>
	</body>
</html>