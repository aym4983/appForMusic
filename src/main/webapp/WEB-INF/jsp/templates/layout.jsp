<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<c:url var="commonCSS" value="/wro/common_css.css" />
<c:url var="commonJS" value="/wro/common_js.js" />

<!DOCTYPE html>

<html>

	<head>
	    <meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
	    <title><c:out value="${ pageTitle }" /> &#124; App for music</title>
	    <link rel="stylesheet" type="text/css" href="${ commonCSS }"/>
	    <link rel="stylesheet" type="text/css" href="./css/main-menu.css"/>
	    <link rel="stylesheet" type="text/css" href="./css/app.css"/>
	    <script type="text/javascript" src="${ commonJS }"></script>
	    <script type="text/javascript" src="./js/app.js"></script>
	    <script type ="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
	    <script type="text/javascript" src="./js/place.js"></script>
	</head>
	
	<body>
		<div id="main-wrapper">
			<tiles:insertAttribute name="navigation" />
			
			<div id="main-container">
				<tiles:insertAttribute name="header" />
				<tiles:insertAttribute name="body" />
				<tiles:insertAttribute name="footer" />
			</div>
		</div>
		
		<script type="text/javascript">
			var app = {};
			var map;

			function initGoogleMap() {
				map = new google.maps.Map(document.getElementById("places-map"), {
					center: new google.maps.LatLng(47.4698, -0.5593),
					zoom: 8
				});
			}
		</script>
	    <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBH8dHLUHMkDTWfuiLOxhySJpQtXTp7mFU&callback=initGoogleMap"></script>
	</body>
	
</html>