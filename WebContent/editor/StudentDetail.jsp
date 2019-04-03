<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
    
<%@page import="java.util.List,DataAccessObjects.Etudiant"%>
<%
 Etudiant etudiant = (Etudiant)request.getAttribute("StudentDetail");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Détails de l'étudiant <%= etudiant.getNom() %> <%= etudiant.getPrenom() %></title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<div class="mt-3 ml-3 mb-4">
		<form action="StudentVisualizationServlet">
			<input type="submit" name="retour" value = "Retourner à la liste des étudiants" class="btn btn-outline-secondary btn-sm">
		</form>
	</div>
	<h1 class="h5 font-weight-normal ml-3">Détails de l'étudiant : <%= etudiant.getNom() %> <%= etudiant.getPrenom() %></h1>
	<div class="p-3">
	<table class="table">
		<thead class="thead-dark">
		<tr>
			<th>id</th>
			<th>Sexe</th>
			<th>Nom</th>
			<th>Prénom</th>
			<th>Date de naissance</th>
			<th>Série Bac</th>
			<th>Année Bac</th>
			<th>Mention Bac</th>
			<th>Diplome</th>
			<th>Année diplome</th>
			<th>Ville diplome</th>
			<th>Inscription</th>
			<th>Courriel pro</th>
			<th>Courriel perso</th>
		</tr>
		</thead>
		<% 	String id = etudiant.getId();
			String sexe = etudiant.getSexe();
            String nom = etudiant.getNom();
            String prenom = etudiant.getPrenom();
            String dateNaissance = etudiant.getDateNaissance();
            String serieBac = etudiant.getSerieBac();
            int anneeBac = etudiant.getAnneeBac();
            String mentionBac = etudiant.getMentionBac();
            String diplome = etudiant.getDiplome();
            int anneeDiplome = etudiant.getAnneeDiplome();
            String villeDiplome = etudiant.getVilleDiplome();
            int inscription = etudiant.getInscription();
            String courrielPro = etudiant.getCourrielPro();
            String courrielPerso = etudiant.getCourrielPerso();
       %>
       <tbody>
       <tr onclick="this.style.cursor='default';" >
			<td><%=id %></td>
			<td><%=sexe %></td>
			<td><%=nom %></td>
			<td><%=prenom %></td>
			<td><%=dateNaissance %></td>
			<td><%=serieBac %></td>
			<td><%=anneeBac %></td>
			<td><%=mentionBac %></td>
			<td><%=diplome %></td>
			<td><%=anneeDiplome %></td>
			<td><%=villeDiplome %></td>
			<td><%=inscription %></td>
			<td><%=courrielPro %></td>
			<td><%=courrielPerso %></td>
		</tr>
		</tbody>
	</table>
	</div>
	<form action="StudentModification" method= "get">
		<input type = "submit" name ="modifier" value = "Modifier l'étudiant" class="btn btn-primary ml-3">
	</form>
</body>
</html>