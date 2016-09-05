<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

	<h1>Mes Informations : </h1>
	<div id="user-info">
		<form:form action="/appForMusic/submitprofile" method="post" modelAttribute="userModifyForm" id="updateUser" class="col-md-4 col-md-offset-4">
			<p class="form-group">
				<form:label path="username" for="user-identifiant">Identifiant</form:label>
				<form:input path="username" id="user-identifiant" class="form-control" value="${user.username}" readonly="true"/>
			</p>
			
			<p class="form-group">
				<form:label path="email" for="user-email">Email</form:label>
				<form:input path="email" id="user-email" class="form-control" value="${user.email}"/>
			</p>
			
			<p class="form-group">
				<form:label path="firstname" for="user-firstname">Prénom</form:label>
				<form:input path="firstname" id="user-firstname" class="form-control" value="${user.firstname}"/>
			</p>
			
			<p class="form-group">
				<form:label path="lastname" for="user-lastname">Nom</form:label>
				<form:input path="lastname" id="user-lastname" class="form-control" value="${user.lastname}" />
			</p>
			
			<p>
				<input type="submit" name="button-profile" value="Modifier mes informations" class="btn btn-block btn-primary"/>
			</p>
	
		</form:form>
	</div>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:url var="postForm" value="/profile/@${ username }" />

<section id="profile-header">
	<div id="profile-cover"></div>
	<div id="profile-picture"></div>
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
	
	<p><input type="submit" class="btn btn-primary btn-block" value="Modifier mes informations" />
	</p>
	
</form:form>