<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html lang="es">
<head>
<title>Gestion de modelos de Zerga</title>
<!-- Bootstrap -->
<link href="${pageContext.request.contextPath}/estatico/bootstrap/bootstrap.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/estatico/bootstrap/bootstrap.min.js"></script>
</head>
<body>



  <%--   <c:out value="Modelo : "></c:out> --%>
  <%--   <c:out value="${modelo.modelo}"></c:out> --%>

  <%--   <c:out value="Ejercicio Real : "></c:out> --%>
  <%--   <c:out value="${modelo.ejercicioReal}"></c:out> --%>

  <%--   <c:out value="modl_zerga : "></c:out> --%>
  <%--   <c:out value="${modelo.modl_zerga}"></c:out> --%>

  <%--   <c:out value="modl_reg_activo : "></c:out> --%>
  <%--   <c:out value="${modelo.modl_reg_activo}"></c:out> --%>

<h1 class="h1">Gestion de modelos de Zerga</h1>

  <div class="container">
    <div class="row">
      <div class="col-sm-4">

        <table class="table table-striped">
          <!-- CABECERA TABLA -->
          <thead>
            <tr>
              <th><c:out value="MODELO"></c:out></th>
              <th><c:out value="EJERCICIO REAL"></c:out></th>
              <th><c:out value="MODL"></c:out></th>
              <th><c:out value="MODL REG ACTIVO"></c:out></th>
              <th><c:out value="EDITAR"></c:out></th>
            </tr>
          </thead>
          <!-- CUERPO TABLA -->
          <tbody>
            <c:forEach var="modelo" items="${modelos}">
              <tr>
                <th><c:out value="${modelo.modelo}"></c:out></th>
                <th><c:out value="${modelo.ejercicioReal}"></c:out></th>
                <th><c:out value="${modelo.modl_zerga}"></c:out></th>
                <th><c:out value="${modelo.modl_reg_activo}"></c:out></th>
                <th><a href="#">Editar</a></th>
              </tr>
            </c:forEach>
          </tbody>
        </table>

      </div>
    </div>
  </div>

</body>
</html>