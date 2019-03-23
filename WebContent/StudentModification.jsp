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
<title>Insert title here</title>
</head>
<body>
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
<form>
<label for="name" >id </label>
<input type="text" name="searchText" placeholder= <%= id %>>
<label for="name" >Afficher le détail d'un étudiant : </label>
<input type="text" name="searchText" placeholder="nom [ESPACE] prenom">
</form>
</body>
</html>