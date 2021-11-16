
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
	<h1>Modificar alumno</h1>
	<div class=row>
			<p style="color:red" class="errores">${errores}</p>
		</div>
		<mvc:form action="add-alumno" method="POST" modelAttribute="alumno">
		<mvc:errors path="*" cssClass="text-warning"></mvc:errors>
			<div class="row">
				<div class="col">
					<mvc:label path="nombre">Nombre</mvc:label>
				<mvc:input class="form-control" type="text" path="nombre"
					id="nombre" required="required"></mvc:input>
					<mvc:errors path="nombre" cssClass="text-warning"></mvc:errors>
				</div>
				<div class="col">
					<mvc:label path="dni">Dni</mvc:label> <mvc:input path="dni" type="text" id="dni"
						class="form-control" required="required"/>
						<mvc:errors path="dni" cssClass="text-warning"></mvc:errors>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<mvc:label path="edad">Edad</mvc:label> <mvc:input path="edad" type="number" id="edad"
						class="form-control" required="required"/>
						<mvc:errors path="edad" cssClass="text-warning"></mvc:errors>
				</div>
				<div class="col">
					<mvc:label path="ciclo">Ciclo</mvc:label> <mvc:input path="ciclo" type="text" id="ciclo"
						class="form-control" required="required"/>
						<mvc:errors path="ciclo" cssClass="text-warning"></mvc:errors>
				</div>
			</div>
			
			<div class="row">
			<div class="col">
				<mvc:label path="curso">Curso</mvc:label> <mvc:input path="curso" type="number"  id="curso"
					class="form-control" required="required" min="0" max="4"/>
					<mvc:errors path="curso" cssClass="text-warning"></mvc:errors>
					</div>
			</div>
			<br>
			<div class="row">
			<div class="col">
				<input type="submit" value="Modificar" name="boton"
		class="btn btn-success btn-block"/>
			</div>
			</div>
			
		</mvc:form>
	</div>

<%@ include file="../jspf/footer.jspf" %>
	

	<script src="webjars/jquery/3.5.1/jquery.min.js"></script>
	<script src="webjars/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>

</html>