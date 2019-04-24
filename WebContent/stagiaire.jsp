<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.css">
<title>Stagiaire</title>
</head>
<body>

	<section class="Container">
		<h1>Formulaire</h1>
		<form action="ServletStagiaire">
		
			<div class="form-group">
				<label for="prenom">Prénom</label> <input id="prenom"
					class="form-control" placeholder="Mon Prenom" type="text"
					name="firstname" value="${firstname}" />
			</div>

			<div class="form-group">
				<label for="nom">nom</label> <input id="nom" class="form-control"
					type="text" name="lastname" value="${lastname}" />
			</div>

			<div class="form-group">
				<label for="age">age</label> <input id="age" class="form-control"
					type="text" name="age" value="${age}" />
			</div>

			<input type="submit" name="ajouter" value="Ajouter" />
		</form>
	</section>
	
		<div class=container>
		<h2>Liste des Stagiaires en BDD</h2>
		<table class="table table-bordered">
			<thead class="orange">
				<tr>
					<th>ID Stagiaire</th>
					<th>NOM</th>
					<th>PRENOM</th>
					<th>AGE</th>
					<th>SUPPRIMER</th>
				</tr>
			</thead>
			<tbody>

				<c:if test="${!empty stagiaires}">
					<c:forEach items="${stagiaires}" var="x">
						<tr>
							<td><c:out value="${x.idStagiaire}" /></td>
							<td><c:out value="${x.nom}" /></td>
							<td><c:out value="${x.prenom}" /></td>
							<td><c:out value="${x.age}" /></td>
							<td><a href="SupprimerStagiaire?idStagiaire=${x.idStagiaire}">supprimer</a></td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>
</body>
</html>