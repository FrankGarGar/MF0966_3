<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/vistas/includes/header.jsp"%>
<main>
	<c:if test="${persona!=null}">
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
				<tr>
					<td>${persona.id}</td>
					<td>${persona.nombre}</td>
					<td>${persona.apellido}</td>
					<td>${persona.email}</td>
					<td>${persona.dni}</td>
					<td><a href="editar?id=${p.id}" class="btn"><i
							class="fas fa-pen"></i></a></td>
				</tr>

			</tbody>
		</table>
	</c:if>
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
				<c:forEach items="${personas}" var="persona">
					<tr>
						<td>${persona.id}</td>
						<td>${persona.nombre}</td>
						<td>${persona.apellido}</td>
						<td>${persona.email}</td>
						<td>${persona.dni}</td>
						<td><a href="editar?id=${p.id}" class="btn"><i
								class="fas fa-pen"></i></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>

</main>
<%@ include file="/WEB-INF/vistas/includes/footer.jsp"%>