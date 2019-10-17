<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/header.jsp"%>
<c:if test="${movs!=null }">
	<table>
		<thead>
			<tr>
				<th>IBAN</th>
				<th>IBAN cuenta recibe</th>
				<th>Concepto</th>
				<th>Importe</th>
				<th>Divisa</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${movs}" var="mv">
				<tr>
					<td>${mv.cuentaEnvio.iban}</td>
					<td>${mv.cuentaRecibio.iban}</td>
					<td>${mv.concepto}</td>
					<td>${mv.importe.cantidad}</td>
					<td>${mv.importe.divisa}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>
<%@ include file="/WEB-INF/vistas/includes/footer.jsp"%>