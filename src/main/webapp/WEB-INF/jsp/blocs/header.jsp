<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<header id="main-header">
	<button id="siderbar-toggler" class="btn btn-default glyphicon glyphicon-menu-hamburger pull-left"></button>
	<h1><c:out value="${ pageTitle }" /></h1>
	<button id="search-toggler" class="btn btn-default glyphicon glyphicon-search pull-right"></button>
</header>