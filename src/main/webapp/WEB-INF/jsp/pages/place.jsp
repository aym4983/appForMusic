<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:url value="${ urlPlace }" var="urlPlace" />

<h1>Place</h1>

<h2>Mes Lieux</h2>
<p class="placelist">
	<c:forEach items="${places}" var="place">
		<div data-id="${place.id}">
			<div>Nom : <c:out value="${place.publiclabel}"/></div>
			<div>Rue : <c:out value="${place.street}"/></div>
			<div>Code Postal : <c:out value="${place.zipcode}"/></div>
			<div>Ville : <c:out value="${place.city}"/></div>
			<button class="skill-delete"> Supprimer</button>
		</div>
	</c:forEach>
	
	<button id="place-add" class="Ajouter"> Ajouter </button>
</p>

<h2>Créer un lieu</h2>
<form:form action="" method="post" modelAttribute="placeForm" id="createPlace hidden" class="col-md-4 col-md-offset-4">
	<p class="form-group">
		<form:label path="publicLabel" for="place-publiclabel">Titre</form:label>
		<form:input path="publicLabel" id="place-publiclabel" class="form-control" placeholder="Titre"/></p>
	
	<p class="form-group">
		<form:label path="street" for="place-street">Rue</form:label>
		<form:input path="street" id="place-street" class="form-control" placeholder="Rue"/></p>
	
	<p class="form-group">
		<form:label path="zipcode" for="place-zipcode">Code Postal</form:label>
		<form:input path="zipcode"  id="place-zipcode" class="form-control" placeholder="Code Postal"/></p>
	
	<p class="form-group">
		<form:label path="city" for="place-city">Ville</form:label>
		<form:input path="city" id="place-city" class="form-control" placeholder="Ville"/></p>
	
	<input type="radio" name="place-type" value="private"> Privé 
	<input type="radio" name="place-type" value="public" checked> Public
	
	<p><input type="submit" name="place" value="Ajouter" class="btn btn-block btn-primary" />
</form:form>