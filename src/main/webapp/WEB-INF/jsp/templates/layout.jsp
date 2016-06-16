<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>appForMusic</title>
    <script src="<c:url value="/"/>/wro/common.js"></script>
</head>
<body>

<tiles:insertAttribute name="header"></tiles:insertAttribute>

<tiles:insertAttribute name="body"></tiles:insertAttribute>

<tiles:insertAttribute name="footer"></tiles:insertAttribute>

</body>
</html>