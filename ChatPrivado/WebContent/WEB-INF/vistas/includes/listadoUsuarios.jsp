<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="list-users flex-fill scroll">
	
	<h2>Listado de usuarios</h2>
	<ul class="usuarios">
		<li class="li-all-users" data-user="0"><span class="icono"><i class="fas fa-users show"></i><i class="far fa-envelope hide"></i></span>Chat Público</li>
		<c:forEach items="${usuarios}" var="usuario">
			<c:if test="${usuario.username != userlog.username}">
				<li class="li-user" data-user="${usuario.id}"><span class="icono"><i class="fas fa-user show"></i><i class="far fa-envelope hide"></i></span><span class="username">${usuario.username}</span></li>
			</c:if>
		</c:forEach>
	</ul>
</div>