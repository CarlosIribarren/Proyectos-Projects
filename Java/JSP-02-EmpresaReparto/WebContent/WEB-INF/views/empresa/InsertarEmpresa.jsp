<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/estiloGeneral.css" media="screen"  type="text/css" />
	<title>Insertar Empresa</title>
</head>
<body>

	<h1>Insertar una Empresa</h1>


	<form id="botonAccion" action="InsertarUnaEmpresa" method="post">
		<p>
			<label>Nombre: </label>
			<input type="text" name="nombre"/>
		</p>
		<p>
			<label>Cif: </label>
			<input type="text" name="cif"/>
		</p>
		<p>
			<label>Direccion : </label>
			<input type="text" name="direccion"/>
		</p>
		<p>
			<label for="pais">Pais:</label>
			<input name="pais" list="paises" placeholder="Seleciona tu pais"/>
			<datalist id="paises">
				<option> España </option>	
				<option> Francia </option>	
				<option> Belgica </option>	
			</datalist>
		</p>
		
		<!-- BOTON VOLVER -->
		<a href="MostrarPantallaPrincipal"><button> <img id="icono_Volver" alt="Volver" src="img/volver.png"> Volver</button></a>
		 
		 <button type="submit" title="Guardar" value="Guardar">
		 	Guardar <img id="icono_Insertar" alt="Guardar" src="img/insertar.png"> 
		</button>	 

	</form>


</body>
</html>