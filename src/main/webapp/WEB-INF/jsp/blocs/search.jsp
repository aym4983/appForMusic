<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<c:url var="urlProfile" value="/profile" />
<c:url var="urlProfilePictures" value="/medias/profile" />
<c:url var="urlPlaces" value="/places" />
<c:url var="urlSearch" value="/search" />

<section id="main-search-results">
	<script id="mustache-tmpl-users" type="x-tmpl-mustache">
		{{#users}}
			<li class="result-item">
				<a href="${ urlProfile }/@{{username}}">
					<img src="@{{username}}.png" alt="" />
					{{firstname}} {{lastname}} @{{username}}
				</a>
			</li>
		{{/users}}
	</script>
	<script id="mustache-tmpl-places" type="x-tmpl-mustache">
		{{#places}}
			<li class="result-item">
				<a href="${ urlPlaces }/{{placeId}}">
					<img src="" alt="" />{{publicLabel}}
				</a>
			</li>
		{{/places}}
	</script>
	<script id="mustache-tmpl-more-users" type="x-tmpl-mustache">
		<li class="result-item result-more-items">
			<a href="${ urlSearch }/users/q={{query}}">Rechercher plus d'utilisateurs</a>
		</li>
	</script>
	<script id="mustache-tmpl-more-places" type="x-tmpl-mustache">
		<li class="result-item result-more-items">
			<a href="${ urlSearch }/users/q={{query}}">Rechercher plus de lieux</a>
		</li>
	</script>
	
	<div>
		<ul id="main-search-users" class="result-set"></ul>
		<ul id="main-search-places" class="result-set"></ul>
		<ul class="result-set">
			<li class="result-item result-more-items">
				<a href="${ urlSearch }">Recherche avancée</a>
			</li>
		</ul>
	</div>
</section>