<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:url value="${ urlPlceInfo }" var="urlPlaceInfo" />
<c:url value="${ urlCalendar }" var="urlCalendar" />
<script type="text/javascript">var contextPath='<c:url value="/"/>'</script>

<div class="place-titre" >
	<h2 class="modal-title">
	 	<c:if test="${utilCo eq place.owner.username}">
			<div><strong><c:out value="${place.privateLabel}"/></br></strong></div>
		</c:if> 
		
		<c:if test="${utilCo ne place.owner.username}">
			<div><strong><c:out value="${place.publicLabel}"/></br></strong></div>
		</c:if> 	
	</h2>
</div>

<div class="place-info">
	<div class="form-group">
			<div id="place-map" style="height: 300px">
			
			</div>
			<script type="text/javascript">
					var app = {};
					var map;

					function initGoogleMap() {
						map = new google.maps.Map(document.getElementById("place-map"), {
							center: {lat: <c:out value="${place.latitude}"/>, lng: <c:out value="${place.longitude}"/>},
							zoom: 12
						});
				
						
						new google.maps.Marker({
								position: {
									lat: Number.parseFloat(<c:out value="${place.latitude}"/>), 
									lng: Number.parseFloat(<c:out value="${place.longitude}"/>)
								},
								map: map,
								title: $(this).data("place-label")
						});
					}

 		</script>
	</div>

	<c:if test="${utilCo eq place.owner.username}">
		<p class="col-md-6">
			<label for="placeinfo-privateLabel" class="form-label">Nom privé (Visible que pour le propriétaire)</label>
			<input type="text" name="placeinfo-privateLabel" id="placeinfo-privateLabel" class="form-control" value="${place.privateLabel}" readonly/>
		</p>
		</c:if> 
		
		<div class="col-md-6">
			<label for="placeinfo-publicLabel" class="form-label">Nom publique</label>
			<input type="text" name="placeinfo-publicLabel" id="placeinfo-publicLabel" class="form-control" value="${place.publicLabel}" readonly/>
		</div>
		
		<div class="col-md-4">
			<label class="form-label">Rue</label>
			<input type="text" name="placeinfo-street" id="placeinfo-street" class="form-control" value="${place.street}" readonly/>
		</div>
						
		<div class="col-md-2">
			<label class="form-label">Code Postal</label>
			<input name="placeinfo-zipcode" id="placeinfo-zipcode" class="form-control" value="${place.zipcode}" readonly/>
		</div>
		
		<div class="col-md-5">
			<label  for="placeinfo-city" class="form-label">Ville</label>
			<input type="text" name="placeinfo-city"  id="placeinfo-city" class="form-control" value="${place.city}" readonly/>
		</div>
							
		<div class="col-md-7">
			<label  for="placeinfo-description" class="control-label" >Description</label>
			<textarea cols="15" rows="10" id="placeinfo-description" class="form-control" name="placeinfo-description" readonly>${place.description}</textarea>
		</div>
</div>

<div class="place-action">
	<p class="col-md-7">
		<c:if test="${utilCo eq place.owner.username}">
			<button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="" href="${ urlCalendar }">Calendrier</button>
	    	<button type="button" class="btn btn-info btn-sm" id="place-delete" data-toggle="modal" data-target="#modifyModal">Modifier</button>
	    	<button type="button" class="btn btn-info btn-sm" id="place-delete" data-toggle="modal" data-target="#deleteModal">Supprimer</button>
	    </c:if>
	    
	    <c:if test="${utilCo ne place.owner.username}">
			<button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="" href="${ urlCalendar }">Réserver</button>
		</c:if> 
	</p>
</div>

<div class="place-notation">
	<div class="col-md-4">
		<div class="rating">
			<a href="#5" title="Donner 5 étoiles">☆</a>
			<a href="#4" title="Donner 4 étoiles">☆</a>
			<a href="#3" title="Donner 3 étoiles">☆</a>
			<a href="#2" title="Donner 2 étoiles">☆</a>
			<a href="#1" title="Donner 1 étoile">☆</a>
		</div>
	</div>
</div>

