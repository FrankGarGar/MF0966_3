<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/vistas/includes/header.jsp"%>
<main>
<c:if test="${respuestab!=null}">
	<div class="respuestaBuena">
		<h3>${respuestab}</h3>
	</div>
</c:if>
<c:if test="${respuestae!=null}">
	<div class="respuesta">
		<h3>${respuestae}</h3>
	</div>
</c:if>
	<c:if test="${persona!=null}">
		<h1>Editar persona</h1>
		<form action="" method="POST">

			<input type="hidden" value="${persona.id}">

			<div class="form-group">
				<input type="text" name="nombre" value="${persona.nombre}" placeholder="Nombre">
			</div>
			<div class="form-group">
				<input type="text" name="apellido" value="${persona.apellido}"  placeholder="Apellido">
			</div>
			<div class="form-group">
				<input type="text" name="dni" value="${persona.dni}"  placeholder="Dni">
			</div>
			<div class="form-group">
				<input type="text" name="email" value="${persona.email}"  placeholder="Email">
			</div>

			<input type="submit" class="btn save" value="Guardar">
		</form>
	</c:if>
	<c:if test="${persona==null}">
	
		<h1>Agregar persona</h1>
		<form action="" method="POST">
			<div class="form-group">
				<input type="text" name="nombre" placeholder="Nombre">
			</div>
			<div class="form-group">
				<input type="text" name="apellido" placeholder="Apellido">
			</div>
			<div class="form-group">
				<input type="text" name="dni" placeholder="Dni">
			</div>
			<div class="form-group">
				<input type="text" name="email" placeholder="Email">
			</div>

			<input type="submit" class="btn save" value="Guardar">
		</form>
	</c:if>
</main>
<%@ include file="/WEB-INF/vistas/includes/footer.jsp"%>