<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vous allez nous acheter ?</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>

	<jsp:include page="/Pages/HeaderB.jsp"></jsp:include>
	<div class="container">
		<div class="col-sm-2"></div>
		<div class="col-sm-7">
			<h2>Etes vous sûr de vouloir acheter cet article ?</h2>
		</div>
		<div class="col-sm-3"></div>
		<br>
		<hr>
		<br>
		<div class="col-sm-2"></div>
		<div class="col-sm-3">
			<form action="AnnonceAchete">
				<input type="hidden" name="idAnnonce" value="${annonce.idAnnonces}">
				<button class="btn btn-primary" type="submit">Oui</button>
			</form>
		</div>
		<div class="col-sm-3">
			<a class="btn btn-primary" href="index">Non</a>
		</div>


	</div>

</body>
</html>