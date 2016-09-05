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