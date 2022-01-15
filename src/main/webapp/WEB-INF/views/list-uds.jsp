
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="webjars/bootstrap/4.5.2/css/bootstrap.min.css"
rel="stylesheet">
<title>Alumnos</title>

<style>
	.footer {
		position: absolute;
		bottom: 0;
		width: 100%;
		height: 60px;
		background-color: #f5f5f5;
	}
</style>
</head>

<body>

	<%@ include file="../jspf/header.jspf" %>
<%@ include file="../jspf/nav.jspf" %>

	<div class="container">
	
		<H1>Listado de Modulos:</H1>	
		<table class="table table-striped">
		<tr>
		<th> <a class="nav-link" href="list-modulo.do?orden=id">ID</a></th>
		<th><a class="nav-link" href="list-modulo.do?orden=nombre"><spring:message code="etiqueta.nombre" /></a></th>
		
		<th><a class="nav-link" href="list-modulo.do?orden=horas"><spring:message code="etiqueta.horas" /></a></th>
		<th><a class="nav-link" href="list-modulo.do?orden=abreviatura"><spring:message code="etiqueta.abreviatura" /></a></th>
		
		<th><spring:message code="etiqueta.accion" /></th>
		</tr>
		<c:forEach items="${modulos}"  var="modulo" >

			<tr>
				<td>${modulo.getId()}</td>
				<td>${modulo.getNombre()}</td>
				<td>${modulo.getHoras()}</td>
				<td>${modulo.getAbreviatura()}</td>
			<td><a href="del-modulo.do?id=${modulo.getId()}" class="btn btn-danger"><i class="fas fa-trash-alt"></i><spring:message code="boton.borrar" /></a></td>
			
				<td><a href="add-uds.do?id=${ud.getId()}" class="btn btn-primary"/><i class="fas fa-plus-square"></i><spring:message code="boton.anyadir" /></td>
			
			
			<%-- td><a href="del-modulo.do?id=${modulo.getId()}" class="btn btn-danger">Borrar</a></td> --%>
			</tr>
		</c:forEach>

	</table>
	
	<!-- <a href="/add-modulo.do" class="btn btn-success btn-block">Add Modulo</a> -->
	<H1>Listado de Unidades:</H1>
	<table class="table table-striped">
		<tr>
		<th> <a class="nav-link" href="list-uds.do?orden=id">ID</a></th>
		<th><a class="nav-link" href="list-uds.do?orden=nombre"><spring:message code="etiqueta.nombre" /></a></th>
		
		<th><a class="nav-link" href="list-uds.do?orden=horas"><spring:message code="etiqueta.horas" /></a></th>
		<th><a class="nav-link" href="list-uds.do?orden=orden">Orden</a></th>
		
		<th><spring:message code="etiqueta.accion" /></th>
		</tr>
		<c:forEach items="${udsModulos}" var="udsModulos">

			<tr>
				<td>${udsModulos.getIdModulo()}</td>
				<td>${udsModulos.getNombre()}</td>
				<td>${udsModulos.getHoras()}</td>
				<td>${udsModulos.getOrden()}</td>
			<td><a href="del-uds?id=${udsModulos.getId()}" class="btn btn-danger"><i class="fas fa-trash-alt"></i><spring:message code="boton.borrar" /></a></td>
			
			<%-- td><a href="del-modulo.do?id=${modulo.getId()}" class="btn btn-danger">Borrar</a></td> --%>
			</tr>
		</c:forEach>

	</table>

	<footer class="footer">
		<p>DWES: Desarrollo Web en Entorno Servidor - profesor: joseramon.profesor@gmail.com</p>
	</footer>

	<script src="webjars/jquery/3.5.1/jquery.min.js"></script>
	<script src="webjars/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>

</html>