<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<c:url var="urlFormAction" value="/search/all" />
<c:url var="urlUser" value="/user" />
<c:url var="urlPlace" value="/place" />

<header id="main-header">
	
	<section class="clearfix">
		<button id="siderbar-toggler" class="btn btn-default pull-left glyphicon glyphicon-menu-hamburger"></button>
		<form action="${ urlFormAction }" method="get" class="pull-right col-xs-10 col-sm-8 col-md-6 col-lg-4">
			<div class="input-group">
				<span class="input-group-addon">&#128270;</span>
				<input type="text" name="main-search" id="main-search" class="form-control " />
			</div>
		</form>
	</section>
	
	<section id="search-results" class="container-fluid clearfix">
		<script id="mustache-tmpl-users" type="x-tmpl-mustache">
			{{#users}}
				<li><a href="${ urlUser }/{{username}}">
						<img src="" alt="" />
						{{firstname}} {{lastname}}
						<small>@{{username}}</small></a></li>
			{{/users}}

			{{^users}}
				<li>Aucun utilisateur n'a été trouvé</li>
			{{/users}}
		</script>
		<script id="mustache-tmpl-places" type="x-tmpl-mustache">
			{{#places}}
				<li><a href="${ urlPlace }/{{id}}">{{publicLabel}}</a></li>
			{{/places}}

			{{^places}}
				<li>Aucun lieu n'a été trouvé</li>
			{{/places}}
		</script>
		
		<div class="row">	
			<section id="result-set-users" class="result-set col-md-6">
				<h3>Utilisateurs</h3>
				<ul></ul>
			</section>
			<section id="result-set-places" class="result-set col-md-6">
				<h3>Lieux</h3>
				<ul></ul>
			</section>
		</div>
		
		<p class="row text-right"><a href="#">Recherche avancée</a></p>
	</section>
	
</header>
