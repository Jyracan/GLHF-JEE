<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List,DataAccessObjects.Etudiant"%>



<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Liste des étudiants</title>
		<script>
		    console.log('test');
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
			function reload(){
				var tableau = document.getElementById("tableau");
				// TODO : Voir comment vider la table plus proprement
				clear();
				loadTable();
			}
			function clear(){
				var tableau = document.getElementById("tableau");
				longueur = tableau.rows.length;
				for (i=1;i<longueur;i++){
					tableau.deleteRow(-1);
				}
			}
		
		</script>
	</head>
	<body onload="loadTable()">
		<div>Bienvenue dans l'interface de visualisation des étudiants</div>
		<form action="StudentDetails" method="post">
				<div>
					<label for="name" >Afficher le détail d'un étudiant : </label>
					<input type="text" name="searchText" placeholder="nom [ESPACE] prenom">
					<input type = "submit" value = "Chercher">
				</div>
		</form>	
		<form action="StudentDeletion">
			<input type = "submit" name ="supprimer" value = "Supprimer l'étudiant">
		</form>
		<form action="StudentCreation">
			<input type = "submit" name ="creer" value = "Créer l'étudiant">
		</form>
		<button id="reload" onClick="reload()">Rechargement du tableau niveau ObiWan !</button>
		<div >Liste des étudiants :</div>	
		<table id="tableau" border="1" ">
			<thead>
				<tr>
					<th>id</th>
					<th>Sexe</th>
					<th>nom</th>
					<th>prenom</th>
				</tr>
			</thead>
		</table>
		
	</body>
</html>