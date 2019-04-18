<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Connexion</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="HeaderB.jsp" />

	<div class="container">

		<div class="col-sm-2"></div>
		<div class="col-sm-10">
			<h2>Bienvenue sur votre profil</h2>

			<a href="ModifProfil.jsp" class="btn btn-primary">Modifier le profil</a> <a
				href="Messagerie.jsp" class="btn btn-primary">Voir la messagerie</a>
			<a href="AjouterAnnonce.jsp" class="btn btn-primary">Publier une
				annonce</a> <a href="VosAnnonces.jsp" class="btn btn-primary">Vos annonces</a> <a
				href="#" class="btn btn-primary">Se déconnecter</a> <a href="#"
				class="btn btn-primary">Se désinscire</a>

		</div>

	</div>






</body>
</html>
