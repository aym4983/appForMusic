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
							<form:input path="startevent" type="text" id="hiddenStartEvent" />
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
					
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				</form:form>
			</div>
		</div>
	</div>
</div>





