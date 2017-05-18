<jsp:root version="1.2" xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:display="urn:jsptld:http://displaytag.sf.net"
	xmlns:c="http://java.sun.com/jsp/jstl/core">
	<jsp:directive.page contentType="text/html; charset=UTF8" />
	<jsp:scriptlet></jsp:scriptlet>
	
	
	<form method="post" action="/TPJavaEE/identification">
            <fieldset>
                <legend>login</legend>
                <p>Veuillez entrer vos identifiants</p>
				<p>
                	<label for="login">login</label>
                	<input type="text" id="login" name="login" value="" size="20" maxlength="60" />
				</p>
				<p>
               		<label for="motdepasse">Mot de passe</label>
                	<input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
				</p>
				<p>
                	<input type="submit" value="envoyer" />
				</p>
            </fieldset>
        </form>

</jsp:root>