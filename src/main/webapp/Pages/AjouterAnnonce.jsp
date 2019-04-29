<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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

.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>
</head>
<body>
	<jsp:include page="HeaderB.jsp" />

	<div class="container">
		<h2>Ajouter une Annonce</h2>
		<div class="col-sm-5" id="Annonce">
			<form:form action="formannonce" commandName="annonce" method="POST">
				<div class="form-group ">
					<label for="titre">Titre:</label>
					<form:input class="form-control" path="titre"
						placeholder="Entrer le titre de votre annonce"></form:input>

					<form:errors path="titre" cssClass="error" />

				</div>
				<div class="form-group ">
					<label for="motsClefs">Mots-clefs:</label>
					<form:input class="form-control" path="motsclefses"
						placeholder="Entrer les mots-clefs associés à votre annonce"></form:input>

				</div>
				<div class="form-group ">
					<label for="adresse">Adresse:</label>
					<form:input class="form-control" path="adresse"
						placeholder="Entrer votre Adresse"></form:input>
					<form:errors path="adresse" cssClass="error" />
				</div>

<!-- 				<div class="form-group " id="date"> -->
<!-- 					<label for="date">Date:</label> -->
<%-- 					<form:input type="date" class="form-control" path="date"></form:input> --%>
<%-- 					<form:errors path="date" cssClass="error" /> --%>
<!-- 				</div> -->

				<div class="form-group ">
					<label for="prix">Prix de votre article</label>
					<form:input class="form-control" path="prix"
						placeholder="Entrer votre prix"></form:input>
					<form:errors path="prix" cssClass="error" />
				</div>

				<div class="form-group ">
					<label for="description">Description:</label>
					<form:textarea class="form-control" path="description"
						placeholder="Entrer votre description" rows="5"></form:textarea>
					<form:errors path="description" cssClass="error" />
				</div>


				<!-- 				<div class="form-group "> -->
				<!-- 					<label for="mots-clefs">Mots clefs:</label> -->
				<%-- 					<form:textarea class="form-control" path="motsClefses" --%>
				<%-- 						placeholder="Entrer vos mots-clefs" rows="5"></form:textarea> --%>
				<!-- 				</div> -->

				<div class="form-group">
					<label for="photo">Ajouter une photo</label>
					<form:input type="file" class="form-control-file" path="photo"></form:input>
				</div>

				<button type="submit" class="btn btn-primary">Soumettre</button>
			</form:form>
		</div>
	</div>

</body>
</html>