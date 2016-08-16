<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:url value="${ urlSignUp }" var="urlSignUp" />

<form:form action="" method="post" modelAttribute="appUser" id="signin">

	<p class="form-group">
		<form:label path="username" for="signup-username">Identifiant</form:label>
		<form:input path="username" id="signup-username" class="form-control" placeholder="Identifiant"/></p>
	
	<p class="form-group">
		<label for="signup-password">Mot de passe</label>
		<input type="password" id="signup-password" class="form-control" placeholder="Mot de passe"/></p>
	
	<p><input type="submit" name="signup" value="Connexion" class="btn btn-primary" />
		<a href="${ urlSignUp }" class="btn btn-default">Je n'ai pas de compte.</a></p>
	
</form:form>