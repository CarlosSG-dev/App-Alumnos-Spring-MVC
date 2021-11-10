
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
		<c:forEach items="${modulos}" var="modulo">

			<tr>
				<td>${modulo.getId()}</td>
				<td>${modulo.getNombre()}</td>
				<td>${modulo.getHoras()}</td>
				<td>${modulo.getAbreviatura()}</td>
			<td><a href="del-modulo.do?id=${modulo.getId()}" class="btn btn-danger">Borrar</a></td>
			<td><a href="list-uds.do" class="btn btn-primary"/>Uds</td>
			<td><a href="add-uds.do" class="btn btn-primary"/>Añadir Uds</td>
			<%-- td><a href="del-modulo.do?id=${modulo.getId()}" class="btn btn-danger">Borrar</a></td> --%>
			</tr>
		</c:forEach>

	</table>
	
	<!-- <a href="/add-modulo.do" class="btn btn-success btn-block">Add Modulo</a> -->
	
	<h3>Añadir nuevo modulo</h3>
		<form action="add-modulo.do" method="POST">
		<div class=row>
			<p style="color:red" class="errores">${errores}</p>
		</div>
			<div class="row">
				<div class="col">
					<label>ID</label> <input type="number" name="id_nuevo" id="id_nuevo"
						required class="form-control">
				</div>
				<div class="col">
					<label>Nombre</label> <input type="text" name="nombre" id="nombre"
						class="form-control" required>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label>Horas</label> <input type="number" name="horas" id="horas"
						class="form-control" required>
				</div>
				<div class="col">
					<label>Abreviatura</label> <input type="text" name="abreviatura" id="abreviatura"
						class="form-control" required>
				</div>
			</div>
			
			<div class="row">
			<br>
			<div class="row">
			<div class="col">
				<input type="submit" value="Añadir" name="boton"
		class="btn btn-success btn-block"></input>
			</div>
			</div>
			
		</form>

	<footer class="footer">
		<p>DWES: Desarrollo Web en Entorno Servidor - profesor: joseramon.profesor@gmail.com</p>
	</footer>

	<script src="webjars/jquery/3.5.1/jquery.min.js"></script>
	<script src="webjars/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>

</html>