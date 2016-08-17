<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url var="urlProfil" value="/profile" />
<c:url var="urlHome" value="/" />

<nav id="sidebar-wrapper">

	<header id="sidebar-header">
		<a id="profile-picture" href="${ urlProfil }" title="Mon profil">
			<img src="" alt="" /></a>
	</header>
	
	<ul class="sidebar-nav">
		<li><a href="${ urlHome }">Accueil</a></li>
		<li><a href=""></a></li>
	</ul>
	
</nav>