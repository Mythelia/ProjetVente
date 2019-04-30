<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Nouvelle Alerte</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style type="text/css">
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

		<div class="col-sm-8" id="inscription">
			<form:form commandName="alerte" method="POST" action="formAlerte">

				<div class="form-group ">
					<label for="titre">Mot clef</label>
					<form:input path="motClefs" class="form-control"></form:input>
					<form:errors path="motClefs" cssClass="error" />
				</div>
				<button type="submit" class="btn btn-primary">Créer</button>
			</form:form>
		</div>
	</div>
</body>
</html>