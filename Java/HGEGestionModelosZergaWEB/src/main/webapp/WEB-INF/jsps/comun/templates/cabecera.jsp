<%@ include file="taglibs.jsp"%>

<link href="${pageContext.request.contextPath}/estatico/comun/css/cabecera.css" rel="stylesheet" type="text/css" />

<header>    		
	<ul id="menu">
  		<li class="derecha"><a href="${pageContext.request.contextPath}/inicio?locale=es">ES</a></li>
  		<li class="derecha"><a href="${pageContext.request.contextPath}/inicio?locale=eu">EU</a></li>
	</ul>
</header>

<nav>
  <ul>
    <li><a href="${pageContext.request.contextPath}/modelos"><spring:message code="modelos"/></a></li>
  </ul>
</nav>