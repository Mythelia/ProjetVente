<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<head>
<title>Inscription</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style type="text/css">
#date {
	line-height: 19px !important;
}
</style>
</head>
<body>
	<jsp:include page="HeaderB.html" />

	<div class="container">
		<h2>Inscription</h2>
		<div class="col-sm-5" id="inscription">
			<form action="#" method="post">
				<div class="form-group ">
					<label for="nom">Nom:</label> <input type="text"
						class="form-control" id="nom" placeholder="Entrer votre nom">
				</div>
				<div class="form-group ">
					<label for="prenom">Prénom:</label> <input type="text"
						class="form-control" id="prenom" placeholder="Entrer votre prénom">
				</div>
				<div class="form-group ">
					<label for="mail">Adresse mail:</label> <input type="email"
						class="form-control" id="mail"
						placeholder="Entrer votre adresse mail">
				</div>
				<div class="form-group " id="dateNaissance">
					<label for="date">Date de naissance:</label> <input type="date"
						class="form-control" id="date" value="19/08/2011">
				</div>

				<div class="form-group ">
					<label for="postal">Code postal de votre ville :</label> <input
						type="text" class="form-control" id="postal"
						placeholder="Entrer votre code postal">
				</div>

				<div class="form-group ">
					<label for="pseudo">Pseudo:</label> <input type="text"
						class="form-control" id="pseudo" placeholder="Entrer votre pseudo">
				</div>

				<div class="form-group ">
					<label for="password">Mot de passe:</label> <input type="password"
						class="form-control" id="password"
						placeholder="Entrez votre mot de passe">
				</div>
				<div class="form-group">
					<label for="password">Confirmer le mot de passe</label> <input
						type="password" class="form-control" id="password"
						placeholder="Confirmer le mot de passe">
				</div>
				<button type="submit" class="btn btn-primary">S'inscrire</button>
			</form>
		</div>
	</div>

</body>
</html>
