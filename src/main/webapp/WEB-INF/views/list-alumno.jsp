<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<link href="webjars/bootstrap/5.1.0/bootstrap.min.css" rel="stylesheet">
<title>Alumnos</title>
</head>
<body>
	<p>Bienvenido ${nombre}</p>
	<ol>
		<c:forEach items="${alumnos} }" var="alumno">
			<li>${alumno.getNombre()} <a href="del-alumno.do?nomAlumno=${alumno.getNombre()}"> Borrar</a></li>
			
		</c:forEach>
		<form action="alumno.do" method="POST">
			<input type="text" name="alumno_nuevo"/><input type="submit" value="Añadir" name="button"/>
		</form>
	</ol>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html> --%>
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

	
	<%@ include file="../jspf/header.jspf" %>
<%@ include file="../jspf/nav.jspf" %>

	<div class="container">
		<H1>Bienvenido ${nombre}</H1>
		<H2>Listado de alumnos:</H2>
		<table class="table table-striped">
		<tr>
		<th> <a class="nav-link" href="list-alumno?orden=dni">DNI</a></th>
		<th><a class="nav-link" href="list-alumno?orden=nombre">Nombre</a></th>
		
		<th><a class="nav-link" href="list-alumno?orden=edad">Edad</a></th>
		<th><a class="nav-link" href="list-alumno?orden=ciclo">Ciclo</a></th>
		<th><a class="nav-link" href="list-alumno?orden=curso">Curso</a></th>
		<th>Acciones</th>
		</tr>
		<c:forEach items="${alumnos}" var="alumno">

			<tr>
				<td>${alumno.getDni()}</td>
				<td>${alumno.getNombre()}</td>
				<td>${alumno.getEdad()}</td>
				<td>${alumno.getCiclo()}</td>
				<td>${alumno.getCurso()}</td>
				<td><a class="btn btn-success" href="update-alumno?dni=${alumno.getDni()}"><i class="fa fa-user-o" aria-hidden="true"></i>
						Modificar</a></td>
			<td><a href="del-alumno?dni=${alumno.getDni()}" class="btn btn-danger">Borrar</a></td> 
			
			</tr>
		</c:forEach>

	</table>
	
	<a href="add-alumno" class="btn btn-success btn-block">Add alumno</a>

	<footer class="footer">
		<p>DWES: Desarrollo Web en Entorno Servidor - profesor: joseramon.profesor@gmail.com</p>
	</footer>

	<script src="webjars/jquery/3.5.1/jquery.min.js"></script>
	<script src="webjars/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>

</html>