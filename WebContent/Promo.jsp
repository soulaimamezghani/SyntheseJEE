<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.css">
<title>Promotion</title>

</head>
<body>

	<section class="Container">
		<h1>Formulaire</h1>
		
		<form action="ServletPromo">
		
			<div class="form-group">
				<label for="nomsession">Nomsession</label> <input id="nomsession"
					class="form-control" type="text" name="nomsession"
					value="${nomsession}" required />
			</div>


			<div class="form-group">
				<label for="effectif">Effectif</label> <input id="effectif"
					class="form-control" type="text" name="effectif"
					value="${effectif}" required />
			</div>
			
			<input type="submit" name="ajouter" value="Ajouter" />
		</form>
	</section>

	<div class=container>
		<h2>Liste des Promotions en BDD</h2>
		<table class="table table-bordered">
			<thead class="orange">
				<tr>
					<th>ID Promotion</th>
					<th>NOM Session</th>
					<th>EFFECTIF</th>
					<th>SUPPRIMER</th>
				</tr>
			</thead>
			<tbody>

				<c:if test="${!empty promotions}">
					<c:forEach items="${promotions}" var="x">
						<tr>
							<td><c:out value="${x.idPromo}" /></td>
							<td><c:out value="${x.nomsession}" /></td>
							<td><c:out value="${x.effectif}" /></td>
							<td><a href="SupprimerPromotion?idPromo=${x.idPromo}">supprimer</a></td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>

</body>

</html>