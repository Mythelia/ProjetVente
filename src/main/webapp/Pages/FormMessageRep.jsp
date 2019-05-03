<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Nouveau Message</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style type="text/css">
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>
</head>
<body>
	<jsp:include page="HeaderB.jsp" />
	<div class="container">

		<div class="col-sm-8" id="inscription">
			<form:form commandName="message" method="POST" action="formMessage">
				<div class="form-group">
					<label for="nom">Destinataire (Pseudo)</label> <input
						name="utilisateurName" class="form-control"
						value="${message.utilisateursByIdUtilisateurExpediteur.login}"></input>
				</div>
				<div class="form-group ">
					<label for="titre">Objet</label>
					<form:input path="titre" class="form-control"
						value="Re: ${message.titre}"></form:input>
					<form:errors path="titre" cssClass="error" />
				</div>
				<div class="form-group ">
					<form:textarea path="texte" class="form-control" rows="10" value=""></form:textarea>
					<form:errors path="texte" cssClass="error" />
				</div>
				<button type="submit" class="btn btn-primary">Envoyer</button>
			</form:form>
		</div>
	</div>
</body>
</html>