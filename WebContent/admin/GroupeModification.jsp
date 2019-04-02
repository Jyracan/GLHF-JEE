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
<title>Modification du groupe n° <%=etudiant.getNom() %> <%= etudiant.getPrenom() %></title>
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
            String anneeBac = Integer.toString(etudiant.getAnneeBac());
            String mentionBac = etudiant.getMentionBac();
            String diplome = etudiant.getDiplome();
            String anneeDiplome = Integer.toString(etudiant.getAnneeDiplome());
            String villeDiplome = etudiant.getVilleDiplome();
            String inscription = Integer.toString(etudiant.getInscription());
            String courrielPro = etudiant.getCourrielPro();
            String courrielPerso = etudiant.getCourrielPerso();
       %>
<form action = "StudentModification" method = "post">
	<div>
		<p>ID de l'étudiant : <%= etudiant.getId() %></p>
	</div>
	<div>
		<label for="name" >Sexe : </label>
		<input type="text" name="sexe" value= <%= sexe %>>
	</div>
	<div>	
		<label for="name" >Nom : </label>
		<input type="text" name="nom" value= <%= nom %>>
	</div>
	<div>
		<label for="name" >Prénom : </label>
		<input type="text" name="prenom" value= <%= prenom %>>
	</div>
	<div>
		<label for="name" >Date de naissance : </label>
		<input type="text" name="dateNaissance" value= <%= dateNaissance %>>
	</div>
	<div>
		<label for="name" >Serie Bac : </label>
		<input type="text" name="serieBac" value= <%= serieBac %>>
	</div>
	<div>
		<label for="name" >Année Bac : </label>
		<input type="text" name="anneeBac" value= <%= anneeBac %>>
	</div>
	<div>
		<label for="name" >Mention Bac : </label>
		<input type="text" name="mentionBac" value= <%= mentionBac%>>
	</div>
	<div>
		<label for="name" >Diplôme : </label>
		<input type="text" name="diplome" value= <%= diplome %>>
	</div>
	<div>
		<label for="name" >Année du diplôme : </label>
		<input type="text" name="anneeDiplome" value= <%= anneeDiplome %>>
	</div>
	<div>
		<label for="name" >Ville du diplôme : </label>
		<input type="text" name="villeDiplome" value= <%= villeDiplome %>>
	</div>
	<div>
		<label for="name" >Année d'inscription : </label>
		<input type="text" name="inscription" value= <%= inscription %>>
	</div>
	<div>
		<label for="name" >Courriel professionnel : </label>
		<input type="text" name="courrielPro" value= <%= courrielPro %>>
	</div>
	<div>
		<label for="name" >Courriel personnel : </label>
		<input type="text" name="courrielPerso" value= <%= courrielPerso %>>
	</div>	
	<div>
		<input type="submit" name="sauvegarderModifications" value="Sauvegarder les modifications ">
	</div>
</form>
<form action="StudentVisualizationServlet">
	<input type="submit" name="retour" value = "Annuler et retourner à la visualisation">
</form>
</body>
</html>