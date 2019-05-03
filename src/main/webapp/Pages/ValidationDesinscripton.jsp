<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vous allez nous quitter ?</title>
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
		<h2>Etes vous sûr de vouloir vous désinscrire ?</h2>
		<a class="btn btn-primary" href="DeleteUtilisateur">Oui</a> <a
			class="btn btn-primary" href="Connection">Non</a>
	</div>

</body>
</html>