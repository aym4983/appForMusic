<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<<<<<<< HEAD
<c:url var="urlFormAction" value="/search/all.json" />

<header id="main-header" class="">

	<button id="siderbar-toggler" class="btn btn-default pull-left glyphicon glyphicon-menu-hamburger"></button>
	
	<form action="${ urlFormAction }" method="get" class="pull-right col-xs-10 col-sm-8 col-md-6 col-lg-4">
		<div class="input-group">
			<span class="input-group-addon">&#128270;</span>
			<input type="text" name="main-search" id="main-search" class="form-control " />
		</div>
	</form>
	
</header>
	
<section id="search-results"></section>
=======
<header id="main-header">
	<button id="siderbar-toggler" class="btn btn-default glyphicon glyphicon-menu-hamburger pull-left"></button>
	<h1 class="pull-left"><c:out value="${ pageTitle } Lorem ipsum" /></h1>
	<button id="search-toggler" class="btn btn-default glyphicon glyphicon-search pull-right"></button>
</header>
>>>>>>> refs/remotes/origin/master_dhe
