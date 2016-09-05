<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:url value="${ urlPlace }" var="urlPlace" />

<script src="http://maps.google.com/maps?file=api&amp;v=2&amp;sensor=false&amp;key=AIzaSyBH8dHLUHMkDTWfuiLOxhySJpQtXTp7mFU"type="text/javascript"></script>


<h2>Mes Lieux</h2>
<p class="placelist">
	<c:if test="${fn:length(places) == 0}">
   		<p>Vous n'avez pas encore de lieux!</p>
	</c:if>
	<c:forEach items="${places}" var="place">
		<div data-id="${place.placeId}">
			<c:if test="${empty place.privateLabel}">
    			<div>Nom public : <c:out value="${place.publicLabel}"/></div>
			</c:if>
			
			<c:if test="${not empty place.privateLabel}">
    			<div>Nom : <c:out value="${place.privateLabel}"/></div>
			</c:if>
			
			<div>Rue : <c:out value="${place.street}"/></div>
			<div>Code Postal : <c:out value="${place.zipcode}"/></div>
			<div>Ville : <c:out value="${place.city}"/></div>
			<button class="skill-delete"> Supprimer</button>
		</div>
	</c:forEach>
</p>


<div class="container">
<!--   <h2>Modal Example</h2> -->
  <!-- Trigger the modal with a button -->
  <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Ajouter un lieu</button>

  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-lg">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Ajouter un lieu</h4>
        </div>
        <div class="modal-body">
         	<form:form action="/appForMusic/places" method="post" modelAttribute="placeForm" id="createPlace" >
				<p class="col-xs-8">
					<form:label path="publicLabel" for="place-publiclabel">Nom du lieu</form:label>
					<form:input path="publicLabel" id="place-publiclabel" class="form-control" placeholder="Titre"/>
				</p>
	
				<div class="form-inline">
					<p class="col-xs-5">
						<form:label path="street" for="place-street">Rue</form:label>
						<form:input name="street" path="street" id="place-street" class="form-control" placeholder="Rue"/>
					</p>

					<p class="col-xs-3">
						<form:label path="zipcode" for="place-zipcode">Code Postal</form:label>
						<form:input name="zipcode" path="zipcode"  id="place-zipcode" class="form-control" placeholder="Code Postal"/>
					</p>

					<p class="col-xs-4">
						<form:label path="city" for="place-city">Ville</form:label>
						<form:input name="city" path="city" id="place-city" class="form-control" placeholder="Ville"/>
					</p>
				</div>
				
				<p class="form-group">
					<form:label path="latitude" for="place-latitude" class="col-sm-2 control-label">Latitude:</form:label>
					<form:input path="latitude" id="lat" class="form-control" readonly="true"/>
<!-- 				<em id="lat_rad" style="color:#555; font-size:0.9em;"></em> -->
				</p>
						
				<p class="form-group">
					<form:label path="longitude" for="place-latitude" class="col-sm-2 control-label">Longitude:</form:label>
					<form:input path="longitude" id="lon" class="form-control" readonly="true"/>
<!-- 					<em id="lon_rad" style="color:#555; font-size:0.9em;"></em> -->
				</p>
					
				<p class="col-xs-10">
					<form:label path="type" for="place-type"><strong>Type:</strong></form:label>
					<form:radiobutton path="type" value="private"/> Privé
					<form:radiobutton path="type" value="public" checked="true" /> Public
				</p>
				
				<p>
					<input type="submit" name="place" value="Ajouter" class="btn btn-primary btn-sm" />
				</p>
			</form:form>           

        
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default " data-dismiss="modal">Fermer</button>
        </div>
      </div>
      
    </div>
  </div>
  
</div>