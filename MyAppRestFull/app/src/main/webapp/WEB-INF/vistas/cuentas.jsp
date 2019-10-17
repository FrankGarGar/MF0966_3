<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/header.jsp"%>

<c:if test="${cts!=null }">
	<table>
		<thead>
			<tr>
				<th>Cuenta</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${cts}" var="ct">
				<tr>
					<td><a href="autenticado/movimientos?id=${ct.id}">${ct.iban}</a></td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>

<%@ include file="/WEB-INF/vistas/includes/footer.jsp"%>