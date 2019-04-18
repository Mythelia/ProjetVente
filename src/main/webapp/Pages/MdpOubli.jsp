
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<head>
<title>Alzheimer</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style type="text/css">
h2 {
	padding-top: 70px;
	padding-bottom: 70px;
}
</style>
</head>
<body>

	<jsp:include page="HeaderB.jsp" />

	<div class="container">
		<h2>Mot de passe oublié ?</h2>
		<form>
			<div class="col-sm-5">
				<div class="form-group" id="mail">
					<label for="mail">Entrez votre email pour récupérer votre
						mot de passe</label> <input class="form-control" id="mailOubli"
						type="text" placeholder="Entrez votre email">
				</div>
				<button type="submit" class="btn btn-primary">Réinitialiser
					le mot de passe</button>
			</div>
		</form>
	</div>




</body>
</html>