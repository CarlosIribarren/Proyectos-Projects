<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/estiloGeneral.css" media="screen"  type="text/css" />
	<title>Insertar un Coche</title>
</head>
<body>

	<h1>Insertar un Coche</h1>


	<form id="botonAccion" action="InsertarUnaCoche" method="post">
		<p>
			<label>Matricula: </label>
			<input type="text" name="matricula"/>
		</p>
		<p>
			<label>Modelo: </label>
			<input type="text" name="modelo"/>
		</p>
		<p>
			<label>Marca : </label>
			<input type="text" name="marca"/>
		</p>
		
		<p>
			<label>Plazas : </label>
			<input type="text" name="numeroPlazas"/>
		</p>
		
		<p>
			<label>Empleado Asigando : </label>
			<input type="text" name="idEmpleado"/>
		</p>		
		
		<!-- BOTON VOLVER -->
		<a href="MostrarPantallaPrincipal"><button> <img id="icono_Volver" alt="Volver" src="img/volver.png"> Volver</button></a>
		 
		 <button type="submit" title="Guardar" value="Guardar">
		 	Guardar <img id="icono_Insertar" alt="Guardar" src="img/insertar.png"> 
		</button>	 

	</form>


</body>
</html>