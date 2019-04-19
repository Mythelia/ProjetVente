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



/* #SButton { */
/* margin-left: 0px; */
/* } */
</style>
</head>
<body>
	<jsp:include page="/Pages/HeaderB.jsp" ></jsp:include>
	<div class="container">
		<h2>Bienvenu sur notre projet</h2>
		<br>


		<form class="form-inline">
			<div class="container">
				<div class="row">
					<div id="custom-search-input">
						<div class="input-group col-sm-12">
							<input type="text" class="  search-query form-control"
								placeholder="Search" /> <span class="input-group-btn">
								<button class="btn btn-danger" type="button">
									<span class=" glyphicon glyphicon-search"></span>
								</button>
							</span>
						</div>
					</div>
				</div>
			</div>
		</form>


		<br> <br>
		<div class="row">
			<div class="col-sm-6">
				<form action="">
					<div class="panel panel-primary">
						<div class="panel-heading">Titre</div>
						<div class="panel-body">
							<img src="https://placehold.it/150x80?text=IMAGE"
								class="img-responsive" style="width: 100%" alt="Image">
						</div>
						<div class="panel-footer">Prix</div>
					</div>
				</form>
			</div>
			<div class="col-sm-6">
				<form action="">
					<div class="panel panel-primary">
						<div class="panel-heading">Titre</div>
						<div class="panel-body">
							<img src="https://placehold.it/150x80?text=IMAGE"
								class="img-responsive" style="width: 100%" alt="Image">
						</div>
						<div class="panel-footer">Prix</div>

					</div>

				</form>
			</div>




		</div>

	</div>
</body>


</html>
