<jsp:root version="1.2" xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:display="urn:jsptld:http://displaytag.sf.net"
	xmlns:c="http://java.sun.com/jsp/jstl/core">
	<jsp:directive.page contentType="text/html; charset=UTF8" />
	<jsp:scriptlet></jsp:scriptlet>

	<c:choose>
		<c:when test="${empty isConnected}">
			<c:set var="jeton" value="${false}" scope="page">
			</c:set>
		</c:when>
		<c:otherwise>
			<c:set var="jeton" value="${isConnected}" scope="page">
			</c:set>
		</c:otherwise>
	</c:choose>

	<c:choose>
		<c:when test="${jeton}">
			<p>Connecté</p>
			<p>
				Utilisateur : 
				<c:out value="${login}" />
			</p>
		</c:when>
		<c:otherwise>
			<p>Déconnecté</p>
			<p>Utilisateur inconnu</p>
		</c:otherwise>
	</c:choose>

	<ul id="menu">
		<c:choose>
			<c:when test="${jeton}">
				<li><a href="/TPJEE/logout">logout</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="/TPJEE/login">login</a></li>
			</c:otherwise>
		</c:choose>
		<li><a href="/TPJEE/secured/recuperationcontacts">Afficher les contacts</a></li>
		<li><a href="/TPJEE/secured/saisircontact">Saisir un	contact</a></li>
		<li><a href="/TPJEE/secured/deletecontact">Supprimer un contact</a></li>
	</ul>

</jsp:root>