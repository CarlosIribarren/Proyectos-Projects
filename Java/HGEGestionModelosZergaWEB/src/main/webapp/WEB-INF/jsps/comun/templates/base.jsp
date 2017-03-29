<!doctype html>

<%@ include file="taglibs.jsp"%>
<html lang="${springRequestContext.locale}">
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta charset="UTF-8" />
<title>Spring Guia Rapida</title>

<!-- Comun CSS y JS -->
<link href="${pageContext.request.contextPath}/estatico/comun/css/comun.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/estatico/comun/js/comun.js"></script>

<!-- AutoNumeric -->
<script src="${pageContext.request.contextPath}/estatico/autoNumeric/autoNumeric.js"></script>

<!-- JQuery -->
<script src="${pageContext.request.contextPath}/estatico/jquery/jquery.min.js"></script>

<!-- Bootstrap -->
<link href="${pageContext.request.contextPath}/estatico/bootstrap/bootstrap.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/estatico/bootstrap/bootstrap.min.js"></script>

<!-- Select2 -->
<link href="${pageContext.request.contextPath}/estatico/select2/select2.min.css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/estatico/select2/select2.min.js"></script>

</head>
<body>
  <div class="container">

    <h1 class="h1">Gestion de modelos de Zerga</h1>

    <tiles:insertAttribute name="cabecera" />
    <tiles:insertAttribute name="cuerpo" />
    <tiles:insertAttribute name="pie" />
  </div>
</body>
</html>