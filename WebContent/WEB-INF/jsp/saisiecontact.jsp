<jsp:root version="1.2" xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:display="urn:jsptld:http://displaytag.sf.net"
	xmlns:c="http://java.sun.com/jsp/jstl/core">
	<jsp:directive.page contentType="text/html; charset=UTF8" />
	<jsp:scriptlet></jsp:scriptlet>

	<div id="head" class="header">
		<jsp:include page="/header"></jsp:include>
	</div>

	<div id="wrap" class="wraper">
		<form method="post" action="/TPJEE/secured/saisircontact">
			<fieldset>
				<legend>Contact creation</legend>
				<p>Please enter contact informations</p>
				<p>
					<label for="nom">last name</label> <input type="text" id="nom" name="nom"
						value="" size="20" maxlength="60" />
				</p>
				<p>
					<label for="prenom">first name</label> <input type="text" id="prenom"
						name="prenom" value="" size="20" maxlength="60" />
				</p>
				<p>
					<label for="numero">phone number</label> <input type="text" id="numero"
						name="numero" value="" size="20" maxlength="60" />
				</p>
				<p>
					<input type="submit" value="créer" />
				</p>
			</fieldset>
		</form>
	</div>

	<div id="foot" class="footer"></div>
</jsp:root>