<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:url value="${ urlSignUp }" var="urlSignUp" />

<form:form action="" method="post" modelAttribute="appUser" id="signin" class="col-md-4 col-md-offset-4">

    <h2>Connexion</h2>

	<p class="form-group">
		<label for="signup-username">Identifiant</label>
		<input name="username" id="signup-username" class="form-control" placeholder="Identifiant"/></p>
	
	<p class="form-group">
		<label for="signup-password">Mot de passe</label>
		<input type="password" name="password" id="signup-password" class="form-control" placeholder="Mot de passe"/></p>
	
	<p><input type="submit" name="signup" value="Connexion" class="btn btn-block btn-primary" />
		<a href="${ urlSignUp }" class="btn btn-block btn-default">Je n'ai pas de compte.</a></p>
	
</form:form>