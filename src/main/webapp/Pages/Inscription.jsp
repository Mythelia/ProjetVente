<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
		<h2>Inscription</h2>
		<div class="col-sm-5" id="inscription">
			<form:form commandName="utilisateur" method="POST"
				action="formmodifp">
				<div class="form-group">
					<label for="nom">Nom:</label>
					<form:input path="nom" placeholder="Entrer votre nom"
						class="form-control"></form:input>
					<form:errors path="nom" cssClass="error" />
				</div>
				<div class="form-group ">
					<label for="prenom">Prénom:</label>
					<form:input path="prenom" placeholder="Entrer votre prénom"
						class="form-control"></form:input>
					<form:errors path="prenom" cssClass="error" />
				</div>
				<div class="form-group ">
					<label for="mail">Adresse mail:</label>
					<form:input path="mail" placeholder="Entrer votre adresse mail"
						class="form-control"></form:input>
					<form:errors path="mail" cssClass="error" />
				</div>
				<div class="form-group " id="dateNaissance">
					<label for="date">Date de naissance:</label>
					<form:input type="date" path="dateNaissance" value="19/08/2011"
						class="form-control" id="date"></form:input>
					<form:errors path="dateNaissance" cssClass="error" />
				</div>

				<div class="form-group ">
					<label for="postal">Code postal de votre ville :</label>
					<form:input path="codePostal"
						placeholder="Entrer votre code postal" class="form-control"
						value=""></form:input>
					<form:errors path="codePostal" cssClass="error" />
				</div>

				<div class="form-group ">
					<label for="pseudo">Pseudo:</label>
					<form:input path="login" placeholder="Entrer votre pseudo"
						class="form-control"></form:input>
					<form:errors path="login" cssClass="error" />
				</div>

				<div class="form-group">
					<label for="password">Mot de passe:</label>
					<form:input type="password" path="passwordString"
						placeholder="Entrez votre mot de passe" class="form-control"></form:input>
					<form:errors path="passwordString" cssClass="error" />
				</div>
				<!-- 				<div class="form-group"> -->
				<!-- 					<label for="password">Confirmer le mot de passe</label> -->
				<%-- 					<form:input type="password" path="password" --%>
				<%-- 						placeholder="Confirmer le mot de passe" class="form-control"></form:input> --%>
				<%-- 					<form:errors path="password" cssClass="error" /> --%>
				<!-- 				</div> -->
				<button type="submit" class="btn btn-primary">S'inscrire</button>
			</form:form>
		</div>
	</div>

</body>
</html>
