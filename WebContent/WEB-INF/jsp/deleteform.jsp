<jsp:root version="1.2" xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:display="urn:jsptld:http://displaytag.sf.net"
	xmlns:c="http://java.sun.com/jsp/jstl/core">
	<jsp:directive.page contentType="text/html; charset=UTF8" />
	<jsp:scriptlet></jsp:scriptlet>

	<div id="head" class="header">
		<jsp:include page="/header"></jsp:include>
	</div>

	<div id="wrap" class="wraper">
		<form method="post" action="/TPJavaEE/secured/deletecontact">
			<fieldset>
				<legend>contact à supprimer</legend>
				<p>
					<select id="" name="contact">
						<c:forEach items="${contacts}" var="contact">
							<c:set var="c" value="${contact.prenom} ${contact.nom}: ${contact.numero}" />
							<option value="${contact.numero}">${c}</option>
						</c:forEach>
					</select>
				</p>
				<p>
					<input type="submit" value="Erase" />
				</p>
			</fieldset>
		</form>
	</div>

	<div id="foot" class="footer"></div>
</jsp:root>