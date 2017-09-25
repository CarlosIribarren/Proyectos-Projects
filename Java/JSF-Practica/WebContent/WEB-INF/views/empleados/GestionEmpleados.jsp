<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Gestion de Empleados - Carlos Iribarren</title>
 
    <!-- CSS de Bootstrap -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" media="screen">
    <!-- CUSTOM CSS Bootstrap -->
    <link href="${pageContext.request.contextPath}/css/customCSS.css" rel="stylesheet" media="screen">
 
    <!-- librerías opcionales que activan el soporte de HTML5 para IE8 -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<h1>Gestion de los empleados</h1>
	
	<a href="crearNuevaEmpleado" class="btn btn-default btn-primary" role="button">Añadir</a>
	<fieldset>
	<legend><h3>Patron de busqueda : </h3></legend>
	
		<div class="col-md-5 col-md-offset-1"> 
			<form role="form" action="buscarCompleto" method="get">
			
				<div class="form-group">
					<label>numeroEmpleado</label>
					<input type="text" name="numeroEmpleado">
				</div>

				<div class="form-group">
					<label>fechaNacimiento</label>
					<input type="text" placeholder="dd-MM-yyyy" name="fechaNacimiento" >
				</div>
				
				<div class="form-group">
					<label>nombre</label>
					<input type="text" name="nombre">
				</div>

				<div class="form-group">
					<label>apellido</label>
					<input type="text" name="apellido">
				</div>	
					
				<div class="form-group">
					<label>genero</label>
					<input type="text" name="genero">
				</div>

				<div class="form-group">
					<label>fechaContratacion</label>
					<input type="text" name="fechaContratacion">
				</div>			
					

					
				<input type="submit" value="Buscar" />

			</form>
		</div>
	
	</fieldset>


	<fieldset>
	<legend><h3>Resultado de la busqueda : </h3></legend>


		<table  class="table table-striped">
			<!-- CABECERA TABLA -->
			<thead>
				<tr>
					<th>Numero Empleado</th>
					<th>Fecha Nacimiento</th>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Genero</th>
					<th>fechaContratacion</th>
				</tr>
			</thead>
			<!-- CUERPO TABLA -->
			<tbody>
				<c:forEach items="${listaEmpleados}" var="empleado">
					<tr>
						<td>${empleado.numeroEmpleado}</td>
						<td><fmt:formatDate value="${empleado.fechaNacimiento}" type="date" pattern="dd-MM-yyyy" /></td>
						<td>${empleado.nombre}</td>
						<td>${empleado.apellido}</td>
						<td>${empleado.genero}</td>
						<td><fmt:formatDate value="${empleado.fechaContratacion}" type="date" pattern="dd-MM-yyyy" /></td>
						
						
						<td><a href="#">MODIFICAR</a></td>
						<td><a href="#">ELIMINAR</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</fieldset>

		
	<!-- Librería jQuery requerida por los plugins de JavaScript -->
    <script src="http://code.jquery.com/jquery.js"></script>
 
    <!-- JS de Bootstrap -->
    <script src="js/bootstrap.min.js"></script>
    
    <!-- CUSTOM JS -->
    <script src="js/customJS.js"></script>
	
	</body>
</html>