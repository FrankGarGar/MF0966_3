<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/vistas/includes/header.jsp"%>
<h1>Listado de personas</h1>
<main>
	<c:if test="${personas!=null}">
		<table>
			<thead>
				<tr>
					<th>Id</th>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Email</th>
					<th>DNI</th>
					<th>Opciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${personas}" var="p">
					<tr>
						<td>${p.id}</td>
						<td>${p.nombre}</td>
						<td>${p.apellido}</td>
						<td>${p.email}</td>
						<td>${p.dni}</td>
						<td><a href="editar?id=${p.id}" class="btn"><i class="fas fa-pen"></i></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	<c:if test="${personas==null}">
		<h5>Tabla vacía</h5>
	</c:if>
</main>
<%@ include file="/WEB-INF/vistas/includes/footer.jsp"%>