<%@page import="DataAccessObjects.Groupe"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
    
<%@page import="java.util.ArrayList,DataAccessObjects.Etudiant,DataAccessObjects.Groupe"%>
<%Groupe groupe = (Groupe)request.getAttribute("GroupeDetail");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script>
	function loadTable(){
		<%
		ArrayList<Etudiant> listStudent = (ArrayList<Etudiant>)request.getAttribute("listStudent");
		String id = "";
		String sexe = "";
        String nom = "";
        String prenom = "";
		if (listStudent != null){
			for (Etudiant etudiant:listStudent) {
				id = etudiant.getId();
				sexe = etudiant.getSexe();
                nom = etudiant.getNom();
                prenom = etudiant.getPrenom();
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
               
			<%}
		}%>
	}
	
	function clear(){
		var tableau = document.getElementById("tableau");
		longueur = tableau.rows.length;
		for (i=1;i<longueur;i++){
			tableau.deleteRow(-1);
		}
	}
</script>

<title>Détails du groupe <%=groupe.getNomGroupe() %></title>
</head>
<body onload="loadTable()">
	<h2>Détails du groupe <%=groupe.getNomGroupe() %></h2>
	<table border="1">
		<tr>
			<th>idGroupe</th>
			<th>nomGroupe</th>
			<th>redacteur</th>
		</tr>
		<% 	String idGroupe = groupe.getIdGroupe();
			String nomGroupe = groupe.getNomGroupe();
            String redacteur = groupe.getRedacteur();
       %>
       <tr onclick="this.style.cursor='default';" >
			<td><%=idGroupe %></td>
			<td><%=nomGroupe %></td>
			<td><%=redacteur %></td>
		</tr>
	</table>
	
	<div>
		<form action="GroupeDetails" method="post">
		<div>
			<input type="text" name="idGroupe" placeholder="Id du groupe">
			<input type ="submit" name="ajtGroupe" value = "Ajouter le groupe">
			<input type ="submit" name="supprGroupe" value = "Supprimer le groupe">
		</div>
		</form>
		<h3>Liste des groupes</h3>
		<table>
			<thead class="thead-dark">
				<tr>
					<th>id</th>
					<th>Nom</th>
					<th>Rédacteur</th>
				</tr>
			</thead>
			<tbody>
			<%
				ArrayList<Groupe> groupes = (ArrayList<Groupe>) request.getAttribute("listGroupe");
				for(Groupe grp : groupes) {
			%>
				<tr>
					<td><%= grp.getIdGroupe() %></td>
					<td><%= grp.getNomGroupe() %></td>
					<td><%= grp.getRedacteur()%></td>
				</tr>
			<% } %>
			</tbody>
		</table>
		<h3>Liste des groupes fils</h3>
		<table>
			<thead class="thead-dark">
				<tr>
					<th>id</th>
					<th>Nom</th>
					<th>Rédacteur</th>
				</tr>
			</thead>
			<tbody>
			<%
				ArrayList<Groupe> fils = (ArrayList<Groupe>) request.getAttribute("fils");
				for(Groupe grp : fils) {
			%>
				<tr>
					<td><%= grp.getIdGroupe() %></td>
					<td><%= grp.getNomGroupe() %></td>
					<td><%= grp.getRedacteur()%></td>
				</tr>
			<% } %>
			</tbody>
		</table>
	</div>

	<h2>Étudiants composant le groupe <%=groupe.getNomGroupe() %></h2>
	
	
	<form action="GroupeDetails" method="post">
		<div>
			<input type="text" name="idEtudiant" placeholder="Id de l'Étudiant">
			<input type ="submit" name="ajtEtudiant" value = "Ajouter l'Étudiant">
			<input type ="submit" name="supprEtudiant" value = "Supprimer l'Étudiant">
		</div>
	</form>
	
	<table id="tableau" border="1" >
		<thead>
			<tr>
				<th>id</th>
				<th>Sexe</th>
				<th>nom</th>
				<th>prenom</th>
			</tr>
		</thead>
	</table>
		
	<form action="VisualisationGroupeServlet">
		<input type="submit" name="retour" value = "Retourner à la liste des groupes">
	</form>
</body>
</html>