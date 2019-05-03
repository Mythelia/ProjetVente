<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>Connexion</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style type="text/css">
#dateNaissance {
	line-height: 19px !important;
}

</style>
</head>

<body>
	<jsp:include page="HeaderB.jsp" />

	<div class="container">
		<h2>Inscription</h2>
		<div class="col-sm-5" id="inscription">
			<form:form commandName="utilisateur" action="formmodifprofil"
				method="POST">
				<div class="form-group ">
					<label for="nom">Nom:</label>
					<form:input type="text" class="form-control" path="nom"
						value="${utilisateur.nom}"></form:input>
					<form:errors path="nom" cssClass="error" />
				</div>
				<div class="form-group ">
					<label for="prenom">Prénom:</label>
					<form:input type="text" class="form-control" path="prenom"
						value="${utilisateur.prenom}"></form:input>
					<form:errors path="prenom" cssClass="error" />
				</div>
				<div class="form-group ">
					<label for="mail">Adresse mail:</label>
					<form:input type="text" class="form-control" path="mail"
						value="${utilisateur.mail}"></form:input>
					<form:errors path="mail" cssClass="error" />
				</div>
				<div class="form-group " id="dateNaissance">
					<label for="date">Date de naissance:</label>
					<form:input type="date" class="form-control" path="dateNaissance"
						value="${utilisateur.dateNaissance}"></form:input>
					<form:errors path="dateNaissance" cssClass="error" />
				</div>

				<div class="form-group ">
					<label for="postal">Code postal de votre ville :</label>
					<form:input type="text" class="form-control" path="codePostal"
						value="${utilisateur.codePostal}"></form:input>
					<form:errors path="codePostal" cssClass="error" />
				</div>

				<div class="form-group ">
					<label for="pseudo">Pseudo:</label>
					<form:input type="text" class="form-control" path="login"
						value="${utilisateur.login}"></form:input>
					<form:errors path="login" cssClass="error" />
				</div>

				<div class="form-group ">
					<label for="password">Mot de passe:</label>
					<form:input type="password" class="form-control" path="password"
						placeholder="Modifier votre mot de passe" value=""></form:input>
					<form:errors path="passwordString" cssClass="error" />
				</div>

				<button type="submit" class="btn btn-primary">Modifier le
					profil</button>
			</form:form>
		</div>
	</div>


</body>
</html>