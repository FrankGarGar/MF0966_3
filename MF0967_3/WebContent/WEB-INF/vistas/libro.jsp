<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/cabecera.jsp"%>

<h2>Detalle de libro</h2>

<form action="admin/libroprocesar" method="post">
	<input type="hidden" name="op" value="${op}" /> <input type="hidden"
		name="id" value="${libro.id}" />

	<div class="form-group row">
		<label for="imagen" class="col-sm-2 col-form-label">Imagen</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="imagen" name="imagen"
				placeholder="Nombre de la imagen con extensión"
				value="${libro.imagen}">
		</div>
	</div>
	<div class="form-group row">
		<label for="descripcion" class="col-sm-2 col-form-label">Descripción</label>
		<div class="col-sm-10">
			<input type="text" required="required" class="form-control"
				id="descripcion" name="descripcion" placeholder="Descripción"
				value="${libro.descripcion}">
			<c:if test="${not empty libro.errorDescripcion}">
				<small class="text-danger"> ${libro.errorDescripcion} </small>
			</c:if>
		</div>
	</div>
	<div class="form-group row">
		<label for="autor" class="col-sm-2 col-form-label">Autor</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="autor" name="autor"
				placeholder="Autor" value="${libro.autor}">
		</div>
	</div>
	<div class="form-group row">
		<label for="precio" class="col-sm-2 col-form-label">Precio</label>
		<div class="col-sm-10">
			<input type="number" required="required" step=".01"
				class="form-control" id="precio" name="precio" placeholder="Precio"
				value="${libro.precio}">
			<c:if test="${not empty libro.errorPrecio}">
				<small class="text-danger"> ${libro.errorPrecio} </small>
			</c:if>
		</div>
	</div>
	<div class="form-group row">
		<label for="descuento" class="col-sm-2 col-form-label">Descuento</label>
		<div class="col-sm-10">
			<input type="number" required="required" class="form-control"
				id="descuento" name="descuento" placeholder="Descuento"
				value='<fmt:formatNumber type = "number" 
         					pattern = "0" value = "${libro.descuento * 100}" />'>
			<c:if test="${not empty libro.errorDescuento}">
				<small class="text-danger"> ${libro.errorDescuento} </small>
			</c:if>
		</div>
	</div>
	<div class="form-group row">
		<div class="col-sm-10">
			<button type="submit" class="btn btn-primary">Aceptar</button>
			<a class="btn btn-danger" href="admin/listado">Cancelar</a>
		</div>
	</div>
</form>

<%@ include file="/WEB-INF/includes/pie.jsp"%>