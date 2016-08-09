<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:url value="${ urlSignIn }" var="urlSignIn" />

<form:form action="" method="post" modelAttribute="appUser" id="signup">

	<p class="form-group">
		<form:label path="username" for="signup-username">Identifiant</form:label>
		<form:input path="username" id="signup-username" class="form-control" placeholder="Identifiant"/></p>
	
	<p class="form-group">
		<form:label path="email" for="signup-email">Adresse e-mail</form:label>
		<form:input path="email" id="signup-email" class="form-control" placeholder="Adresse e-mail"/></p>
	
	<p class="form-group">
		<label for="signup-password">Mot de passe</label>
		<input type="password" name="password" id="signup-password" class="form-control" placeholder="Mot de passe"/></p>
	
	<p class="form-group">
		<label for="signup-password-confirm">Confirmation mot de passe</label>
		<input type="password" name="password-confirm" id="signup-password-confirm" class="form-control" placeholder="Confirmation mot de passe"/></p>
	
	<p><input type="submit" name="signup" value="Inscription" class="btn btn-primary" />
		<a href="${ urlSignIn }" class="btn btn-default">J'ai déjà un compte.</a></p>
	
</form:form>