<!-- Modal pour supprimer un lieu -->
<div class="container">
	<div class="modal fade" id='deleteModal' role="dialog">
		<div class="modal-dialog modal-lg">
			<form class="modal-content" action="" method="post">
				<div class="modal-header">
					 <h4 class="modal-title"> Suppression d'un lieu </h4>
				</div>
				 
				<div class="modal-body">
					<p class="form-group">
				  		<label class="control-label" >Etes-vous sûr de vouloir supprimer le lieu "${place.privateLabel}"? </label>
				  	</p>
				  	
				  	<p class="form-group">
				  		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				  		<input type="hidden" name="id" value="${place.placeId}"/>
					  	<button type="button" class="btn btn-danger btn-sm" id="placeinfo-delete">Supprimer le lieu</button>
					</p>
				</div>
				 
				<div class="modal-footer">
					  <button type="button" class="btn btn-default " data-dismiss="modal">Annuler</button>
				</div>
			</form>
		</div>
	</div>
</div>

<!-- Modal pour modifier un lieu -->
<div class="container">
	<div class="modal fade" id='modifyModal' role="dialog">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					 <h4 class="modal-title"> Modification d'un lieu </h4>
				</div>
	
				<div class="modal-body">
					<form:form action="/appForMusic/modifyplace" method="POST" modelAttribute="ModifyPlaceForm" id="ModifyPlaceForm" name="modifyPlace">
						<p class="form-group">
							<form:label path="publicLabel" for="place-publiclabel" class="form-label">Nom public (Visible auprès de tous les utilisateurs)</form:label>
							<form:input type="text" path="publicLabel" id="place-publiclabel" class="form-control" placeholder="Nom public" value="<c:out value="${place.privateLabel}"/>"/>
						</p>
					
<!-- 					<p class="form-group"> -->
<%-- 						<form:label path="privateLabel" for="place-privatelabel" class="form-label">Nom privé</form:label> --%>
<%-- 						<form:input type="text" path="privateLabel" id="place-privatelabel" class="form-control" placeholder="Nom privé" required="true" value="${place.publicLabel}"/> --%>
<!-- 					</p> -->
					
<!-- 					<p class="form-group"> -->
<%-- 						<form:label path="street" for="place-street" class="form-label">Rue</form:label> --%>
<%-- 						<form:input type="text" name="street" path="street" id="place-street" class="form-control" placeholder="Rue" required="true" value="${place.street}"/> --%>
<!-- 					</p> -->
	
<!-- 					<p class="form-group"> -->
<%-- 						<form:label path="zipcode" for="place-zipcode" class="form-label">Code Postal</form:label> --%>
<%-- 						<form:input type="number" name="zipcode" path="zipcode"  id="place-zipcode" class="form-control" placeholder="Code Postal" required="true" value="${place.zipcode}"/> --%>
<!-- 					</p> -->
	
<!-- 					<p class="form-group"> -->
<%-- 						<form:label path="city" for="place-city" class="form-label">Ville</form:label> --%>
<%-- 						<form:input type="text" name="city" path="city" id="place-city" class="form-control" placeholder="Ville" required="true" value="${place.street}"/> --%>
<!-- 					</p> -->
					
<!-- 					<p class="form-group"> -->
<%-- 						<form:label path="latitude" for="place-latitude" class="col-sm-2 control-label">Latitude:</form:label> --%>
<%-- 						<form:input type="text" path="latitude" id="latitude" class="form-control" readonly="true"/> --%>
<!-- 					</p> -->
							
<!-- 					<p class="form-group"> -->
<%-- 						<form:label path="longitude" for="place-latitude" class="col-sm-2 control-label">Longitude:</form:label> --%>
<%-- 						<form:input type="text" path="longitude" id="longitude" class="form-control" readonly="true"/> --%>
<!-- 					</p> -->
					
<!-- 					<p class="form-group"> -->
<%-- 						<form:label path="description" for="place-description" class="col-sm-2 control-label">Description</form:label> --%>
<%-- 						<form:textarea rows="10" cols="20" path="description" id="description" class="form-control"/> --%>
<!-- 					</p> -->
					
						<p class="form-group">
							<input type="submit" name="modifier" value="Modifier" class="btn btn-primary btn-md" />
						</p>
					
<%-- 					<form:input type='hidden' path="placeId" name="placeId" id="placeId" class="form-control" value="${place.placeId}"/> --%>
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				</form:form>
				</div>
			
				<div class="modal-footer">
					<button type="button" class="btn btn-default " data-dismiss="modal">Annuler</button>
				</div>
			</div>
		</div>
	</div>
</div>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBH8dHLUHMkDTWfuiLOxhySJpQtXTp7mFU&callback=initGoogleMap"></script>




				  