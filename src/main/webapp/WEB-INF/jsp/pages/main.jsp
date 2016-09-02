<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<section id="places-map">
	<script type="text/javascript">
		var app = {};
		var map;

		function initGoogleMap() {
			map = new google.maps.Map(document.getElementById("places-map"), {
				center: new google.maps.LatLng(47.4698, -0.5593),
				zoom: 12
			});
		}
	</script>
    <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBH8dHLUHMkDTWfuiLOxhySJpQtXTp7mFU&callback=initGoogleMap"></script>
</section>

<section id="places-list">
	<button id="places-list-toggler"></button>
	<ul>
		<li><a href="">Lorem</a></li>
		<li><a href="">Ipsum</a></li>
		<li><a href="">Dolor</a></li>
		<li><a href="">Sit</a></li>
		<li><a href="">Amet</a></li>
		<li><a href="">Consectetur</a></li>
	</ul>
</section>

