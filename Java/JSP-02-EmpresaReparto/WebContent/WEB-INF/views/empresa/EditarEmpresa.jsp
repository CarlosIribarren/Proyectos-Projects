<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList, my.project.model.Empresa"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/estiloGeneral.css" media="screen"  type="text/css" />
	<link rel="stylesheet" href="css/estiloEditarEmpresa.css" media="screen"  type="text/css" />
	<title>Editar empresa</title>
</head>
<body>

	<h1>Editar empresa</h1>

	<!-- RECIBIR EL BEAN -->
	<jsp:useBean id="empresa" class="my.project.model.Empresa" scope="request"/>
	
	<!-- PARTE DEL DETALE DE LA EMPRESA -->
	<fieldset id="parte_DetalleEmpresa" >
	<legend>Detalle de la empresa</legend>
	
	    <form method="post" action="ModificarUnaEmpresa">
            <input name="id" type="hidden" value="${empresa.idEmpresa}">
            
				<p>
                    Nombre:
                    <input name="nombre" type="text" value="${empresa.nombre}">
                    Cif:
                    <input name="cif" type="text" value="${empresa.cif}">
				</p>
				<p>
                    Direccion:
                    <input name="direccion" type="text" value="${empresa.direccion}">
                    Pasi:
                    <input name="pais" type="text" value="${empresa.pais}">
				
				<!-- BOTON VOLVER -->
				<a href="MostrarPantallaPrincipal"><button> <img id="icono_Volver" alt="Volver" src="img/volver.png"> Volver</button></a>
				
				<!-- BOTON GUARDAR -->				         
           		<button type="submit" title="Guardar" value="Guardar">
		 			<img id="icono_Editar" alt="Guardar" src="img/editar.png"> Guardar 
				</button>
				
				</p>
				
          </form>


	
	</fieldset>

	<!-- PARTE DE LOS COCHES -->
	<fieldset id="parte_DetalleCoches" >
		<legend>Coches de la empresa</legend>
		
		<a href="#">NUEVO</a>
		
		<ul>
			<c:forEach items="${empresa.listaCoches}" var="coche">
				
					<h4>Coche : </h4>
						<li>Matricula : ${coche.matricula}</li>
						<li>Matricula : ${coche.numeroPlazas}</li>
				
			</c:forEach>
		</ul>
		
	</fieldset>
	
	<!-- PARTE DE LOS EMPLEADOS -->
	<fieldset id="parte_DetalleEmpleados" >
		<legend>Empleados de la empresa</legend>
		
		
		<a href="#">NUEVO</a>

		<table>
			<!-- CABECERA TABLA -->
			<thead>
				<tr>
					<th>Id</th>
					<th>Apellido</th>
					<th>Nombre</th>
					<th>Fecha Nacimiento</th>
					<th>Telefono</th>
					<th>Pais</th>
				</tr>
			</thead>
			<!-- CUERPO TABLA -->
			<tbody>
				<c:forEach items="${empresa.listaEmpleados}" var="empleado">
					<tr>
						<td>${empleado.idEmpleado}</td>
						<td>${empleado.nombre}</td>
						<td>${empleado.apellido}</td>
						<td>${empleado.fechaNacimiento}</td>
						<td>${empleado.telefono}</td>
						<td>${empleado.pais}</td>
						<td><a href="#">MODIFICAR</a></td>
						<td><a href="#">ELIMINAR</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
	</fieldset>
	

	
</body>
</html>