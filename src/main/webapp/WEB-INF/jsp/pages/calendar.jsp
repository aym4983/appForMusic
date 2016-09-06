<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<c:url value="${ urlCalendar }" var="urlCalendar" />

<h2>Calendrier</h2>
<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModalHorizontal">Ajouter</button>
<div id='calendar'></div>

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
				<form class="form-horizontal" role="form">
					<div class="form-group">
						<label class="col-sm-3 control-label" for="inputStartEvent">Heure de début</label>
						<div class="col-sm-9 clockpicker" data-placement="left" data-align="top" data-autoclose="true">
							<input type="text" class="form-control" id="inputStartEvent" value="" />
							<input type="hidden" id="eventStartTime" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label" for="inputEndEvent">Heure de fin</label>
						<div class="col-sm-9 clockpicker" data-placement="left" data-align="top" data-autoclose="true">
							<input type="text" class="form-control" id="inputEndEvent" value="" />
							<input type="hidden" id="eventEndTime" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label" for="inputTitleEvent">Titre</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="inputTitleEvent" placeholder="Nom de l'evenement" />
						</div>
					</div>
				</form>
			</div>

			<!-- Modal Footer -->
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Annuler</button>
				<button type="button" class="btn btn-primary">Enregistrer</button>
			</div>
		</div>
	</div>
</div>





