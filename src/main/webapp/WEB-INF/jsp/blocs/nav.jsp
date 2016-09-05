<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url var="urlSignOut" value="/sign-out" />
<c:url var="urlProfil" value="/profile" />
<c:url var="urlHome" value="/" />
<c:url var="urlPlaces" value="/places" />
<c:url var="urlContacts" value="/contacts" />
<c:url var="urlPlaces" value="/places" />
<c:url var="urlSettings" value="/settings" />
<c:url var="urlHelp" value="/help" />

<nav id="main-menu">

	<header id="main-menu-header">
        <button id="main-menu-toggler" class="glyphicon glyphicon-menu-hamburger" title="Ouvrir le menu"></button>
        
		<div id="account">
			<a href="${ urlSignOut }" title="Déconnexion" id="account-signout"></a>
			<a id="account-picture" href="${ urlProfil }" title="Mon compte">
				<img src="" alt="" /></a>
		</div>
	</header>

	
	<section>
		<form action="" method="get" class="menu">
			<p><input type="text" name="main-search" id="main-search" class="form-control" placeholder="Rechercher" /></p>
		</form>
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