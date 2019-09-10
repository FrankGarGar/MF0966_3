<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/menu.jsp"%>



<div class="contenedor">
	<div class="menu d-flex justify-content-center align-items-center">
		<span class="fbw">Bienvenido ${userlog.username}</span>
		<h1>Chat Público</h1>
		
		<a class="fbw" href="autenticado/logout">Cerrar Sesión</a>
	</div>
	<div class="d-flex justify-content-around">
		<%@ include file="/WEB-INF/vistas/includes/listadoUsuarios.jsp"%>
		<%@ include file="/WEB-INF/vistas/includes/ventanaChat.jsp"%>
	</div>
	
</div>


<%@ include file="/WEB-INF/vistas/includes/footer.jsp"%>