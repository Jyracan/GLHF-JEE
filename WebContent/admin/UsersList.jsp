<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList,sessionManagement.User" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des utilisateurs</title>
</head>
<body>
	<div>Bienvenue dans l'interface de modification des droits des utilisateurs</div>
	<div >Liste des utilisateurs :</div>	
		<table id="tableau" border="1">
			<thead>
				<tr>
					<th>Nom</th>
					<th>Droits</th>
				</tr>
			</thead>
			<tbody>
				<%
					ArrayList<User> users = (ArrayList<User>) request.getAttribute("usersList");
					for(User usr : users) {
				%>
				<tr>
					<td><%= usr.getLogin() %></td>
					<td>
						<select>
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
	<form action="" method="post">
		<input type = "submit" name ="save" value = "Enregistrer">
	</form>
</body>
</html>