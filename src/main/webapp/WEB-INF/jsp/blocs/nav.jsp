<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url var="urlSignOut" value="/sign-out" />
<c:url var="urlProfil" value="/profile" />
<c:url var="urlHome" value="/" />
<c:url var="urlPlaces" value="/places" />
<c:url var="urlMyContacts" value="/my-contacts" />
<c:url var="urlMyPlaces" value="/my-places" />
<c:url var="urlSettings" value="/settings" />
<c:url var="urlHelp" value="/help" />

<nav id="sidebar-wrapper">

	<header id="sidebar-header">
		<a href="${ urlSignOut }" title="Déconnexion">Déconnexion</a>
		<a id="profile-picture" href="${ urlProfil }" title="Mon profil">
			<img src="" alt="" /></a>
	</header>
	
	<section id="sidebar-menu">
	
		<ul class="sidebar-nav">
			<li><a href="${ urlHome }"><span class="glyphicon glyphicon-home"></span> Accueil</a></li>
			<li><a href="${ urlPlaces }"><span class="glyphicon glyphicon-map-marker"></span> Lieux</a></li>
		</ul>
		
		<ul class="sidebar-nav">
			<li><a href="${ urlMyContacts }"><span class="glyphicon glyphicon-user"></span> Mes contacts</a></li>
			<li><a href="${ urlMyPlaces }"><span class="glyphicon glyphicon-map-marker"></span> Mes lieux</a></li>
		</ul>
		
		<ul class="sidebar-nav">
			<li><a href="${ urlSettings }"><span class="glyphicon glyphicon-wrench"></span> Paramètres</a></li>
			<li><a href="${ urlHelp }"><span class="glyphicon"></span> Aide</a></li>
		</ul>
	
	</section>
	
</nav>