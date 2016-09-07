<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<c:url var="postForm" value="/profile/@${ username }" />

<section id="profile-header">
	<div id="profile-cover"></div>
	<div id="profile-header-content">
		<div id="profile-picture"></div>
		<h1>${ user.username }</h1>
	</div>
</section>

<form:form modelAttribute="fullUserForm" action="${ postForm }" method="post" class="form-horizontal col-md-8">
	
	<div class="form-group">
		<form:label path="firstName" class="control-label col-md-4">Prénom</form:label>
		<div class="col-md-8">
			<form:input path="firstName" class="form-control" placeholder="Prénom" value="${ user.firstname }" />
		</div>
	</div>
	
	<div class="form-group">
		<form:label path="lastName" class="control-label col-md-4">Nom</form:label>
		<div class="col-md-8">
			<form:input path="lastName" class="form-control" placeholder="Nom" value="${ user.lastname }" />
		</div>
	</div>
	
	<div class="form-group">
		<form:label path="email" class="control-label col-md-4">Adresse e-mail</form:label>
		<div class="col-md-8">
			<form:input path="email" type="email" class="form-control" placeholder="Adresse e-mail" value="${ user.email }" />
		</div>
	</div>
	
	<div class="form-group">
		<form:label path="password" class="control-label col-md-4">Mot de passe</form:label>
		<div class="col-md-8">
			<form:input path="password" type="password" class="form-control" placeholder="Mot de passe" />
		</div>
	</div>
	
	<div class="form-group">
		<form:label path="newPassword" class="control-label col-md-4">Nouveau mot de passe</form:label>
		<div class="col-md-8">
			<form:input path="newPassword" type="password" class="form-control" placeholder="Nouveau mot de passe" />
		</div>
	</div>
	
	<div class="form-group">
		<form:label path="passwordConfirm" class="control-label col-md-4">Confirmation mot de passe</form:label>
		<div class="col-md-8">
			<form:input path="passwordConfirm" type="password" class="form-control" placeholder="Confirmation mot de passe" />
		</div>
	</div>
	
	<p><input type="submit" class="btn btn-primary btn-block" value="Modifier mes informations" /></p>
	
</form:form>