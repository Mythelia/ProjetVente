<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<head>
<title>Ajouter une Annonce</title>
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
		<h2>Ajouter une Annonce</h2>
		<div class="col-sm-5" id="AAnnonce">
			<form action="formannonce" method="post">
				<div class="form-group ">
					<label for="titre">Titre:</label> <input type="text"
						class="form-control" id="titre" placeholder="Entrer le titre de votre annonce">
				</div>
				<div class="form-group ">
					<label for="adresse">Adresse:</label> <input type="text"
						class="form-control" id="adresse"
						placeholder="Entrer votre Adresse">
				</div>

				<div class="form-group " id="dateNaissance">
					<label for="date">Date:</label> <input type="date"
						class="form-control" id="date" value="19/08/2011">
				</div>

				<div class="form-group ">
					<label for="prix">Prix de votre article</label> <input type="text"
						class="form-control" id="prix" placeholder="Entrer votre prix">
				</div>

				<div class="form-group ">
					<label for="description">Description:</label>
					<textarea class="form-control" id="description"
						placeholder="Entrer votre description" rows="5"> </textarea>
				</div>


				<div class="form-group ">
					<label for="mots-clefs">Mots clefs:</label>
					<textarea class="form-control" id="mots-clefs"
						placeholder="Entrer vos mots-clefs" rows="5"> </textarea>
				</div>

				<div class="form-group">
					<label for="photo">Ajouter une photo</label> <input type="file"
						class="form-control-file" id="photo">
				</div>


				<button type="submit" class="btn btn-primary">Soumettre</button>
			</form>
		</div>
	</div>

</body>
</html>