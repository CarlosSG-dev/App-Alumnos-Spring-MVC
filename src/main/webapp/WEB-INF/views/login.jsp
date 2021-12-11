<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
 %>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
</head>
<body>
	<%
		String error= String.valueOf(request.getParameter("errores"));
		if(!error.equals("empty")){
			response.getWriter().write(error);
		}
	%>

	<form action="/login.do" method="post">
		Introduzca nombre: <input type="text" name="nombre"/>
		Introduzca su contraseña: <input type="password" name="password"/>
		<input type="submit" value="login"/>
	</form>
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
	
			<section class="vh-100">
  <div class="container py-5 h-100">
    <div class="row d-flex align-items-center justify-content-center h-100">
      <div class="col-md-8 col-lg-7 col-xl-6">
        <img src="https://mdbootstrap.com/img/Photos/new-templates/bootstrap-login-form/draw2.svg" class="img-fluid" alt="Phone image">
      </div>
      <div class="col-md-7 col-lg-5 col-xl-5 offset-xl-1">
        <mvc:form action="login" method="post" modelAttribute="usuario">
          <!-- Email input -->
          <div class="form-outline mb-4">
            <mvc:input path="nickname" type="text" id="form1Example13" class="form-control form-control-lg"></mvc:input>
            <mvc:label path="nickname" class="form-label" for="form1Example13"><spring:message code="login.introduzca.usuario" /></mvc:label>
          </div>

          <!-- Password input -->
          <div class="form-outline mb-4">
            <mvc:password path="password" class="form-control form-control-lg"></mvc:password>
            <mvc:label path="password" class="form-label" for="form1Example23"><spring:message code="login.introduzca.pw" /></mvc:label>
          </div>

          <div class="d-flex justify-content-around align-items-center mb-4">
            <!-- Checkbox -->
            <div class="form-check">
              <input
                class="form-check-input"
                type="checkbox"
                value=""
                id="form1Example3"
                checked
              />
              <label class="form-check-label" for="form1Example3"> Recordarme </label>
            </div>
            <a href="#!">Olvidaste tu password?</a>
          </div>

          <!-- Submit button -->
          <button type="submit" class="btn btn-primary btn-lg btn-block">Login</button>

          <div class="divider d-flex align-items-center my-4">
            <p class="text-center fw-bold mx-3 mb-0 text-muted">O</p>
          </div>

          <a class="btn btn-primary btn-lg btn-block" style="background-color: #3b5998" href="#!" role="button">
            <i class="fab fa-facebook-f me-2"></i>Continuar con Facebook
          </a>
          <a class="btn btn-primary btn-lg btn-block" style="background-color: #55acee" href="#!" role="button">
            <i class="fab fa-twitter me-2"></i>Continuar con Twitter</a>

        </form>
      </div>
    </div>
  </div>
</section>
		
	</mvc:form>
	

<%@ include file="../jspf/footer.jspf" %>

	
</div>
	<script src="webjars/jquery/3.5.1/jquery.min.js"></script>
	<script src="webjars/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>

</html>