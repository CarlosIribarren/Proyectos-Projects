//Funcion para insertar un trozo de codigo HTML
function loadXMLDoc(url)
{	
	

	var xmlhttp;
	if (window.XMLHttpRequest)
	 {// code for IE7+, Firefox, Chrome, Opera, Safari
		  xmlhttp=new XMLHttpRequest();
	  }
	else
	  {// code for IE6, IE5
		  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	xmlhttp.onreadystatechange=function()
	  {
		  if (xmlhttp.readyState==4 && xmlhttp.status==200)
			{
				document.getElementById("principal").innerHTML=xmlhttp.responseText;
			}
	  }
		xmlhttp.open("GET",url,true);
		xmlhttp.send();
}

function cargarCategorioasDesdePrincipal(urlCategoria)
{
	document.getElementById("cajaMenuVertical").style.float = 'left';
	document.getElementById("cajaPrincipal").style.float = 'left';
	document.getElementById("cajaPrincipal").style.padding = '0';
	document.getElementById("cajaPrincipal").style.margin = '0';
	document.getElementById("cajaPrincipal").style.width = '80%';
	

	
	//CARGAR TROZO DE MENU IZQUIERDA
	var xmlhttp;
	if (window.XMLHttpRequest)
	 {// code for IE7+, Firefox, Chrome, Opera, Safari
		  xmlhttp=new XMLHttpRequest();
	  }
	else
	  {// code for IE6, IE5
		  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	xmlhttp.onreadystatechange=function()
	  {
		  if (xmlhttp.readyState==4 && xmlhttp.status==200)
			{
				document.getElementById("cajaMenuVertical").innerHTML=xmlhttp.responseText;
			}
	  }
		xmlhttp.open("GET",'menuIzquierda.html',true);
		xmlhttp.send();
	
	//CARGAR TROZO DE CATEGORIAS
	var xmlhttp2;
	if (window.XMLHttpRequest)
	 {// code for IE7+, Firefox, Chrome, Opera, Safari
		  xmlhttp2=new XMLHttpRequest();
	  }
	else
	  {// code for IE6, IE5
		  xmlhttp2=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	xmlhttp2.onreadystatechange=function()
	  {
		  if (xmlhttp2.readyState==4 && xmlhttp2.status==200)
			{
				document.getElementById("principal").innerHTML=xmlhttp2.responseText;
			}
	  }
		xmlhttp2.open("GET",urlCategoria,true);
		xmlhttp2.send();

}

