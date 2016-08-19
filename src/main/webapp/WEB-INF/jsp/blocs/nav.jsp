<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url var="urlSignOut" value="/sign-out" />
<c:url var="urlProfil" value="/profile" />
<c:url var="urlHome" value="/" />
<<<<<<< Upstream, based on origin/master
<c:url var="urlPlaces" value="/places" />
<c:url var="urlContacts" value="/contacts" />
<c:url var="urlPlaces" value="/places" />
<c:url var="urlSettings" value="/settings" />
<c:url var="urlHelp" value="/help" />

<nav id="main-menu">

	<header id="main-menu-header">
        <a href="#main-wrapper" title="Ouvrir le menu" id="main-menu-toggler" class="glyphicon glyphicon-menu-hamburger"></a>
        <a href="#" title="Fermer le menu" id="main-menu-untoggler" class="glyphicon glyphicon-remove"></a>
        
		<div id="account">
			<a href="${ urlSignOut }" title="Déconnexion" id="account-signout"></a>
			<a id="account-picture" href="${ urlProfil }" title="Mon compte">
				<img src="" alt="" /></a>
		</div>
	</header>
	
	<section>
		<ul class="menu">
			<li><a href="${ urlHome }" title="Accueil">Accueil</a></li>
		</ul>
		<ul class="menu">
			<li><a href="${ urlContacts }" title="Contacts">Contacts</a></li>
			<li><a href="${ urlPlaces }" title="Lieux">Lieux</a></li>
		</ul>
		<ul class="menu">
			<li><a href="${ urlSettings }" title="Paramètres">Paramètres</a></li>
			<li><a href="${ urlHelp }" title="Aide">Aide</a></li>
		</ul>
	</section>
	<ul class="sidebar-nav">
		<li><a href="${ urlHome }">Accueil</a></li>
		<li><a href="${ urlProfile }">Mon Profil</a></li>
		<li><a href="${ urlPlace }">Mes Lieux</a></li>
		<li><a href="${ urlContact }">Contact</a></li>
	</ul>
</nav>