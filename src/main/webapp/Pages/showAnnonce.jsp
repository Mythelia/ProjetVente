<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<title>Bonjour</title>
<style type="text/css">
img {
	max-height: 300px;
}

#annprix {
	display: inline-block;
	color: #DD0A0D;
}

.bi {
	
}
</style>
</head>
<body>
	<jsp:include page="/Pages/HeaderB.jsp"></jsp:include>


	<div class="container-fluid">

		<div class="col-sm-3"></div>
		<div class="col-sm-7">

			<h2 class="Bi">
				<b>${annonce.titre } </b>
			</h2>
			<hr>

			<div>
				<h2>Prix :</h2>
				<h3 id="annprix">${annonce.prix}euros</h3>
			</div>
			<hr>

			<h3>Publie le : ${annonce.date }</h3>
			<hr>

			<h2 class="Bi">
				<b>Description :</b>
			</h2>
			<h3>${annonce.description }</h3>
			<hr>
			<h2 class="Bi">
				<b>Adresse : </b>
			</h2>
			<h3>${annonce.adresse }</h3>



			<img src=${annonce.photo } class="img-responsive" alt=" "> <br>
			<hr>

			<form action="contactAnn">
				<input type="hidden" name="idAnnonceur"
					value="${annonce.utilisateurs.idUtilisateurs}">
				<button class="btn btn-primary" type="submit">Contact</button>
			</form>
		</div>

		<div class="col-sm-3"></div>
	</div>


</body>


</html>
