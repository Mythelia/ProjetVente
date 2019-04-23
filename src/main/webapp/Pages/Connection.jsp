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
<script>
	function onSignIn(googleUser) {
		// Useful data for your client-side scripts:
		var profile = googleUser.getBasicProfile();
		console.log("ID: " + profile.getId()); // Don't send this directly to your server!
		console.log('Full Name: ' + profile.getName());
		console.log('Given Name: ' + profile.getGivenName());
		console.log('Family Name: ' + profile.getFamilyName());
		console.log("Image URL: " + profile.getImageUrl());
		console.log("Email: " + profile.getEmail());

		// The ID token you need to pass to your backend:
		var id_token = googleUser.getAuthResponse().id_token;
		console.log("ID Token: " + id_token);
	}
</script>
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
</style>
<body>
	<jsp:include page="HeaderB.jsp" />
	<h2 id="plus"></h2>
	<div class="col-sm-4"></div>
	<div class="col-sm-4" id="conn">
		<form:form action="Login" commandName="utilisateurs"  method="POST">
			<table class=table>
				<tbody>
					<tr>
						<td>Login</td>
						<td><form:input path="login"></form:input></td>
						<td><form:errors path="login" cssClass="error" /></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><form:password path="password"></form:password></td>
						<td><form:errors path="password" cssClass="error" /></td>
					</tr>

				</tbody>
			</table>
			<div>
				<button class="btn btn-primary" type="submit">Login</button>
				<img alt="facebook"
					src="https://cdn.icon-icons.com/icons2/1099/PNG/512/1485482214-facebook_78681.png"
					id="img-compte" class="pull-right"> <br>
				<div class="g-signin2" data-onsuccess="onSignIn"></div>
			</div>
			<br>
			<hr>
			<br>


		</form:form>

		<a href="Inscription" class="btn btn-primary">Vous inscrire </a> <a
			class="btn btn-primary" href='MDPOubli'> Mot de passe oubli� ?</a>



	</div>
</body>
</html>