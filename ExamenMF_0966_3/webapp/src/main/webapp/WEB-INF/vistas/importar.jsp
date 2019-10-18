<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/vistas/includes/header.jsp"%>
<main>
	<c:if test="${resultado!=null}">
		<div class="respuesta">
			<h3>${resultado}</h3>
		</div>
	</c:if>
	<div id="contenedor" class="importar">
		<h1>Selecciona el archivo que deseas importar</h1>
		<form action="" method="POST">
			<div class=" center">
				<input type="text" name="file" placeholder="C:\Users\curso\Desktop\personas.txt">
			</div>
			<div class=" center">
				<button class="btn" type="submit">Importar</button>
			</div>
		</form>
	</div>
</main>
<%@ include file="/WEB-INF/vistas/includes/footer.jsp"%>