<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/cabecera.jsp"%>
<table class="table">
	<thead>
		<tr>
			<th>Id</th>
			<th>Imagen</th>
			<th>Descripción</th>
			<th>Autor</th>
			<th>Precio</th>
			<th>Descuento</th>
			<th>Precio con descuento</th>
			<th><a class="btn btn-primary" href="admin/libro">Añadir</a></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${libros}" var="libro">
			<tr>
				<th>${libro.id}</th>
				<td><img class="thumbnail" style="height: 4em;" src="imgs/${libro.imagen}" /></td>
				<td>${libro.descripcion}</td>
				<td>${libro.autor}</td>
				<td>${libro.precio}€</td>
				<td>${libro.descuento * 100}%</td>
				<td><fmt:formatNumber type = "number" 
         					pattern = "0.00" value = "${libro.precioConDescuento}" />€</td>
				<td><a class="btn btn-primary" href="admin/libro?id=${libro.id}">Modificar</a> 
					<%--<a onclick="return confirm('¿Estás seguro de que quieres borrar el registro cuyo id es ${libro.id}?')" class="btn btn-danger" href="admin/libroprocesar?op=borrar&id=${libro.id}">Borrar</a>--%>
					<form style="display: inline" method="post" action="admin/libroprocesar" onsubmit="return confirm('¿Estás seguro de que quieres borrar el registro cuyo id es ${libro.id}?')">
						<button class="btn btn-danger">Borrar</button>
						<input type="hidden" name="id" value="${libro.id}" />
						<input type="hidden" name="op" value="borrar" />
					</form>
				</td>
			</tr>
		</c:forEach>
	</tbody>

</table>
<%@ include file="/WEB-INF/includes/pie.jsp"%>