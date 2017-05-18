<jsp:root version="1.2" xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:display="urn:jsptld:http://displaytag.sf.net"
	xmlns:c="http://java.sun.com/jsp/jstl/core">
	<jsp:directive.page contentType="text/html; charset=UTF8" />

		<display:table name="${contacts}">
			<display:column property="prenom"></display:column>
			<display:column property="nom"></display:column>
			<display:column property="numero"></display:column>
		</display:table>

</jsp:root>