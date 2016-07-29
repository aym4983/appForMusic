<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:url value="${ url.signUp }" var="url.signUp" />

<form:form action="" method="post">

	<p class="form-group">
		<form:label path="userName" for="signup-username">Identifiant</form:label>
		<form:input path="userName" id="signup-username" class="form-control" placeholder="Identifiant"/></p>
	
	<p class="form-group">
		<form:label path="password" for="signup-password">Mot de passe</form:label>
		<form:input path="password" id="signup-password" class="form-control" placeholder="Mot de passe"/></p>
	
	<p><input type="submit" name="signup" value="Connexion" class="btn btn-primary" />
		<a href="${ url.signUp }" class="btn btn-default">Je n'ai pas de compte.</a></p>
	
</form:form>