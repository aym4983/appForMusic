<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script type="text/javascript">var contextPath='<c:url value="/"/>'</script>


<c:url value="${ urlCalendar }" var="urlCalendar" />

<h2>Calendrier</h2>
<!-- <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModalHorizontal">Ajouter</button> -->
<div id='calendar'>
</div>

<!-- Modal -->
<div class="modal fade" id="myModalHorizontal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content eventModal" id="modalEvent">

			<!-- Modal Header -->
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">&times;</span> <span class="sr-only">Fermer</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">Ajouter un evenement</h4>
			</div>

			<!-- Modal Body -->
			<div class="modal-body">
				<form:form action="/appForMusic/calendar" method="POST" modelAttribute="eventForm" id="FormEvent" class="form-horizontal"  >
					<div class="form-group">
						<label class="col-sm-3 control-label" for="inputDayEvent">Jour</label>						
						<div class="col-sm-9">
						    <input class="form-control" id="inputDayEvent" disabled="disabled"/>
						</div>
					</div>
					<div class="form-group">
						<form:label path="startevent" class="col-sm-3 control-label" for="inputStartEvent">Début</form:label>
						<div class="col-sm-9 clockpicker">
							<input  class="form-control" id="inputStartEvent" />
							<form:input path="startevent" type="hidden" id="hiddenStartEvent" />
						</div>
					</div>
					<div class="form-group">
						<form:label path="endevent" class="col-sm-3 control-label" for="inputEndEvent">Fin</form:label>
						<div class="col-sm-9 clockpicker">
							<input class="form-control" id="inputEndEvent" />
							<form:input path="endevent" type="hidden" id="hiddenEndEvent" />
						</div>
					</div>
					<div class="form-group">
						<form:label path="titleevent" class="col-sm-3 control-label" for="inputTitleEvent">Titre</form:label>
						<div class="col-sm-9">
							<form:input path="titleevent" class="form-control" id="inputTitleEvent" placeholder="Nom de l'evenement" />
						</div>
					</div>
					
					<!-- Modal Footer -->
					<div class="modal-footer">
						<button type="reset" class="btn btn-default" data-dismiss="modal">Annuler</button>
						<input type="submit" class="btn btn-primary" name="SaveEvent" value="Enregistrer" id="submitEvent"/>
					</div>
					
					<form:input type="hidden" id="placeId" path="placeId" class="form-control" name="placeId" value="${place.placeId}"/>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				</form:form>
			</div>
		</div>
	</div>
</div>

<!-- Modal pour supprimer un lieu -->
<div class="container">
	<div class="modal fade" id='deleteEvent' role="dialog">
		<div class="modal-dialog modal-lg">
			<form class="modal-content" action="" id="formEventDelete" method="post">
				<div class="modal-header">
					 <h4 class="modal-title"> Suppression d'un evenement</h4>
				</div>
				 
				<div class="modal-body">
					<p class="form-group">
				  		<label class="control-label" >Etes-vous sûr de vouloir supprimer l'évenement ? </label>
				  	</p>
				  	
				  	<p class="form-group">
				  		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				  		<input type="hidden" name="eventid" value="${calendar.eventid}"/>
					</p>
				</div>
				 
				<div class="modal-footer">
					<button type="button" class="btn btn-danger btn-sm" id="event-delete" onclick="eventDelete()">Supprimer</button>
					<button type="button" class="btn btn-default " data-dismiss="modal">Annuler</button>
				</div>
			</form>
		</div>
	</div>
</div>





