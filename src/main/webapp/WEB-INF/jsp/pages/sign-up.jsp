<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:url value="${ url.signIn }" var="url.signIn" />

<form:form action="" method="post" modelAttribute="appUser" id="signup">

	<p class="form-group">
		<form:label path="userName">Identifiant</form:label>
		<form:input path="userName" id="signup-username" class="form-control" placeholder="Identifiant"/></p>
	
	<p class="form-group">
		<form:label path="email"></form:label>
		<form:input path="email" id="signup-email" class="form-control" placeholder="Adresse e-mail"/></p>
	
	<p class="form-group">
		<form:label path="password"></form:label>
		<form:password path="password" id="signup-password" class="form-control" placeholder="Mot de passe"/></p>
	
	<p class="form-group">
		<label for="signup-password-confirm"></label>
		<input type="password" id="signup-password-confirm" class="form-control" placeholder="Confirmation"/></p>
	
	<p><input type="submit" name="signup" value="Inscription" class="btn btn-primary" />
		<a href="${ url.signIn }" class="btn btn-default">J'ai déjà un compte.</a></p>
	
</form:form>