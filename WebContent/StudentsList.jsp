<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List,DataAccessObjects.Etudiant"%>

<%
List<Etudiant> listStudent = (List<Etudiant>)request.getAttribute("listStudent");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des étudiants</title>
</head>
<body>
	<div>Bienvenue dans l'interface de visualisation des étudiants</div>
	<form action="StudentDetailsServlet" method="post">
			<div>
				<label for="name" >Afficher le détail d'un étudiant : </label>
				<input type="text" name="searchText" placeholder="nom [ESPACE] prenom">
				<input type = "submit" value = "Chercher">
			</div>
	</form>	
	<div >Liste des étudiants :</div>	
	<table border="1">
		<tr>
			<th>id</th>
			<th>Sexe</th>
			<th>nom</th>
			<th>prenom</th>
		</tr>
		<%
			for (Etudiant etudiant:listStudent) {
				
				String id = etudiant.getId();
				String sexe = etudiant.getSexe();
                String nom = etudiant.getNom();
                String prenom = etudiant.getPrenom();
		%>
		<tr onclick="this.style.cursor='default';" >
			<td><%=id %></td>
			<td><%=sexe %></td>
			<td><%=nom %></td>
			<td><%=prenom %></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>