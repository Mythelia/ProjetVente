<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Messagerie</title>
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
	<jsp:include page="HeaderB.html" />
	<div class="container">
		<h2>Messagerie</h2>
		<table class="table table-hover table-bordered">
			<thead>
				<tr>
					<th>Expéditeur</th>
					<th>Titre</th>
					<th>Date</th>
					<th>Supprimer mail</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${mails}" var="u">
					<tr>
						<td>${u.expediteur}</td>
						<td>${u.titre}</td>
						<td>${u.date}</td>
						<td><form action="DeleteMess" method="post">
								<input type='hidden' name="id" value="${u.id}"> <input
									type="submit" value="Supprimer"></input>
							</form></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>