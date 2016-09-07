<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<c:url var="urlFormAction" value="/search" />
<c:url var="urlJsonAction" value="/api/search/all" />
<c:url var="urlUser" value="/user" />
<c:url var="urlPlace" value="/place" />

<header id="main-header">
	<button id="main-menu-toggler" class="btn btn-default glyphicon glyphicon-menu-hamburger"></button>
	<form id="main-search-form" action="${ urlFormAction }" method="get" data-json-action="${ urlJsonAction }">
		<input type="text" id="main-search-field" name="q" placeholder="Rechercher" autocomplete="off" />
	</form>
</header>
