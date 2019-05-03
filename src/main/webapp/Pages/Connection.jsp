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
<meta name="google-signin-client_id"
	content="YOUR_CLIENT_ID.apps.googleusercontent.com">
<meta name="google-signin-scope" content="profile email">
<script src="https://apis.google.com/js/platform.js" async defer></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script src="https://apis.google.com/js/platform.js" async defer></script>


<style type="text/css">
#plus {
	padding-top: 70px;
}

#img-compte {
	width: 30px;
	height: 30px;
}

#g-signin2 {
	
}

.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}

#erreur {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>
<body>
	<jsp:include page="HeaderB.jsp" />
	<h2 id="plus"></h2>
	<div class="col-sm-4"></div>
	<div class="col-sm-4" id="conn">
		<form:form action="Login" commandName="utilisateurs" method="POST">
			<table class=table>
				<tbody>


					<tr>
						<td>Login</td>
						<td><form:input path="login"></form:input></td>
						<td><form:errors path="login" cssClass="error" /></td>
						<td><span id="erreur">${msgutil}</span></td>

					</tr>
					<tr>
						<td>Password</td>
						<td><form:password path="passwordString"></form:password></td>
						<td><form:errors path="passwordString" cssClass="error" /></td>
						<td><span id="erreur">${msgpass}</span></td>
					</tr>



				</tbody>
			</table>
			<br>
			<div>
				<button class="btn btn-primary" type="submit">Login</button>

			</div>
			<br>
			<hr>
			<div>
				<h5>Vous n'avez pas de compte ?</h5>
			</div>
			<br>


		</form:form>

		<a href="Inscription" class="btn btn-primary">Vous inscrire </a> <a
			class="btn btn-primary" href='MDPOubli'> Mot de passe oublié ?</a>



	</div>
</body>
</html>