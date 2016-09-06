<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<c:url value="${ urlCalendar }" var="urlCalendar" />

<h2>Calendrier</h2>
<!-- <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModalHorizontal">Ajouter</button> -->
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
				<form class="form-horizontal" role="form" id="formEvent">
					<div class="form-group">
						<label class="col-sm-3 control-label" for="inputDayEvent">Jour</label>						
						<div class="col-sm-9" data-provide="datepicker">
						    <input type="text" class="form-control" id="inputDayEvent" disabled="disabled">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label" for="inputStartEvent">Début</label>
						<div class="col-sm-9 clockpicker">
							<input type="text" class="form-control" id="inputStartEvent" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label" for="inputEndEvent">Fin</label>
						<div class="col-sm-9 clockpicker">
							<input type="text" class="form-control" id="inputEndEvent" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label" for="inputTitleEvent">Titre</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="inputTitleEvent" placeholder="Nom de l'evenement" />
						</div>
					</div>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				</form>
			</div>

			<!-- Modal Footer -->
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Annuler</button>
				<button type="button" class="btn btn-primary" id="submitEvent" onclick="doSubmit()">Enregistrer</button>
			</div>
		</div>
	</div>
</div>





