
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
	<h1>A�adir nuevo alumno</h1>
	<div class=row>
			<p style="color:red" class="errores">${errores}</p>
		</div>
		<mvc:form action="add-alumno" method="POST" modelAttribute="alumno">
		<mvc:errors path="*" cssClass="text-warning"></mvc:errors>
			<div class="row">
				<div class="col">
					<mvc:label path="nombre"><spring:message code="etiqueta.nombre" /></mvc:label>
				<mvc:input class="form-control" type="text" path="nombre"
					id="nombre" required="required"></mvc:input>
					<mvc:errors path="nombre" cssClass="text-warning"></mvc:errors>
				</div>
				<div class="col">
					<mvc:label path="dni"><spring:message code="etiqueta.dni" /></mvc:label> <mvc:input path="dni" type="text" id="dni"
						class="form-control" required="required"/>
						<mvc:errors path="dni" cssClass="text-warning"></mvc:errors>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<mvc:label path="edad"><spring:message code="etiqueta.edad" /></mvc:label> <mvc:input path="edad" type="number" id="edad"
						class="form-control" required="required"/>
						<mvc:errors path="edad" cssClass="text-warning"></mvc:errors>
				</div>
				<div class="col">
					<mvc:label path="ciclo"><spring:message code="etiqueta.ciclo" /></mvc:label> <mvc:input path="ciclo" type="text" id="ciclo"
						class="form-control" required="required"/>
						<mvc:errors path="ciclo" cssClass="text-warning"></mvc:errors>
				</div>
			</div>
			
			<div class="row">
			<div class="col">
				<mvc:label path="curso"><spring:message code="etiqueta.curso" /></mvc:label> <mvc:input path="curso" type="number"  id="curso"
					class="form-control" required="required" min="0" max="4"/>
					<mvc:errors path="curso" cssClass="text-warning"></mvc:errors>
					</div>
			</div>
			<br>
			
			<div class="row mt-3">
			<div class="col">
				<mvc:label path="interesadoEn"><spring:message code="etiqueta.erasmus" /></mvc:label>
				<div class="input-group">
					<div class="input-group-text">
						<mvc:checkbox path="erasmus" id="erasmus" />
					</div>
					<mvc:label path="erasmus" class="form-control">Erasmus</mvc:label>
				</div>
				<mvc:errors path="erasmus" cssClass="text-warning"></mvc:errors>
			</div>
			<div class="col">
				<mvc:label path="interesadoEn"><spring:message code="etiqueta.interesado" /></mvc:label>
				<div class="input-group">
					<mvc:checkboxes items="${interesadoEnLista}" path="interesadoEn" />
				</div>
			</div>
			<div class="col">
				<mvc:label path="interesadoEn"><spring:message code="etiqueta.lenguaje.favorito" /></mvc:label>
				<div class="input-group">
					<div class="input-group-text">
						<mvc:checkbox path="lenguajeFavorito" id="lenguajeFavorito"
							value="Java"></mvc:checkbox>
					</div>
					<mvc:label path="lenguajeFavorito" class="form-control">Java</mvc:label>
				</div>
			</div>
		</div>
		
		<div class="row mt-3">
			<div class="col">
				<mvc:label path="genero"><spring:message code="etiqueta.genero" /></mvc:label>
				<div class="input-group">
					<div class="input-group">
						<ul style="list-style-type: none;">
							<mvc:radiobuttons items="${generoLista}" path="genero"
								element="li" />
						</ul>
					</div>
				</div>
			</div>

			<div class="col">
				<mvc:label path="horario"><spring:message code="etiqueta.horas" /></mvc:label>
				<div class="input-group">
					<div class="input-group">
						<ul style="list-style-type: none;">
							<mvc:select path="horario">
								<mvc:options items="${horarioLista}" path="horario" />
							</mvc:select>
						</ul>
					</div>
				</div>
			</div>
			<div class="col">
				<mvc:label path="pais"><spring:message code="etiqueta.pais" /></mvc:label>
				<div class="input-group">
					<div class="input-group">
						<ul style="list-style-type: none;">
							<mvc:select path="pais">
								<mvc:option value="-" label="Ninguno" />
								<mvc:options items="${paisLista}" path="pais" />
							</mvc:select>
						</ul>
					</div>
				</div>
			</div>
			<div class="col">
				<mvc:label path="matriculadoen"><spring:message code="etiqueta.matriculado" /></mvc:label>
				<div class="input-group">
					<div class="input-group">
						<ul style="list-style-type: none;">
							<mvc:select path="matriculadoen">
								<mvc:options items="${modulosLista}" itemValue="id"
									itemLabel="nombre" path="matriculadoen" />
							</mvc:select>
						</ul>
					</div>
				</div>
			</div>
			<div class="col">
				<mvc:label path="hobbies"><spring:message code="etiqueta.hobbies" /></mvc:label>
				<div class="input-group">
					<div class="input-group">
						<mvc:textarea path="hobbies" rows="3" cols="70" />
					</div>
				</div>
			</div>
		</div>
			
			<br>
			<div class="row">
			<div class="col">
				<input type="submit" value="A�adir" name="boton"
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