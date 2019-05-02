<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>Update Annonce</title>
<meta charset="utf-8">
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
	<jsp:include page="HeaderB.jsp" />

	<div class="container">
		<h2>Update Annonce</h2>
		<div class="col-sm-5" id="inscription">
			<form:form commandName="annonce" action="UpdateAnnonce" method="POST">
				<div class="form-group ">
					<input name="idAnn" type="hidden" value="${annonce.idAnnonces}">
					<label for="titre">Titre:</label>
					<form:input type="text" class="form-control" path="titre"
						value="${annonce.titre}"></form:input>
					<%-- 					<form:errors path="titre" cssClass="error" /> --%>
				</div>
				<div class="form-group ">
					<label for="motClefs">Mots-Clefs:</label>
					<form:input type="text" class="form-control" path="motClefs"
						value="${annonce.motClefs}"></form:input>
					<%-- 					<form:errors path="motClefs" cssClass="error" /> --%>
				</div>
				<div class="form-group ">
					<label for="adresse">Adresse:</label>
					<form:input type="text" class="form-control" path="adresse"
						value="${annonce.adresse}"></form:input>
					<%-- 					<form:errors path="adresse" cssClass="error" /> --%>
				</div>
				<div class="form-group " id="dateNaissance">
					<label for="prix">Prix:</label>
					<form:input type="text" class="form-control" path="prix"
						value="${annonce.prix}"></form:input>
					<%-- 					<form:errors path="${annonce.prix}" cssClass="error" /> --%>
				</div>

				<div class="form-group ">
					<label for="description">Description:</label>
					<form:textarea class="form-control" path="description"
						placeholder="Entrer votre description" rows="5"
						value="${annonce.description}"></form:textarea>
					<%-- 					<form:errors path="description" cssClass="error" /> --%>
				</div>

				<div class="form-group">
					<label for="photo">Ajouter une photo</label>
					<form:input type="text" class="form-control-file" path="photo" value="${annonce.photo}"></form:input>
				</div>

				<button type="submit" class="btn btn-primary">Modifier
					l'annonce</button>
			</form:form>
		</div>
	</div>


</body>
</html>