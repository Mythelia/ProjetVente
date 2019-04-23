<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>

<head>
<head>
<title>Bootstrap Example</title>
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
		<div class="container">
			<div class="btn-group">
				<button type="button" class="btn btn-primary dropdown-toggle"
					data-toggle="dropdown">
					Catégories <span class="caret"></span>
				</button>

				<ul class="dropdown-menu" role="menu">
					<li class="dropdown-header">Emploi</li>
					<li><a href="#">Offres d'emploi</a></li>
					<li class="dropdown-header">Véhicules</li>
					<li><a href="#">Voitures</a></li>
					<li><a href="#">Motos</a></li>
					<li><a href="#">Caravaning</a></li>
					<li><a href="#">Utilitaires</a></li>
					<li><a href="#">Equipement Auto</a></li>
					<li><a href="#">Equipement Moto</a></li>
					<li><a href="#">Equipement Caravaning</a></li>
					<li><a href="#">Nautisme</a></li>
					<li><a href="#">Equipement nautisme</a></li>
					<li class="dropdown-header">Immobilier</li>
					<li><a href="#">Ventes immobilières</a></li>
					<li><a href="#">Locations</a></li>
					<li><a href="#">Collocations</a></li>
					<li><a href="#">Bureaux & commerces</a></li>
					<li class="dropdown-header">Vacances</li>
					<li><a href="#">Locations & gîtes</a></li>
					<li><a href="#">Chambres d'hôtes</a></li>
					<li><a href="#">Camping</a></li>
					<li><a href="#">Hôtels</a></li>
					<li class="dropdown-header">Maisons</li>
					<li><a href="#">Ammeublement</a></li>
					<li><a href="#">Electromenager</a></li>
					<li><a href="#">Art de la table</a></li>
					<li><a href="#">Décoration</a></li>
					<li><a href="#">Linge de maison</a></li>
					<li><a href="#">Bricolage</a></li>
					<li><a href="#">Jardinage</a></li>
					<li class="dropdown-header">Mode</li>
					<li><a href="#">Vide Dressing</a></li>
					<li><a href="#">Vêtements</a></li>
					<li><a href="#">Chaussures</a></li>
					<li><a href="#">Accessoires & Bagagerie</a></li>
					<li><a href="#">Montres & Bijoux</a></li>
					<li><a href="#">Equipement bébé</a></li>
					<li><a href="#">Vetements bébé</a></li>
					<li class="dropdown-header">Multimédia</li>
					<li><a href="#">informatique</a></li>
					<li><a href="#">Consoles & Jeux vidéos</a></li>
					<li><a href="#">Image & son</a></li>
					<li><a href="#">Telephonie</a></li>				
					<li class="dropdown-header">Loisirs</li>
					<li><a href="#">DVD/Films</a></li>
					<li><a href="#">CD/Musique</a></li>
					<li><a href="#">Livres</a></li>
					<li><a href="#">Animaux</a></li>
					<li><a href="#">Vélos</a></li>
					<li><a href="#">Sports & Hobbies</a></li>
					<li><a href="#">Instruments de musique</a></li>
					<li><a href="#">Collection</a></li>
					<li><a href="#">Jeux & jouets</a></li>
					<li><a href="#">Vins & gastronomie</a></li>
					<li class="dropdown-header">Matériel professionnel</li>
					<li><a href="#">Matériel agricole</a></li>
					<li><a href="#">Transport/Manutention</a></li>
					<li><a href="#">BTP/Chantier gros-oeuvre</a></li>
					<li><a href="#">Equipements industriels</a></li>
					<li><a href="#">Restauration & Hotellerie</a></li>
					<li><a href="#">Fournitures de bureau</a></li>
					<li><a href="#">Commerces & Marchés</a></li>
					<li><a href="#">Matériel médical</a></li>
					<li class="dropdown-header">Services</li>
					<li><a href="#">Prestations de services</a></li>
					<li><a href="#">Billeterie</a></li>
					<li><a href="#">Evénements</a></li>
					<li><a href="#">Cours particuliers</a></li>
					<li><a href="#">Covoiturage</a></li>
					<li class="dropdown-header">Autres</li>
					<li><a href="#">Autres</a></li>
				

				</ul>
			</div>
		</div>
	</div>
	<div class="col-sm-5" id="AAnnonce">
		<form action="formannonce" method="post">
			<div class="form-group ">
				<label for="titre">Titre:</label> <input type="text"
					class="form-control" id="titre"
					placeholder="Entrer le titre de votre annonce">
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
	
<footer class="container-fluid">
  <p>Footer Text</p>
</footer>

</body>
</html>