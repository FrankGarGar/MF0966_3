<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Web APP EXAMEN MF0966_3</title>
<base href="${pageContext.request.contextPath}/" />
<link rel="stylesheet" href="resources/css/estilos.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.1/css/all.css">
</head>
<body>
<ul>
	<li><a href="home">Inicio</a></li>
	<li><a href="importar">Importar csv</a></li>
	<li><a href="listar">Listar Personas</a></li>
	<li><a href="agregar">Agregar Persona</a></li>
	<li>
		<form id="buscadorPorDni" action="buscador" method="GET">
			<input type="hidden" name="opcion" value="dni"> <input
				type="text" maxlength="9" name="dni" placeholder="Introduce dni">
			<button type="submit" class="btn">
				<i class="fas fa-search"></i>
			</button>
		</form>
	</li>
	<li>
		<form id="buscadorPorEmail" action="buscador" method="GET">
			<input type="hidden" name="opcion" value="email"> <input
				type="email" maxlength="60" name="email"
				placeholder="Introduce email">
			<button type="submit" class="btn">
				<i class="fas fa-search"></i>
			</button>
		</form>
	</li>
	<li>
		<form id="buscadorPorNombre" action="buscador" method="GET">
			<input type="hidden" name="opcion" value="nombres">
			<input
				type="text" maxlength="25" name="nombres" placeholder="Introduce Nombre o apellido">
			<button type="submit" class="btn">
				<i class="fas fa-search"></i>
			</button>
		</form>
	</li>
</ul>