<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:url value="${ urlPlace }" var="urlPlace" />
<script type="text/javascript">var contextPath='<c:url value="/"/>'</script>;
<script src="http://maps.google.com/maps?file=api&amp;v=2&amp;sensor=false&amp;key=AIzaSyBH8dHLUHMkDTWfuiLOxhySJpQtXTp7mFU"type="text/javascript"></script>

<div class="container">
	<h2>Mes Lieux <button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#myModal">Ajouter un lieu</button></h2>
	
	<p class="placelist">
		<c:if test="${fn:length(places) == 0}">
	   		<p>Vous n'avez pas encore de lieux!</p>
		</c:if>
		<c:forEach items="${places}" var="place">
    			<div class="col-md-4">
      				<div data-id="${place.placeId}" class="thumbnail">
<!--       					<a href="pulpitrock.jpg" > -->
							<c:if test="${empty place.privateLabel}">
	    						<div><strong><c:out value="${place.publicLabel}"/></strong></div>
							</c:if>
							<c:if test="${not empty place.privateLabel}">
				    			<div><strong><c:out value="${place.privateLabel}"/></strong></div>
							</c:if>
							</br>
							
							<form id="image_form" enctype='multipart/form-data'>
								<label class="image" for="image_upload">
									<img src="<c:url value="${image_path}"/>" id="image" style="width:150px;height:150px">
									<input id="image_upload" type="file" name="image_upload"><br><br>
								</label>
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
							</form>

<!-- 							<img src="no-image.jpg" alt="no-image" style="width:150px;height:150px"> -->
							</br>
     					 	<div class="">Rue : <c:out value="${place.street}"/></div> 
 							<div class="">Code Postal : <c:out value="${place.zipcode}"/></div> 
							<div class="">Ville : <c:out value="${place.city}"/></div>
							</br>
							
     					 	<button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="${place.placeId}">En Savoir plus</button>
     					 	<button type="button" id="place-delete" >Supprimer</button>
     					 	<button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="${place.placeId}">Modifier</button>
	
			        </div>
			       </div>	
		</c:forEach>
	</p>
</div>


<div class="container">
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
         	<form:form action="/appForMusic/places" method="post" modelAttribute="placeForm" id="createPlace" name="createPlace">
				<p class="form-group">
					<form:label path="publicLabel" for="place-publiclabel" class="form-label">Nom du lieu</form:label>
					<form:input type="text" path="publicLabel" id="place-publiclabel" class="form-control" placeholder="Titre" required="true"/>
				</p>
				
				<p class="form-group">
					<form:label path="street" for="place-street" class="form-label">Rue</form:label>
					<form:input type="text" name="street" path="street" id="place-street" class="form-control" placeholder="Rue" required="true"/>
				</p>

				<p class="form-group">
					<form:label path="zipcode" for="place-zipcode" class="form-label">Code Postal</form:label>
					<form:input type="number" name="zipcode" path="zipcode"  id="place-zipcode" class="form-control" placeholder="Code Postal" required="true"/>
				</p>

				<p class="form-group">
					<form:label path="city" for="place-city" class="form-label">Ville</form:label>
					<form:input type="text" name="city" path="city" id="place-city" class="form-control" placeholder="Ville" required="true"/>
				</p>
				
				<p class="form-group">
					<form:label path="latitude" for="place-latitude" class="col-sm-2 control-label">Latitude:</form:label>
					<form:input type="text" path="latitude" id="lat" class="form-control" readonly="true"/>
<!-- 				<em id="lat_rad" style="color:#555; font-size:0.9em;"></em> -->
				</p>
						
				<p class="form-group">
					<form:label path="longitude" for="place-latitude" class="col-sm-2 control-label">Longitude:</form:label>
					<form:input type="text" path="longitude" id="lon" class="form-control" readonly="true"/>
<!-- 					<em id="lon_rad" style="color:#555; font-size:0.9em;"></em> -->
				</p>
				
				<p class="form-group">
					<form:label path="description" for="place-description" class="col-sm-2 control-label">Description</form:label>
					<form:textarea path="description" id="description" class="form-control"/>
				</p>

				<p class="form-group">
					<form:label path="type" for="place-type">Type:</form:label>
					<form:label path="type" class="radio-inline"><form:radiobutton path="type" name="optradio" value="private" checked="true"/>Privé</form:label>
					<form:label path="type" class="radio-inline"><form:radiobutton path="type" name="optradio"  value="public"/>Public</form:label>
				</p>
				
				<p class="form-group">
					<form:label path="image" for="place-image">Image:</form:label>
					<form:input path="image" for="place-image" id="place-image" type="file" name="place-image"/>
				</p>
				
				<p class="form-group">
					<input type="submit" name="place" value="Ajouter" class="btn btn-primary btn-sm" />
				</p>
				
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			</form:form>        
        </div>
        
        <div class="modal-footer">
          <button type="button" class="btn btn-default " data-dismiss="modal">Fermer</button>
        </div>
      </div>
      
    </div>
  </div>
</div>