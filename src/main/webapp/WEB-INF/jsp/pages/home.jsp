<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:url var="urlPlacesNear" value="api/places/near" />
<c:url var="urlPlaces" value="/places" />

<section id="places-map"></section>

<section id="places-list">
	<button id="places-list-toggler"></button>
	<ul>
		<c:forEach items="${ places }" var="place">
			<li data-place-id="<c:out value="${ place.placeId }" />" 
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
<script type="text/javascript">
	var app = {};
	var map;

	function initGoogleMap() {
		map = new google.maps.Map(document.getElementById("places-map"), {
			center: {lat: 47.4698, lng: -0.5593},
			zoom: 12
		});

		$("#places-list li").each(function() {
			new google.maps.Marker({
				position: {
					lat: Number.parseFloat($(this).data("place-lat")), 
					lng: Number.parseFloat($(this).data("place-lng"))
				},
				map: map,
				title: $(this).data("place-label")
			});
		});
	}
</script>
<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBH8dHLUHMkDTWfuiLOxhySJpQtXTp7mFU&callback=initGoogleMap"></script>