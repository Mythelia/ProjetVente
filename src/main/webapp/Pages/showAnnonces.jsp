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
#custom-search-input {
	margin: 0;
	margin-top: 10px;
	padding: 0;
}

#custom-search-input .search-query {
	padding-right: 3px;
	padding-right: 4px \9;
	padding-left: 3px;
	padding-left: 4px \9;
	/* IE7-8 doesn't have border-radius, so don't indent the padding */
	margin-bottom: 0;
	-webkit-border-radius: 3px;
	-moz-border-radius: 3px;
	border-radius: 3px;
}

#custom-search-input button {
	border: 0;
	background: none;
	/** belows styles are working good */
	padding: 2px 5px;
	margin-top: 2px;
	position: relative;
	left: -28px;
	/* IE7-8 doesn't have border-radius, so don't indent the padding */
	margin-bottom: 0;
	-webkit-border-radius: 3px;
	-moz-border-radius: 3px;
	border-radius: 3px;
	color: #D9230F;
}

.search-query:focus+button {
	z-index: 3;
}

img {
	max-height: 300px;
}
</style>
</head>
<body>
	<jsp:include page="/Pages/HeaderB.jsp"></jsp:include>
	<div class="container">
		<h2>${message}</h2>
		<br>
		<c:if test="${not empty autreRecherche}">
			<form method="POST" action="searchAgain">
				<button name="annonceAgain" type="submit" value=${autreRecherche }>${autreRecherche }</button>
			</form>
		</c:if>
		<br> <br> 
		<table>
			<c:forEach items="${annonces}" var="u">
				<div class="row-sm-3">
					<div class="col-sm-4">
						<form method="POST" action="Annonce">
							<div class="panel panel-primary">
								<div class="panel-heading">
									<button name="show" type="submit" class="btn btn-primary"
										value=${u.idAnnonces}>${u.titre}</button>
								</div>
								<div class="panel-body">
									<img src=${u.photo } class="img-responsive" style="width: 100%"
										alt="Image">
								</div>
								<div class="panel-footer">${u.prix}</div>
							</div>
						</form>
					</div>
				</div>
			</c:forEach>
		</table>
		<br>
		<hr>
		<form action="formAlerte">
			<input type="hidden" name="recherche" value="${message}">
			<button type="submit" class="btn btn-primary">Vous ne trouvez pas chaussure a votre
				pied ? Pourquoi ne pas creer une alerte ?</button>

		</form>
	</div>
</body>


</html>
