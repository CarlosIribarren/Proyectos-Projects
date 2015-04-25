<%@page import="java.util.ArrayList"%>
<%@page import="my.project.model.Empresa"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    
    <!-- LIBRERIA -->
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Aplicacion de Gestion de Empresa Reparto</title>
	<link rel="stylesheet" href="css/estiloGeneral.css" media="screen"  type="text/css" />
	<link rel="stylesheet" href="css/estiloPaginaPrincipal.css" media="screen"  type="text/css" />
</head>
<body>
	<h1>Aplicacion de Gestion de Empresa Reparto</h1>
	
	<a href="MostrarInsertarEmpresa">
		<button>
			<img id="icono_Insertar" alt="Guardar" src="img/insertar.png"> Nueva Empresa
		</button>
	</a>

<%
	ArrayList<Empresa> empresas	= null;
	//Recibir Bean ( asegurar que es de la clase ArrayList)
	if (request.getAttribute("listaEmpresas") instanceof ArrayList)
	{
		empresas = (ArrayList<Empresa>) request.getAttribute("listaEmpresas");	
	}
	

	
%>

			<!-- 1.- AL HACER CLICK ENCIMA DEL INPUT(TYPE=IMAGE), ESTE
				 2.- LE DA EL VALOR DEL ID SELECIONADO, AL INPUT(type=TEXT) OCULTO(id=valorSelecionado).
				 3.- EL FORMULARIO ENVIA EL INPUT(type=text)(ocultoID) QUE HAY DENTRO DEL FORM	-->


<!-- SE PODIAN ENVIAR POR GET CON <a>. PERO SEA DECIDIO MEJOR POR POST POR ESO SE UTILIZA FORM.
	 TAMBIEN SE DEFINEN 3 FORMULARIOS PARA PODER REALIZAR 3 ACTION DIFERENTES -->

	<!-- FORMULARIO ELIMINAR EMPRESA -->
	<form id="mostrarEliminarFORM" method="post" action="MostrarEliminarJSP">
		<input id="inputEliminar" type="hidden" name="id" value="" />
	</form>
	<!-- FORMULARIO EDITAR EMPRESA -->
	<form id="mostrarEditarFORM" method="post" action="MostrarEditarJSP">
		<input id="inputEditar" type="hidden" name="id" value="" />
	</form>
	<!-- FORMULARIO GESTIONAR EMPRESA -->
	<form id="mostrarGestionarFORM" method="post" action="MostrarGestionarJSP">
		<input id="inputGestionar" type="hidden" name="id" value="" />
	</form>
		

	

		<table>
			<!-- CABECERA TABLA -->
			<thead>
				<tr >
					<th >Id</th>
					<th>Nombre</th>
					<th>Cif</th>
					<th>Direccion</th>
					<th>Pais</th>
					<th>Eliminar</th>
					<th>Editar</th>
				</tr>
			</thead>
			<!-- CUERPO TABLA -->
			<tbody>
		
			<% 
				for (int a=0;a<empresas.size();a++)
				{
					Empresa e = (Empresa)empresas.get(a);
					out.println("<tr>");
					//out.println("<td>" + "<input type=\"button\" value=\"Contenido del TextArea\" onClick=\"javascript:alert(document.getElementById('" + a + "').value);\">" +"</td>");
					out.println("<td>" + e.getIdEmpresa() +"</td>");
					out.println("<td>" + e.getNombre() +"</td>");
					out.println("<td>" + e.getCif() +"</td>");
					out.println("<td>" + e.getDireccion() +"</td>");
					out.println("<td>" + e.getPais() +"</td>");
					//por cada INPUT se hacen varias cosas en onclick: 
						// 1.- Se envia el valor de id al INPUT(valorSelecionado)(oculto)(arriba)
						// 2.- Se envia el valor de la accion a realizar al INPUT(accion)(oculto)(arriba) => para poder distinguir en el servlet de donde se llama(eliminar?,modificar?,gestionar?)
					out.println("<td >" + "<input form=\"mostrarEliminarFORM\" onclick=\"document.getElementById('inputEliminar').value='"+ e.getIdEmpresa() + "' \" " +
										" id=\"icono_Eliminar\" type=\"image\" src=\"img/eliminar.png\" alt=\"Submit\" >" +  "</td>");
					out.println("<td >" + "<input form=\"mostrarEditarFORM\" onclick=\"document.getElementById('inputEditar').value='"+ e.getIdEmpresa() +  "' \" " +
										" id=\"icono_Editar\" type=\"image\" src=\"img/editar.png\" alt=\"Submit\" >" +  "</td>");
					out.println("</tr>");
					
				}
				
			%>
			
	
			</tbody>
		</table>
		
	<form action="ProcesarPeticionEmpresa" method="post">
		<input id="accion" type="hidden" name="accion" value="VALOR">
		<input id="valorSelecionado" type="hidden" name="idSelecionado" value="VALOR">	
	</form>			

	
</body>
</html>