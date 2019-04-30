<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Alertes</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="HeaderB.jsp" />

	<div class="container">
		<h2>Vos alertes</h2>
		<table class="table table-hover table-bordered">
			<thead>
				<tr>
					<th>Mot clef</th>
					<th>Modifier alerte</th>
					<th>Supprimer alerte</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${alerte}" var="a">
					<tr>
						<td>${a.motsclefses}</td>

						<td>
							<form action="UpdateAl" method="post">
								<input type='hidden' name="idAl" value="${a.idAlerte}">
								<input type="submit" value="Update"></input>
							</form>
						</td>
						<td><form action="DeleteAl" method="post">
								<input type='hidden' name="idAl" value="${a.idAlerte}">
								<input type="submit" value="Supprimer"></input>
							</form></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>