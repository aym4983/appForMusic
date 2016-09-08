<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<c:url var="commonCSS" value="/wro/common_css.css" />
<c:url var="appCSS" value="/css/app.css" />
<c:url var="appHeaderCSS" value="/css/app.header.css" />
<c:url var="appNavCSS" value="/css/app.nav.css" />
<c:url var="appSearchCSS" value="/css/app.search.css" />
<c:url var="appPageProfileCSS" value="/css/app.page.home.css" />
<c:url var="appPageHomeCSS" value="/css/app.page.profile.css" />

<c:url var="commonJS" value="/wro/common_js.js" />
<c:url var="appJS" value="/js/app.js" />
<c:url var="place" value="/js/place.js" />

<!DOCTYPE html>

<html>

	<head>
	    <meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
	    
	    <title><c:out value="${ pageTitle }" /> &#124; App for music</title>
	    
	    <link rel="stylesheet" type="text/css" href="${ commonCSS }"/>
	    <link rel="stylesheet" type="text/css" href="${ appCSS }"/>
	    <link rel="stylesheet" type="text/css" href="${ appHeaderCSS }"/>
	    <link rel="stylesheet" type="text/css" href="${ appNavCSS }"/>
	    <link rel="stylesheet" type="text/css" href="${ appSearchCSS }"/>
	    <link rel="stylesheet" type="text/css" href="${ appPageHomeCSS }"/>
	    <link rel="stylesheet" type="text/css" href="${ appPageProfileCSS }"/>
	    
	    <script type="text/javascript" src="${ commonJS }"></script>
	    <script type="text/javascript" src="${ appJS }"></script>
	    <script type="text/javascript" src="${ place }"></script>
	</head>
	
	<body>
		<div id="main-wrapper">
			<tiles:insertAttribute name="header" />
			<tiles:insertAttribute name="search" />
			<tiles:insertAttribute name="navigation" />
			
			<div id="main-container">
				<tiles:insertAttribute name="body" />
				<tiles:insertAttribute name="footer" />
			</div>
		</div>
	
	</body>
	
</html>