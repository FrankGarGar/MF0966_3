<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base href="${pageContext.request.contextPath}/" />
<link rel="icon" href="_/img/favicon.png">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.1/css/all.css">
<link rel="stylesheet" href="resources/css/login.css">
<title>Ingresa a tu Cuenta</title>
<style type="text/css">
</style>
</head>
<body>
	<c:choose>
		<c:when test="${propietario.error==false}">
			<div class="alert alert-danger alert-dismissible fade show myal"
				role="alert">
				Los datos ingresados no coinciden
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:when>
		<c:when test="${propietario.error==true}">

			<div class="alert alert-danger alert-dismissible fade show myal"
				role="alert">
				<ul>
					<c:if test="${propietario.errorUsername!=''}">
						<li>${propietario.errorUsername}</li>
					</c:if>
					<c:if test="${propietario.errorPassword!=''}">
						<li>${propietario.errorPassword}</li>
					</c:if>

				</ul>

				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</c:when>
	</c:choose>

	<div class="container h-100">
		<div class="d-flex justify-content-center h-100">
			<div class="user_card">
				<div class="d-flex justify-content-center">
					<div class="brand_logo_container">
						<span class="icon-circle"><i class="far fa-comments"></i></span>
					</div>
				</div>
				<div class="d-flex justify-content-center form_container">
					<form action="" method="POST" id="form-login"
						autocomplete="off">
						<div class="input-group mb-3">
							<div class="input-group-append">
								<span class="input-group-text"><i class="fas fa-user"></i></span>
							</div>
							<input type="text" name="username" value="${propietario.username}"
								class="form-control input_user" placeholder="Usuario">
						</div>
						<div class="input-group mb-2">
							<div class="input-group-append">
								<span class="input-group-text"><i class="fas fa-key"></i></span>
							</div>
							<input type="password" name="password"
								class="form-control input_pass" placeholder="Contraseña">
						</div>
						<div class="form-group">
							<div class="custom-control custom-checkbox">
								<input type="checkbox" class="custom-control-input"
									id="customControlInline"> <label
									class="custom-control-label" for="customControlInline">Recuerdame</label>
							</div>
						</div>
						<div class="d-flex justify-content-center mt-3 login_container">
							<button type="submit" name="button" class="btn login_btn">Login</button>
						</div>
					</form>
				</div>
				<div class="mt-4">
					<div class="d-flex justify-content-center links">
						Aún no tienes cuenta? <a href="#" class="ml-2">Registrate</a>
					</div>
					<!-- <div class="d-flex justify-content-center links">
						<a href="#">Forgot your password?</a>
					</div> -->
				</div>
			</div>
		</div>
	</div>

</body>
</html>