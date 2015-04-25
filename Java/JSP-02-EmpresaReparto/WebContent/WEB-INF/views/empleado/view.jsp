<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList, my.project.model.Empleado"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
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
	<p>${empleado.nombre}</p>
	
</body>
</html>