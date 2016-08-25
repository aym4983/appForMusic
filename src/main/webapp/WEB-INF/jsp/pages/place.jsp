<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:url value="${ urlPlace }" var="urlPlace" />

<script src="http://maps.google.com/maps?file=api&amp;v=2&amp;sensor=false&amp;key=AIzaSyBH8dHLUHMkDTWfuiLOxhySJpQtXTp7mFU"type="text/javascript"></script>




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
	<button id="place-add" name="Ajouter"> Ajouter </button>
</p>

<form:form action="" method="post" modelAttribute="placeForm" id="createPlace" class="col-md-4 col-md-offset-4 hidden">
	<h2>Créer un lieu</h2>
	
	<p class="form-group">
		<form:label path="publicLabel" for="place-publiclabel">Nom du lieu</form:label>
		<form:input path="publicLabel" id="place-publiclabel" class="form-control" placeholder="Titre"/></p>
	
<%-- 	<form action="#" onsubmit="geocodeAdresse(this.street.value, this.city.value, this.zipcode.value); return false" > --%>
	<p class="form-group">
		<form:label path="street" for="place-street">Rue</form:label>
		<form:input name="street" path="street" id="place-street" class="form-control" placeholder="Rue"/></p>
	
	<p class="form-group">
		<form:label path="zipcode" for="place-zipcode">Code Postal</form:label>
		<form:input name="zipcode" path="zipcode"  id="place-zipcode" class="form-control" placeholder="Code Postal"/></p>
	
	<p class="form-group">
		<form:label path="city" for="place-city">Ville</form:label>
		<form:input name="city" path="city" id="place-city" class="form-control" placeholder="Ville"/></p>
<!-- 	<button required="required" class="btn btn-primary btn-lg" name="submit" type="submit">Visualiser l'adresse</button> -->
<%-- 	</form> --%>
	
	<p class="form-group">
		<form:label path="latitude" for="place-latitude"><strong>Latitude:</strong></form:label>
		<form:input path="latitude" id="lat" class="form-control" readonly="true"/>
		<em id="lat_rad" style="color:#555; font-size:0.9em;"></em>
	</p>
		
	<p class="form-group">
		<form:label path="longitude" for="place-latitude"><strong>Longitude:</strong></form:label>
		<form:input path="longitude" id="lon" class="form-control" readonly="true"/>
		<em id="lon_rad" style="color:#555; font-size:0.9em;"></em>
	</p>
	
<!-- 	<div>&nbsp;</div> -->
<!-- 	<div id="DelMaps" style="width: 660px; height: 400px; border:1px solid #ccc;"></div> -->
<!-- 	<div>&nbsp;</div> -->
	
	<p class="form-group">
		<form:label path="type" for="place-type"><strong>Longitude:</strong></form:label>
		<form:radiobutton path="type" value="private"/> Privé
		<form:radiobutton path="type" value="public" checked="true" /> Public
	</p>
<!-- 	<input type="radio" name="place-type" value="private"> Privé  -->
<!-- 	<input type="radio" name="place-type" value="public" checked> Public -->
	
	<p>
	<input type="submit" name="place" value="Ajouter" class="btn btn-block btn-primary" />
	<button id="place-reset" name="Annuler"> Annuler</button>
	</p>
</form:form>