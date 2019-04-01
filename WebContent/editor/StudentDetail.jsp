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
</head>
<body>
	<p>Détails de l'étudiant : <%= etudiant.getNom() %> <%= etudiant.getPrenom() %></p>
	<table border="1">
		<tr>
			<th>id</th>
			<th>Sexe</th>
			<th>nom</th>
			<th>prenom</th>
			<th>dateNaissance</th>
			<th>serieBac</th>
			<th>anneeBac</th>
			<th>mentionBac</th>
			<th>diplome</th>
			<th>anneeDiplome</th>
			<th>villeDiplome</th>
			<th>inscription</th>
			<th>courrielPro</th>
			<th>courrielPerso</th>
		</tr>
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
	</table>
	<form action="StudentModification" method= "get">
		<input type = "submit" name ="modifier" value = "Modifier l'étudiant">
	</form>
	<form action="StudentVisualizationServlet">
		<input type="submit" name="retour" value = "Annuler et retourner à la visualisation">
	</form>
</body>
</html>