<%@ include file="../jspf/header.jspf"%>
<%@ include file="../jspf/nav.jspf"%>

<div class="container">
	<h1>Documentación del Alumno</h1>
	<table class="table table-striped">
		<thead>
			<tr>
				<th><a>Dni</a></th>
				<th><a>Nombre</a></th>
				<th><a>Edad</a></th>
				<th><a>Ciclo</a></th>
				<th><a>Curso</a></th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${alumnos}" var="alumno">
				<tr>
					<td>${alumno.getDni()}</td>
					<td>${alumno.getNombre()}</td>
					<td>${alumno.getEdad()}</td>
					<td>${alumno.getCiclo()}</td>
					<td>${alumno.getCurso()}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<br>
	
	<table class="table table-striped">
		<thead>
			<th>Id</th>
			<th>Tipo</th>
			<th>Comentario</th>
		</thead>
		
		<tbody>
			<c:forEach items="${alumno.getDocsAlumno()}" var="docAlumno">
				<tr>
					<td>&nbsp;${docAlumno.getId()}&nbsp;</td>
					<td>&nbsp;${docAlumno.getTipo()}&nbsp;</td>
					<td>&nbsp;${docAlumno.getComentario()}&nbsp;</td>
				</tr>
				</c:forEach>
		</tbody>	
			
	</table>
	


	<a class="btn btn-success btn-block" href="add-doc-alumno">Añadir documentación alumno</a>
</div>
<%@ include file="../jspf/footer.jspf"%>