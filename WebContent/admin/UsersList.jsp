<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList,sessionManagement.User" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des utilisateurs</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<div class="container-fluid">
		<div class="row mt-3 ml-3 mb-5">
			<h1 class="h5 font-weight-normal mr-3">Bienvenue dans l'interface de modification des droits des utilisateurs.</h1>
			<form action="Menu"><input type="submit" name="retour" value = "Retourner au menu" class="btn btn-sm btn-outline-secondary"></form>
		</div>
		<div class="row justify-content-center">
		<div class="col-5">
			<form action="" method="post">
				<table id="tableau" class="table">
					<thead class="thead-dark">
						<tr>
							<th>Nom</th>
							<th class="text-center">Droits</th>
						</tr>
					</thead>
					<tbody>
						<%
							ArrayList<User> users = (ArrayList<User>) request.getAttribute("usersList");
							for(User usr : users) {
						%>
						<tr>
							<td><%= usr.getLogin() %></td>
							<td class="text-center">
								<select name=<%= usr.getLogin() %>>
									<% 
									ArrayList<String> rights = new ArrayList<>();
									rights.add("std"); rights.add("editor"); rights.add("admin");
									for(String s : rights) { 
										if(usr.getRights().equals(s)) {
									%>
										<option value=<%= s %> selected><%= s %></option>
									<% } else { %>
										<option value=<%= s %>><%= s %></option>
									<% } 
									} 
									%>
								</select>
							</td>
						</tr>
						<% } %>
					</tbody>
				</table>
				<div class="text-center">
					<input type = "submit" name ="save" value = "Enregistrer" class="btn btn-success mt-2">
				</div>
			</form>
		</div>
		</div>
	</div>
</body>
</html>