
<%@ include file="../jspf/header.jspf"%>
<%@ include file="../jspf/nav.jspf"%>
<div class="container">

	<h1>Módulo a eliminar:</h1>

	<form action="del-modulo" method="post" modelAttribute="modulo">
		<div class="row">
			<div class="col">
				<label path="id">Id:</label>
				<input class="form-control" readonly="readonly" path="id" id="id" name="id"></input>
			</div>
			<div class="col">
				<label path="nombre">Nombre:</label>
				<input class="form-control" readonly="readonly" path="nombre" id="nombre"></input>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<label path="horas">Horas:</label>
				<input class="form-control" readonly="readonly" path="horas" id="horas"></input>
			</div>
			<div class="col">

				<label path="abreviatura">Abreviatura:</label>
				<input class="form-control" readonly="readonly" path="abreviatura" id="abreviatura"></input>
			</div>
		</div>
		<input type="submit" id="submit" class="btn btn-danger" value="Eliminar">
	</form>
</div>
<%@ include file="../jspf/footer.jspf"%>