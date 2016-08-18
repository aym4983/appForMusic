<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:url value="${ urlSignIn }" var="urlSignIn" />

<form:form action="" method="post" modelAttribute="userForm" id="signup" class="col-md-4 col-md-offset-4">

    <h2>Inscription</h2>

	<p class="form-group">
		<form:label path="username" for="signup-username">Identifiant</form:label>
		<form:input path="username" id="signup-username" class="form-control" placeholder="Identifiant"/></p>
	
	<p class="form-group">
		<form:label path="email" for="signup-email">Adresse e-mail</form:label>
		<form:input path="email" id="signup-email" class="form-control" placeholder="Adresse e-mail"/></p>
	
	<p class="form-group">
		<form:label path="password" for="signup-password">Mot de passe</form:label>
		<form:password path="password"  id="signup-password" class="form-control" placeholder="Mot de passe"/></p>
	
	<p class="form-group">
		<form:label path="passwordConfirm" for="signup-password-confirm">Confirmation mot de passe</form:label>
		<form:password path="passwordConfirm" id="signup-password-confirm" class="form-control" placeholder="Confirmation mot de passe"/></p>
	
	<p><input type="submit" name="signup" value="Inscription" class="btn btn-block btn-primary" />
		<a href="${ urlSignIn }" class="btn btn-block btn-default">J'ai déjà un compte.</a></p>
	
</form:form>