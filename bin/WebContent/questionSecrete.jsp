<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Question Secrète</title>
</head>
<body>
	<div>Pour pouvoir vous connecter, veuillez répondre à la question suivante</div>
	<p>
            <% 
            String attribut = (String) request.getSession().getAttribute("qSecrete");
            out.println( attribut );
            %>
    </p>
	<form action="QuestionSecrete" method="post">
			<div>
				<input type="text" name="rqSecrete" placeholder="réponse à la question secrète">
			</div>
			<div>
				<input type="submit" value="Valider réponse secrète">
			</div>
	</form>
</body>
</html>