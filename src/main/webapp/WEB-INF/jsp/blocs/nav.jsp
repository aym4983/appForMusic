<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<c:url var="urlSignOut" value="/sign-out" />
<c:url var="urlProfil" value="/profile" />
<c:url var="urlHome" value="/" />
<c:url var="urlPlaces" value="/places" />
<c:url var="urlContacts" value="/contacts" />
<c:url var="urlPlaces" value="/places" />
<c:url var="urlSettings" value="/settings" />
<c:url var="urlHelp" value="/help" />
<c:url var="urlCalendar" value="/calendar" />

<nav id="main-menu">

	<header id="main-menu-header">
		<div id="account">
			<a id="account-picture" href="${ urlProfil }/@<sec:authentication property="principal.username" />" title="Mon compte">
				<img src="" alt="" /></a>
		</div>
	</header>
	
	<section>
		<ul class="menu">
			<li><a href="${ urlHome }" title="Accueil">Accueil</a></li>
		</ul>
		<ul class="menu">
			<li><a href="${ urlPlaces }" title="Lieux">Lieux</a></li>
			<li><a href="${ urlCalendar }" title="Calendar">Calendrier</a></li>
		</ul>
		<ul class="menu">
			<li>
				<a href="${ urlSignOut }" id="menu-sign-out" title="Déconnexion" class="sign-out">Déconnexion</a>
			</li>
		</ul>
	</section>
</nav>