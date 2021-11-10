
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="webjars/bootstrap/4.5.2/css/bootstrap.min.css"
rel="stylesheet">
<title>Añadir Uds</title>

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

	<!-- <nav class="navbar navbar-default">

		<a href="http://ieslluissimarro.org/" class="navbar-brand">Simarro</a>

		<nav class="nav nav-pills flex-column flex-sm-row">
			<a class="nav-link " href="/login.do">Home</a>
			<a class="nav-link active" href="/alumno.do">Alumnos</a>
			<a class="nav-link" href="https://aules.edu.gva.es/fp/course/view.php?id=60536">DWES</a>
		</nav>
 
 
		<ul class="nav navbar-nav navbar-right">
			<li><a class="nav-link" href="/logout.do">Logout</a></li>
		</ul>

	</nav> -->
<%@ include file="../jspf/header.jspf" %>
<%@ include file="../jspf/nav.jspf" %>

	<div class="container">
	<input href="/list-uds.do" type="submit" value="Volver al Listado" name="boton"
		class="btn btn-success "></input>
	<h1>Añadir nueva Uds</h1>
		<form action="add-uds.do" method="POST">
		<div class=row>
			<p style="color:red" class="errores">${errores}</p>
		</div>
			<div class="row">
				<div class="col">
					<label>Nombre</label> <input type="text" name="nombre" id="nombre"
						required class="form-control" minleght="5">
				</div>
				<div class="col">
					<label>Horas</label> <input type="number" name="horas" id="horas"
						class="form-control" required>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label>Orden</label> <input type="text" name="orden" id="orden"
						required class="form-control" minleght="5">
				</div>
				<div class="col">
					<label>Id</label> <input type="number" name="id" id="id"
						class="form-control" required>
				</div>
				<div class="col">
					<label>Id Modulo</label> <input type="number" name="idModulo" id="idModulo"
						class="form-control" required>
				</div>
			</div>
			
			
			<div class="row">
			
			<br>
			<div class="row">
			<div class="col">
				<input href="/add-uds.do" type="submit" value="Añadir" name="boton"
		class="btn btn-success btn-block"></input>
			</div>
			</div>
			
		</form>
	</div>

<%@ include file="../jspf/footer.jspf" %>
	<!-- <footer class="footer">
		<p>DWES: Desarrollo Web en Entorno Servidor - profesor: joseramon.profesor@gmail.com</p>
	</footer> -->

	<script src="webjars/jquery/3.5.1/jquery.min.js"></script>
	<script src="webjars/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>

</html>