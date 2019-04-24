<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.css">
<title>Formation</title>
</head>
<body>

	<section class="Container">
		<h1>Formulaire</h1>
		<form action="ServletFormation">
			<div class="form-group">
				<label for="nomformation">NomFormation</label>
				<input id ="nomformation" class="form-control" type="text"
					name="nomformation" value="${nomformation}" required />
			</div>

			<input type="submit" name="ajouter" value="Ajouter" />
		</form>
	</section>

	<div class=container>
		<h2>Liste des Formations en BDD</h2>
		<table class="table table-bordered">
			<thead class="orange">
				<tr>
					<th>ID Formation</th>
					<th>NOM Formation</th>
					<th>SUPPRIMER</th>
				</tr>
			</thead>
			<tbody>

				<c:if test="${!empty formations}">
					<c:forEach items="${formations}" var="x">
						<tr>
							<td><c:out value="${x.idformation}" /></td>
							<td><c:out value="${x.nomformation}" /></td>
							<td><a href="SupprimerFormation?idFormation=${x.idformation}">supprimer</a></td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>

</body>
</html>