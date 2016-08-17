<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url var="commonCSS" value="/wro/common_css.css" />
<c:url var="commonJS" value="/wro/common_js.js" />

<!DOCTYPE html>

<html>

	<head>
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	    <title><c:out value="${ pageTitle }" /> &#124; App for music</title>
	    <link rel="stylesheet" type="text/css" href="${ commonCSS }"/>
	    <script type="text/javascript" src="${ commonJS }"></script>
	</head>
	
	<body>
		<div id="wrapper" class="container-fluid">
			<tiles:insertAttribute name="body" />
		</div>
	</body>
	
</html>