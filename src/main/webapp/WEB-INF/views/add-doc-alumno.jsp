<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<%@ include file="../jspf/header.jspf"%>
<%@ include file="../jspf/nav.jspf"%>
<div class="container">

<p>Introduzca los datos: </p>
	
<mvc:form action="add-doc-alumno" method="post" modelAttribute="docAlumno">
		
		<mvc:errors path="*" cssClass="text-warning"></mvc:errors>
		<input name="dni" type="hidden" value="${alumno.getDni()} }">
		<div class="form-row">
			<div class="col">
				<mvc:label path="id">Id:</mvc:label>
				<mvc:input class="form-control" readonly="readonly" path="id" id="id" name="id"></mvc:input>
			
				<mvc:label path="comentario">Comentario</mvc:label>
				<mvc:textarea path="comentario" rows="2" cols="70"/>
			</div>
			<div class="col">
				<mvc:label path="tipo">Tipo:</mvc:label>
				<ul>
					<mvc:radiobuttons path="tipo" items="${opcionesTipoDoc}" element="p"/>
				</ul>
			</div>
		
		
			<div class="col">
				<br>
				<input type="submit" id="submit" class="btn btn-success" value="Añadir">
			</div>
			</div>
	</mvc:form>
</div>
<%@ include file="../jspf/footer.jspf"%>
