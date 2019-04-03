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
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<form action="StudentVisualizationServlet">
	<input type="submit" name="retour" value = "Retourner à la liste des étudiants" class="btn btn-outline-secondary btn-sm mt-3 ml-3 mb-4">
</form>
<h3 class="h5 font-weight-normal ml-3 mb-4">Bienvenue dans l'outil de modification de l'étudiant <%=etudiant.getNom() %> <%= etudiant.getPrenom() %> (ID <%= etudiant.getId() %>) </h3>

<% 			
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
<form action = "StudentModification" method = "post" class="ml-3">
	<div class="container-fluid">
	<div class="row mb-1">
		<div class="col-1">Sexe : </div>
		<div class="col-5"><input type="text" name="sexe" value= <%= sexe %> class="form-control mb-1"></div>
	</div>
	<div class="row mb-1">	
		<div class="col-1">Nom (*) : </div>
		<div class="col-5"><input type="text" name="nom" value=<%= nom %> class="form-control mb-1"></div>
	</div>
	<div class="row mb-1">
		<div class="col-1">Prénom (*) : </div>
		<div class="col-5"><input type="text" name="prenom" value=<%= prenom %> class="form-control mb-1"></div>
	</div>
	<div class="row mb-1">
		<div class="col-1">Date de naissance :</div>
		<div class="col-5"><input type="text" name="dateNaissance" value=<%= dateNaissance %> class="form-control mb-1"></div>
	</div>
	<div class="row mb-1">
		<div class="col-1">Serie Bac : </div>
		<div class="col-5"><input type="text" name="serieBac" value=<%= serieBac %> class="form-control mb-1"></div>
	</div>
	<div class="row mb-1">
		<div class="col-1">Année Bac :</div>
		<div class="col-5"><input type="text" name="anneeBac" value=<%= anneeBac %> class="form-control mb-1"></div>
	</div>
	<div class="row mb-1">
		<div class="col-1">Mention Bac : </div>
		<div class="col-5"><input type="text" name="mentionBac" value=<%= mentionBac %> class="form-control mb-1"></div>
	</div>
	<div class="row mb-1">
		<div class="col-1">Diplôme : </div>
		<div class="col-5"><input type="text" name="diplome" value=<%= diplome %> class="form-control mb-1"></div>
	</div>
	<div class="row mb-1">
		<div class="col-1">Année du diplôme :</div>
		<div class="col-5"><input type="text" name="anneeDiplome" value=<%= anneeDiplome %> class="form-control mb-1"></div>
	</div>
	<div class="row mb-1">
		<div class="col-1">Ville du diplôme : </div>
		<div class="col-5"><input type="text" name="villeDiplome" value=<%= villeDiplome %> class="form-control mb-1"></div>
	</div>
	<div class="row mb-1">
		<div class="col-1">Année d'inscription : </div>
		<div class="col-5"><input type="text" name="inscription" value=<%= inscription %> class="form-control mb-1"></div>
	</div>
	<div class="row mb-1">
		<div class="col-1">Courriel professionnel : </div>
		<div class="col-5"><input type="text" name="courrielPro" value=<%= courrielPro %> class="form-control mb-1"></div>
	</div>
	<div class="row mb-2">
		<div class="col-1">Courriel personnel : </div>
		<div class="col-5"><input type="text" name="courrielPerso" value=<%= courrielPerso %> class="form-control mb-2"></div>
	</div>	
	<div>
		<input type="submit" name="sauvegarderModifications" value="Sauvegarder les modifications" class="btn btn-success mb-3">
	</div>
	</div>
</form>
</body>
</html>