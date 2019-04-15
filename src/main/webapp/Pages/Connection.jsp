<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
table {
	text-align: left;
}
</style>
<body>
	<jsp:include page="HeaderB.html" />
	<br>
	<div class="col-sm-4"></div>
	<div class="col-sm-4" id="conn">
		<form action="" method="post">
			<table class=table>
				<tbody>
					<tr>
						<td>Login</td>
						<td><input name="login" type=text></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input name="pass" type=password></td>
					</tr>

				</tbody>
			</table>

			<input type="submit" value="Login"> <br>
			<hr>
			<br>


		</form>

		<a href="Inscription.jsp" class="btn btn-primary">Vous inscrire </a> <a
			class="btn btn-primary" href='index.jsp'> Mot de passe oublié ?</a>



	</div>
</body>
</html>