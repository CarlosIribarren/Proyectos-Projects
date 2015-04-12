<%-- 
    Document   : errorea
    Created on : 11-nov-2012, 23:40:03
    Author     : Carolo
--%>
<%//bean definitu %>
<%@ page import = "bean.ErabiltzaileaBean" %>
<jsp:useBean id="saioa" class="bean.ErabiltzaileaBean" scope="session"/>
<jsp:setProperty name="saioa" property="*"/>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> Erabiltzailea (  <% out.println( saioa.getIzena());    %> )   Saiakera maximoak gainditu ditu!!!!!!!!</h1>
        <h1> Aplikazioan sartzeko baimena galdu du.</h1>
        <h1> Mesedez aplikazioaren kudeatzaileari pasahitz berria eskatu.</h1>

    </body>
</html>
