<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:forEach items="${mensajes}" var="mensaje">
			<c:choose>
				<c:when test="${mensaje.usuario.username != userlog.username}">
					<p class="message">
						<span class="info">
							<span class="fecha">${mensaje.fecha }</span>
							<span class="username">${mensaje.usuario.username}:</span>
							</span>
						${mensaje.mensaje}
					</p>
				</c:when>
				<c:otherwise>
			       <p class="message2">
						<span class="info">
							<span class="fecha">${mensaje.fecha }</span>
							<span class="username">Tu:</span>
							</span>
						${mensaje.mensaje}
					</p>
			    </c:otherwise>
			</c:choose>
		</c:forEach>