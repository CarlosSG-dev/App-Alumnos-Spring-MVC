<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc"%>
<%@ include file="../jspf/header.jspf" %>
<%@ include file="../jspf/nav.jspf" %>

	<div class="container">
		<H1><spring:message code="usuarioImagen.titulo" /></H1>
		
		<p> <font color="red">${errores}</font></p>
		
			
				<img src="imagenUsuario/${loginNickName}" style="width:150px;height:150px" class="rounded-circle"/>
				<br>
				<mvc:form method="post" action="guardar-imagen-usuario" enctype="multipart/form-data" modelAttribute="imagenUsuario">
				<br>
				<mvc:hidden path="nickname" value="${loginNickName}"/>
				<mvc:label path="imagen"><spring:message code="usuarioImagen.explicacion" /></mvc:label>
				<br>
				<mvc:input path="imagen" type="file" /><form:errors path="imagen"/><br>
				<mvc:errors path="imagen" cssClass="text-warning"/>
				<br>
				<button type="submit" class="btn btn-success"><i class="fas fa-user-edit" >Modificar</i>&nbsp;<spring:message code="boton.anyadir" /></button>
			
		</mvc:form>
	</div>

<%@ include file="../jspf/footer.jspf" %>