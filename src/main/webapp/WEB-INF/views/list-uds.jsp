
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

	<nav class="navbar navbar-default">

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

	</nav>

	<div class="container">
	
		<H1>Listado de Modulos:</H1>	
		<table class="table table-striped">
		<tr>
		<th> <a class="nav-link" href="list-modulo.do?orden=id">ID</a></th>
		<th><a class="nav-link" href="list-modulo.do?orden=nombre">Nombre</a></th>
		
		<th><a class="nav-link" href="list-modulo.do?orden=horas">Horas</a></th>
		<th><a class="nav-link" href="list-modulo.do?orden=abreviatura">Abreviatura</a></th>
		
		<th>Accion</th>
		</tr>
		<c:forEach items="${modulos}"  var="modulo" >

			<tr>
				<td>${modulo.getId()}</td>
				<td>${modulo.getNombre()}</td>
				<td>${modulo.getHoras()}</td>
				<td>${modulo.getAbreviatura()}</td>
			<td><a href="del-modulo.do?id=${modulo.getId()}" class="btn btn-danger">Borrar</a></td>
			
				<td><a href="list-uds.do?id=${ud.getId()}" class="btn btn-primary"/></td>
			
			
			<%-- td><a href="del-modulo.do?id=${modulo.getId()}" class="btn btn-danger">Borrar</a></td> --%>
			</tr>
		</c:forEach>

	</table>
	
	<!-- <a href="/add-modulo.do" class="btn btn-success btn-block">Add Modulo</a> -->
	<H1>Listado de Unidades:</H1>
	<table class="table table-striped">
		<tr>
		<th> <a class="nav-link" href="list-uds.do?orden=id">ID</a></th>
		<th><a class="nav-link" href="list-uds.do?orden=nombre">Nombre</a></th>
		
		<th><a class="nav-link" href="list-uds.do?orden=horas">Horas</a></th>
		<th><a class="nav-link" href="list-uds.do?orden=orden">Orden</a></th>
		
		<th>Accion</th>
		</tr>
		<c:forEach items="${uds}" var="uds">

			<tr>
				<td>${uds.getIdModulo()}</td>
				<td>${uds.getNombre()}</td>
				<td>${uds.getHoras()}</td>
				<td>${uds.getOrden()}</td>
			<td><a href="del-uds.do?id=${uds.getId()}" class="btn btn-danger">Borrar</a></td>
			
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