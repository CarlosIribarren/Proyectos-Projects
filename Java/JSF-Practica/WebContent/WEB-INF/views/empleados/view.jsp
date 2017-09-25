<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Plantilla básica de Bootstrap</title>
 
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

<!-- UTILIZAMOS LA CLASE CONTAINER DE Bootstrap -->
	<div class="container">
	
	<!-- col-sm-6 : para dispositivos sm ( SMALL ) 
	 -->
	<div class="row">
		<div class="col-sm-6"> dispositivos pequeños => configurado 6 columnasssssssssssssssssssssssssssssssssssssssssss</div>
		<div class="col-sm-12 col-xs-6"> dispositivos pequeños => configurado 12 columnasssssssssssssssssssssssssssssssssssssssssssss</div>
	
		<!-- DESPLAZAR LA COLUMNA A LA -->
		<div class="col-sm-offset-6 col-sm-6"> dispositivos pequeños => configurado 6 columnasssssssssssssssssssssssssssssssssssssssssss</div>
	</div>
	
		<a href="${pageContext.request.contextPath}">Volver</a>

		<h2>Empleados en request</h2>
		<ul>
			<c:forEach items="${empleados}" var="empleado">
				<li>${empleado.nombre}</li>
			</c:forEach>
		</ul>

		<h2>Empleados en session</h2>
		<ul>
			<c:forEach items="${sessionScope['empleados']}" var="empleado">
				<li>${empleado.nombre}</li>
			</c:forEach>
		</ul>

		<h2>Empleado by id "carlos11"</h2>
		<p>${empleado.nombre}</



			<!-- Librería jQuery requerida por los plugins de JavaScript -->
			<script src="http://code.jquery.com/jquery.js"></script>

			<!-- JS de Bootstrap -->
			<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

			<!-- CUSTOM JS -->
			<script src="${pageContext.request.contextPath}/js/customJS.js"></script>
	</div>
</body>
</html>