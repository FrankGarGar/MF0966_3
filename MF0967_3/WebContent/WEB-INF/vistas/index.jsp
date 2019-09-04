<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/cabecera.jsp"%>
<section id="listado" class="row">

	<c:forEach items="${libros}" var="libro">
		<article class="col-sm-4">
			<img height="158" width="110" src='${not empty libro.imagen ? "imgs/".concat(libro.imagen) : "https://dummyimage.com/110x158/aaa/000.png&text=No+hay+imagen"}' class="mx-auto d-block" />
			<div class="informacion-producto">
				<div class="d-flex">
					<p class="descripcion flex-grow-1">${libro.descripcion}</p>
					<p class="favorito">
						<i class="fas fa-heart"></i><i class="far fa-heart"></i>
					</p>
				</div>
				<p class="autor">${not empty libro.autor ? libro.autor : "Anónimo"}</p>
				<p class="precios">
					<span class="precio-con-descuento">
						<fmt:formatNumber type = "number" 
         					pattern = "0.00" value = "${libro.precioConDescuento}" />€
         			</span>
         			<c:if test="${libro.descuento > 0}">
						<span class="precio-sin-descuento">${libro.precio}€</span>
						<span class="descuento">-<fmt:formatNumber type = "number" 
	         					pattern = "0" value = "${libro.descuento * 100}" />%</span>
         			</c:if>
				</p>
			</div>
		</article>
	</c:forEach>
</section>
<%@ include file="/WEB-INF/includes/pie.jsp"%>
