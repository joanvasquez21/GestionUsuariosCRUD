<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
<title>Lista de clientes</title>
</head>
<body>

<div class="container">
<table border="1">
	<tr>
		<th>Nombre</th>
 		<th>Apellido</th> 
		<th>Email</th>
		<th>Modificar</th>
		<th>Eliminar</th>
	</tr>
	<c:forEach var="clienteVar" items="${clientes}">
	<!-- Boton para actualizar -->
		<c:url var="linkActualizar" value="/cliente/formularioActualizar">
			<c:param name="idCliente" value="${clienteVar.id}"/>
		</c:url>
	
	<!-- Boton para eliminar -->
		<c:url var="linkEliminar" value="/cliente/eliminar">
			<c:param name="idCliente" value="${clienteVar.id}"/>
		</c:url>
		
		<tr>
			<td>${clienteVar.nombre}</td>
			<td>${clienteVar.apellido}</td>
			<td>${clienteVar.email}</td>
			
			<!-- Celda de agregar un boton -->
			<td><a href="${linkActualizar}"><input type="button" value="Modificar"/></a></td>
			<td><a href="${linkEliminar}"><input type="button" value="Eliminar" 
			onclick="if(!(confirm('Eliminaras un registro. ¿Estas segur@?'))) return false"/></a></td>
			
		</tr>
	</c:forEach>
</table>
	<br/>
<input type="button" value="Agregar cliente" onclick="window.location.href='formularioCliente'; return false;" />
</div>
</body>
</html>