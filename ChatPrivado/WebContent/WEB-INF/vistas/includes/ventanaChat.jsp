<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="fl1 mlr20 chat scroll" id="chat">
	<div class="all-mj" id="all-mj">
		<c:forEach items="${mensajes}" var="mensaje">
			<c:choose>
				<c:when test="${mensaje.usuario.username != userlog.username}">
					<p class="message mm">
						<span class="info">
							<span class="fecha">${mensaje.fecha }</span>
							<span class="username">${mensaje.usuario.username}:</span>
							</span>
						${mensaje.mensaje}
					</p>
				</c:when>
				<c:otherwise>
			       <p class="message2 mm">
						<span class="info">
							<span class="fecha">${mensaje.fecha }</span>
							<span class="username">Tu:</span>
							</span>
						${mensaje.mensaje}
					</p>
			    </c:otherwise>
			</c:choose>
		</c:forEach>
	</div>


	<div class="campo-mensaje">
		<form id="send-pm" class="mensaje-publico">
			<textarea class="mensaje item-form" name="mensaje" id="mensaje"></textarea>
			<button type="submit" disabled="disabled" class="btn btn-primary btn-send align-self-center"><span><i class="fas fa-paper-plane"></i></span></button>
		</form>
	</div>

</div>