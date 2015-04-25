<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/estiloGeneral.css" media="screen"  type="text/css" />
	<title>Eliminar empresa</title>
</head>
<body>

	<h1>Eliminar empresa</h1>

	<!-- RECIBIR EL BEAN -->
		<jsp:useBean id="empresa" class="my.project.model.Empresa" scope="request"/>
		
	<!-- MOSTRAR CONFIRMACION -->
		<h4> Estas seguro de eliminar la empresa ? </h4>
		<p>  Id :  <jsp:getProperty name="empresa" property="idEmpresa"/> </p> 
		<p> Nombre : <jsp:getProperty name="empresa" property="nombre"/> </p> 
		<p> Direccion : <jsp:getProperty name="empresa" property="direccion"/> </p>
		<p> Pais :<jsp:getProperty name="empresa" property="pais"/>  </p>
		 
	<!-- OBTENER ID EN VARIABLE -->
	<% Integer id = empresa.getIdEmpresa(); %>	 

		<form  id="botonAccion" action="EliminarUnaEmpresa" method="post" >
			<input type="hidden" name="id" value="<%=id%>">
			
			<!-- BOTON VOLVER -->
			<a href="MostrarPantallaPrincipal"><button> <img id="icono_Volver" alt="Volver" src="img/volver.png"> Volver</button></a>
				
			<button type="submit" title="Eliminar" value="Eliminar">
		 		<img id="icono_Eliminar" alt="Eliminar" src="img/eliminar.png"> Eliminar 
			</button>
		</form>
				


	 
	 
	 



</body>
</html>