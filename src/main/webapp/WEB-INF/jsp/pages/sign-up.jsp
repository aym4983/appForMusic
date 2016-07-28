<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:url name="url.base" value="/" />

<form:form action="${ url.base }" method="post">

	<p class="form-group">
		<form:label path="userName"></form:label>
		<form:input path="userName" id="signup-username" class="form-control"/></p>
	
	<p class="form-group">
		<form:label path="email"></form:label>
		<form:input path="email" id="signup-email" class="form-control"/></p>
	
	<p class="form-group">
		<form:label path="password"></form:label>
		<form:input path="password" id="signup-password" class="form-control"/></p>
	
	<p class="form-group">
		<form:label path="password-confirm"></form:label>
		<form:input path="password-confirm" id="signup-password-confirm" class="form-control"/></p>
	
	<p><input type="submit" name="signup" value="Connexion" class="btn btn-primary" /></p>
	
</form:form>