
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc"%>
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

	<!--  <nav class="navbar navbar-default">

		<a href="http://ieslluissimarro.org/" class="navbar-brand">Simarro</a>

		<nav class="nav nav-pills flex-column flex-sm-row">
			<a class="nav-link " href="/login.do">Home</a>
			<a class="nav-link" href="/list-alumno.do">Alumnos</a>
			<a class="nav-link active" href="/list-modulo.do">Modulos</a>
			<a class="nav-link" href="https://aules.edu.gva.es/fp/course/view.php?id=60536">DWES</a>
		</nav>
 
 
		<ul class="nav navbar-nav navbar-right">
			<li><a class="nav-link" href="/logout.do">Logout</a></li>
		</ul>

	</nav> -->
	
	<%@ include file="../jspf/header.jspf" %>
	<%@ include file="../jspf/nav.jspf" %>

	<div class="container">
	
		<H1><spring:message code="modulos.titulo" /></H1>	
		<table class="table table-striped">
		<tr>
		<th> <a class="nav-link" href="list-modulo.do?orden=id">ID</a></th>
		<th><a class="nav-link" href="list-modulo.do?orden=nombre"><spring:message code="etiqueta.nombre" /></a></th>
		
		<th><a class="nav-link" href="list-modulo.do?orden=horas"><spring:message code="etiqueta.horas" /></a></th>
		<th><a class="nav-link" href="list-modulo.do?orden=abreviatura"><spring:message code="etiqueta.abreviatura" /></a></th>
		
		<th><spring:message code="etiqueta.accion" /></th>
		</tr>
		<c:forEach items="${modulos}" var="modulo">

			<tr>
				<td>${modulo.getId()}</td>
				<td>${modulo.getNombre()}</td>
				<td>${modulo.getHoras()}</td>
				<td>${modulo.getAbreviatura()}</td>
			<td><a href="del-modulo?id=${modulo.getId()}" class="btn btn-danger"><spring:message code="boton.borrar" /></a></td>
			<td><a href="list-uds" class="btn btn-primary"/>Uds</td>
			
			<%-- td><a href="del-modulo.do?id=${modulo.getId()}" class="btn btn-danger">Borrar</a></td> --%>
			</tr>
		</c:forEach>

	</table>
	
	<!-- <a href="/add-modulo.do" class="btn btn-success btn-block">Add Modulo</a> -->
	
	<h3>A�adir nuevo modulo</h3>
		<mvc:form action="add-modulo" method="POST" modelAttribute="modulo">
		<div class=row>
			<p style="color:red" class="errores">${errores}</p>
		</div>
			<div class="row">
				<div class="col">
					<mvc:label path="id">ID</mvc:label> <mvc:input path="id" type="number" id="id_nuevo"
						required="required" class="form-control"/>
				</div>
				<div class="col">
					<mvc:label path="nombre"><spring:message code="etiqueta.nombre" /></mvc:label> <mvc:input path="nombre" type="text"  id="nombre"
						class="form-control" required="required"/>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<mvc:label path="horas"><spring:message code="etiqueta.horas" /></mvc:label> <mvc:input path="horas" type="number" id="horas"
						class="form-control" required="required"/>
				</div>
				<div class="col">
					<mvc:label path="abreviatura"><spring:message code="etiqueta.abreviatura" /></mvc:label> <mvc:input path="abreviatura" type="text"  id="abreviatura"
						class="form-control" required="required"/>
				</div>
			</div>
			
			<div class="row">
			<br>
			<div class="row">
			<div class="col">
				<input type="submit" value="A�adir" name="boton"
		class="btn btn-success btn-block"></input>
			</div>
			</div>
			
		</mvc:form>

	<footer class="footer">
		<p>DWES: Desarrollo Web en Entorno Servidor - profesor: joseramon.profesor@gmail.com</p>
	</footer>

	<script src="webjars/jquery/3.5.1/jquery.min.js"></script>
	<script src="webjars/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>

</html>