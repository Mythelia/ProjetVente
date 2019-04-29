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

.row-centered {
	text-align: center;
	margin: 20px;
	border:1px;
}
/* #SButton { */
/* margin-left: 0px; */
/* } */
</style>
</head>
<body>
	<jsp:include page="/Pages/HeaderB.jsp"></jsp:include>


	<div class="container-fluid">
		<div class="row row-centered">
			<div class="col-sm-12">${annonce.titre }</div>
		</div>
		<div class="row row-centered">
			<div class="col-sm-12">${annonce.description }</div>
		</div>
		<div class="row row-centered">
			<div class="col-sm-8">${annonce.prix } €</div>
			<div class="col-sm-4">${annonce.photo}</div>
		</div>
		<div class="row row-centered">
			<div class="col-sm-4">${annonce.date }</div>
			<div class="col-sm-4">${annonce.adresse }</div>
			<div class="col-sm-4">Contact</div>

		</div>

	</div>


</body>


</html>
