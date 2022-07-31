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
	</tr>
	<c:forEach var="clienteVar" items="${clientes}">
		<tr>
			<td>${clienteVar.nombre}</td>
			<td>${clienteVar.apellido}</td>
			<td>${clienteVar.email}</td>
		</tr>
	</c:forEach>
</table>
	<br/>
<input type="button" value="Agregar cliente" onclick="window.location.href='formularioCliente'; return false;" />
</div>
</body>
</html>