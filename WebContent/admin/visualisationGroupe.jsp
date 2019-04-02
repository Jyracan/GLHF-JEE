<%@page import="java.util.List"%>
<%@page import="DataAccessObjects.Groupe"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Visualisation des groupes</title>
<script>
			function loadTable(){
				<%
				List<Groupe> listGroupe = (List<Groupe>)request.getAttribute("listGroupe");
				for (Groupe groupe:listGroupe) {
					
						String idGroupe = groupe.getIdGroupe();
						String nomGroupe = groupe.getNomGroupe();
		                String redacteur = groupe.getRedacteur();
	             %>
					var tableau = document.getElementById("tableau");
	                var elts = ['<%=idGroupe %> ', '<%=nomGroupe %> ','<%=redacteur %>']; // Je stocke les éléments dans un tableau pour remplir les colonnes plus simplement ...
	                var ligne = tableau.insertRow(-1);//on a ajouté une ligne
	                for (i=0;i<3;i++){
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

</head>
<body onload='loadTable()')>
	<h1>Bienvenue dans l'édition de groupe</h1>
	<form action = "CreationGroupe" method = "get">
		<input type="texte" value=" d'un groupe">
	</form>

	<div >Liste des groupes :</div>	
	<table id="tableau" border="1" >
		<thead>
			<tr>
				<th>idGroupe</th>
				<th>nomGroupe</th>
				<th>redacteur</th>
			</tr>
		</thead>
	</table>
</body>
</html>