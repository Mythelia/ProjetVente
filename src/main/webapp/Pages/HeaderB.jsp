<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style type="text/css">
img.head {
	width: 35px;
	height: 35px;
	margin-right: 10px;
}

a.head:hover {
	background-color: #B5E7EE !important;
}

.navbar-form {
	margin-top: 3%;
}

#glyp-s {
	width: 15px;
	height: 20px;
	background-color: #e3f2fd;
}

#but-glyp-s {
	background-color: #e3f2fd;
}
</style>
<nav class="navbar navbar-light" style="background-color: #e3f2fd;">
	<div id="head" class="container-inner">

		<div class="col-sm-1">

			<ul class="nav navbar-nav">
				<li class="active"><a class="head" href="index" class="head"><img
						class="head" alt="home"
						src="https://image.flaticon.com/icons/png/512/25/25694.png"></a></li>
			</ul>
		</div>


		<div class="col-sm-3">
			<form class="navbar-form " action="Search">
				<div class="input-group">
					<input type="text" class="form-control" placeholder="Search"
						name="searchC">
					<div class="input-group-btn btn-basic">
						<button class="btn btn-default" type="submit" id="but-glyp-s">
							<span class="glyphicon glyphicon-search" id="glyp-s"></span>
						</button>
					</div>
				</div>
			</form>
		</div>

		<div class="col-sm-3">
			<ul class="nav navbar-nav">
				<li class="active"><a class="head" href="AjouterAnnonce"
					id="SIcon"> <img
						src="https://image.flaticon.com/icons/svg/3/3911.svg" class="head">
						Ajouter une annonce
				</a></li>
			</ul>
		</div>

		<div class="col-sm-3">
			<ul class="nav navbar-nav">
				<li class="active"><a class="head" href='Connection'> <img
						class="head" alt="compte"
						src="https://cdn0.iconfinder.com/data/icons/elasto-online-store/26/00-ELASTOFONT-STORE-READY_user-circle-512.png"
						id="Icompte"> <c:choose>
							<c:when test="${empty login }">
						 Mon compte
						 </c:when>
							<c:otherwise>
						 ${login.login }
						 </c:otherwise>

						</c:choose>
				</a></li>
			</ul>
		</div>

		<div class="col-sm-2">

			<ul class="nav navbar-nav">
				<li class="active"><a class="head" href="Messagerie"> <img
						class="head" alt="compte"
						src="https://image.flaticon.com/icons/svg/131/131155.svg"
						id="Message"><span class="badge">${login.nbrMessage}</span>
				</a></li>
			</ul>
		</div>

	</div>
</nav>