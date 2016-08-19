<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<c:url var="urlFormAction" value="/search/all" />

<header id="main-header" class="">

	<button id="siderbar-toggler" class="btn btn-default pull-left glyphicon glyphicon-menu-hamburger"></button>
	
	<form action="${ urlFormAction }" method="get" class="pull-right col-xs-10 col-sm-8 col-md-6 col-lg-4">
		<div class="input-group">
			<span class="input-group-addon">&#128270;</span>
			<input type="text" name="main-search" id="main-search" class="form-control " />
		</div>
	</form>
	
</header>
	
<section id="search-results">
</section>
