<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Message</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style type="text/css">
#container {
	border: solid 1px blue;
}
</style>
</head>
<jsp:include page="HeaderB.jsp" />

<body>

	<div class="container" id="container">
		<div class="container">
			<h3>${message.titre}</h3>

			<hr>


			<div class="col-sm-6">
				<div class="col-sm-2">
					<h5>De :</h5>
				</div>
				<div class="col-sm-7">
					<h5 id="messageTxt">${message.utilisateursByIdUtilisateurExpediteur.nom}</h5>
				</div>
				<div class="col-sm-5"></div>
			</div>
		</div>
		<hr>
		<div class="container">

			<div class="col-sm-6">
				<div class="col-sm-2">
					<h5>Objet :</h5>
				</div>
				<div class="col-sm-7">
					<h5 id="messageTxt">${message.titre}</h5>
				</div>
				<div class="col-sm-5"></div>
			</div>
		</div>
		<hr>
		<div class="col-sm-12">
			<h3 id="messageTxt">${message.texte}</h3>
		</div>
	</div>
	<br>
	<br>
	<div class="container">
		<form action="repMessage">
			<input type="hidden" name="idMessage" value="${message.idMessages}">
			<button class="btn btn-primary">Répondre au message</button>
		</form>
	</div>
</body>
</html>