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
<title>Modification de l'étudiant <%=etudiant.getNom() %> <%= etudiant.getPrenom() %></title>
</head>
<body>
<div>
	<h3>Bienvenue dans l'outil de modification de l'étudiant <%=etudiant.getNom() %> <%= etudiant.getPrenom() %> (ID <%= etudiant.getId() %>)  </h3>
</div>

<% 			String id = etudiant.getId();
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
<form action = "StudentDetailsServlet" method = "post">
	<div>
		<p>ID de l'étudiant : <%= etudiant.getId() %></p>
	</div>
	<div>
		<label for="name" >Sexe : </label>
		<input type="text" name="Sexe" placeholder= <%= sexe %>>
	</div>
	<div>	
		<label for="name" >Nom : </label>
		<input type="text" name="nom" placeholder= <%= nom %>>
	</div>
	<div>
		<label for="name" >Prénom : </label>
		<input type="text" name="prenom" placeholder= <%= prenom %>>
	</div>
	<div>
		<label for="name" >Date de naissance : </label>
		<input type="text" name="dateNaissance" placeholder= <%= dateNaissance %>>
	</div>
	<div>
		<label for="name" >Serie Bac : </label>
		<input type="text" name="serieBac" placeholder= <%= serieBac %>>
	</div>
	<div>
		<label for="name" >Année Bac : </label>
		<input type="text" name="anneeBac" placeholder= <%= anneeBac %>>
	</div>
	<div>
		<label for="name" >Mention Bac : </label>
		<input type="text" name="mentionBac" placeholder= <%= mentionBac%>>
	</div>
	<div>
		<label for="name" >Diplôme : </label>
		<input type="text" name="diplome" placeholder= <%= diplome %>>
	</div>
	<div>
		<label for="name" >Année du diplôme : </label>
		<input type="text" name="anneeDiplome" placeholder= <%= anneeDiplome %>>
	</div>
	<div>
		<label for="name" >Ville du diplôme : </label>
		<input type="text" name="villeDiplome" placeholder= <%= villeDiplome %>>
	</div>
	<div>
		<label for="name" >Année d'inscription : </label>
		<input type="text" name="inscription" placeholder= <%= inscription %>>
	</div>
	<div>
		<label for="name" >Courriel professionnel : </label>
		<input type="text" name="courrielPro" placeholder= <%= courrielPro %>>
	</div>
	<div>
		<label for="name" >Courriel personnel : </label>
		<input type="text" name="courrielPerso" placeholder= <%= courrielPerso %>>
	</div>	
	<div>
		<input type = "hidden" name="studentModified" value="<%= nom%> <%= prenom%>">
		<input type="submit" name="sauvegarderModifications" value="Sauvegarder les modifications ">
	</div>
</form>
</body>
</html>