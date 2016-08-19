<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<c:url var="urlSearch" value="/search" />

<form method="get" action="${ urlSearch }" id="search-container" class="container-fluid">

	<p class="form-group">
		<input type="text" name="search" id="search-input" class="form-control" /></p>
	
	<section id="search-result">
	</section>
	
</form>
