<%@page import="DataAccessObjects.Groupe"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
    
<%@page import="java.util.List,DataAccessObjects.Etudiant"%>
<%
 Groupe groupe = (Groupe)request.getAttribute("GroupeDetail");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Détails du groupe <%= groupe.getNomGroupe() %></title>
</head>
<body>
	<p>Détails du groupe <%= groupe.getNomGroupe() %></p>
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
	<form action="GroupeModification" method= "get">
		<input type = "submit" name ="modifier" value = "Modifier l'étudiant">
	</form>
	<form action="VisualisationGroupeServlet">
		<input type="submit" name="retour" value = "Annuler et retourner à la visualisation">
	</form>
</body>
</html>