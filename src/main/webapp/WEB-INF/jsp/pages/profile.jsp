<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<c:url var="postForm" value="/profile/@${ username }" />
<c:url var="urlImg" value="/img" />

<section id="profile-header">
	<picture>
		<source srcset="${ urlImg }/default-cover-1080.jpg" media="(min-width: 960px)" />
		<source srcset="${ urlImg }/default-cover-1024.jpg" media="(min-width: 640px)" />
		<source srcset="${ urlImg }/default-cover-640.jpg" media="(min-width: 480px)" />
		<source srcset="${ urlImg }/default-cover-480.jpg" media="(min-width: 320px)" />
		<img id="profile-cover" src="${ urlImg }/default-cover-320.jpg" alt="" />
	</picture>
	<div id="profile-header-content">
		<div id="profile-picture"></div>
		<h1>${ username }</h1>
	</div>
</section>

<form:form modelAttribute="fullUserForm" action="${ postForm }" method="post" class="form-horizontal col-lg-6 col-lg-offset-3">
	
	<div class="form-group">
		<form:label path="firstName" class="control-label col-sm-4">Prénom</form:label>
		<div class="col-sm-8">
			<c:choose>
				<c:when test="${ isAuthUser }">
					<form:input path="firstName" class="form-control" placeholder="Prénom" value="${ user.firstname }" />
				</c:when>
				<c:otherwise>
					<p class="form-control-static"><c:out value="${ user.firstname }" /></p>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	
	<div class="form-group">
		<form:label path="lastName" class="control-label col-sm-4">Nom</form:label>
		<div class="col-sm-8">
			<c:choose>
				<c:when test="${ isAuthUser }">
					<form:input path="lastName" class="form-control" placeholder="Nom" value="${ user.lastname }" />
				</c:when>
				<c:otherwise>
					<p class="form-control-static"><c:out value="${ user.lastname }" /></p>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	
	<c:if test="${ isAuthUser }" >
	
		<div class="form-group">
			<form:label path="email" class="control-label col-sm-4">Adresse e-mail</form:label>
			<div class="col-sm-8">
				<form:input path="email" type="email" class="form-control" placeholder="Adresse e-mail" value="${ user.email }" />
			</div>
		</div>
	
		<p class="text-right"><input type="submit" name="profile-update-infos" class="btn btn-primary" value="Modifier mes informations" /></p>
		
		<hr />
	
		<div class="form-group">
			<form:label path="password" class="control-label col-sm-4">Mot de passe</form:label>
			<div class="col-sm-8">
				<form:input path="password" type="password" class="form-control" placeholder="Mot de passe" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label path="newPassword" class="control-label col-sm-4">Nouveau mot de passe</form:label>
			<div class="col-sm-8">
				<form:input path="newPassword" type="password" class="form-control" placeholder="Nouveau mot de passe" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label path="passwordConfirm" class="control-label col-sm-4">Confirmation mot de passe</form:label>
			<div class="col-sm-8">
				<form:input path="passwordConfirm" type="password" class="form-control" placeholder="Confirmation mot de passe" />
			</div>
		</div>
	
		<p class="text-right"><input type="submit" name="profile-update-pass" class="btn btn-primary" value="Modifier mon mot de passe" /></p>
	
	</c:if>
	
</form:form>