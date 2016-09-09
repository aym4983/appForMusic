<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:url var="urlPlacesNear" value="api/places/near" />
<c:url var="urlPlaces" value="/places" />

<section id="places-map"></section>

<section id="places-list" data-url-places-near="${ urlPlacesNear }">
	<button id="places-list-toggler"></button>
	<script id="place-item-template" type="x-tmpl-mustache">
		{{#content}}
		<li class="place-item"
			data-place-id="{{placeId}}"
			data-place-lat="{{latitude}}" 
			data-place-lng="{{longitude}}"
			data-place-label="{{publicLabel}}">
			<a href="${ urlPlaces }/{{placeId}}">
				{{publicLabel}}
			</a>
		</li>
		{{/content}}
	</script>
	<ul>
		<c:forEach items="${ places }" var="place">
			<li class="place-item"
				data-place-id="<c:out value="${ place.placeId }" />" 
				data-place-lat="<c:out value="${ place.latitude }" />" 
				data-place-lng="<c:out value="${ place.longitude }" />"
				data-place-label="<c:out value="${ place.publicLabel }" />">
				<a href="${ urlPlaces }/<c:out value="${ place.placeId }" />">
					<c:out value="${ place.publicLabel }" />
				</a>
			</li>
		</c:forEach>
	</ul>
</section>

<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBH8dHLUHMkDTWfuiLOxhySJpQtXTp7mFU&callback=initHomeMap"></script>