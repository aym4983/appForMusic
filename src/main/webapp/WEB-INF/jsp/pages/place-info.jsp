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
			<label for="place-street" class="form-label">Nom privé (Visible que pour le propriétaire)</label>
			<input type="text" name="street" id="place-street" class="form-control" value="${place.privateLabel}" readonly/>
		</p>
		</c:if> 
		
		<div class="col-md-6">
			<label for="place-street" class="form-label">Nom publique</label>
			<input type="text" name="street" id="place-street" class="form-control" value="${place.publicLabel}" readonly/>
		</div>

		<div class="col-md-4">
			<label class="form-label">Rue</label>
			<input type="text" name="street" id="place-street" class="form-control" value="${place.street}" readonly/>
		</div>
						
		<div class="col-md-2">
			<label class="form-label">Code Postal</label>
			<input name="zipcode" id="place-zipcode" class="form-control" value="${place.zipcode}" readonly/>
		</div>
		
		<div class="col-md-5">
			<label  for="place-city" class="form-label">Ville</label>
			<input type="text" name="city"  id="place-city" class="form-control" placeholder="Ville" value="${place.city}" readonly/>
		</div>
							
		<div class="col-md-7">
			<label  for="place-description" class="control-label" >Description</label>
			<textarea cols="15" rows="10" id="description" class="form-control" name="description" readonly>${place.description}</textarea>
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
					<form:form action="" modelAttribute="">
				  		<div class="form-group">
							<label for="place-street" class="form-label">Nom privé</label>
							<input type="text" name="street" id="place-street" class="form-control" value="${place.privateLabel}" required/>
						</div>

						<div class="form-group">
							<label for="place-street" class="form-label">Nom publique</label>
							<input type="text" name="street" id="place-street" class="form-control" value="${place.publicLabel}" required/>
						</div>

						<div class="form-group">
							<label class="form-label">Rue</label>
							<input type="text" name="street" id="place-street" class="form-control" value="${place.street}" required/>
						</div>
						
						<div class="form-group">
							<label class="form-label">Code Postal</label>
							<input name="zipcode" id="place-zipcode" class="form-control" value="${place.zipcode}" required/>
						</div>
		
						<div class="form-group">
							<label  for="place-city" class="form-label">Ville</label>
							<input type="text" name="city"  id="place-city" class="form-control" placeholder="Ville" value="${place.city}" required/>
						</div>
							
						<div class="form-group">
							<label  for="place-description" class="control-label" >Description</label>
							<textarea cols="15" rows="10" id="description" class="form-control" name="description" required>${place.description}</textarea>
						</div>
						
						<input type="submit" name="place" value="Modifier" class="btn btn-primary btn-md" />
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
<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBH8dHLUHMkDTWfuiLOxhySJpQtXTp7mFU&callback=initGoogleMap"></script>


				  