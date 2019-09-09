<div class="list-users flex-fill scroll">
	
	<h2>Listado de usuarios</h2>
	<ul class="usuarios">
		<c:forEach items="${usuarios}" var="usuario">
			<c:if test="${usuario.username != userlog.username}">
				<li class="li-user" data-user="${usuario.username}"><span class="icono"><i class="fas fa-user show"></i><i class="far fa-envelope hide"></i></span><span class="username">${usuario.username}</span></li>
			</c:if>
		</c:forEach>
	</ul>
</div>