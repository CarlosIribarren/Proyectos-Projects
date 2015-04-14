<%// SAIOA BEAN SORTU  %>
<%@ page import = "bean.ErabiltzaileaBean" %>
<jsp:useBean id="saioa" class="bean.ErabiltzaileaBean" scope="session"/>
<jsp:setProperty name="saioa" property="*"/>

<%@ page import = "bean.ZenbakiaIgarriBean" %>
<jsp:useBean id="zenbigarri" class="bean.ZenbakiaIgarriBean" scope="session"/>
<jsp:setProperty name="zenbigarri" property="*"/>

<%
     // LOGIN EGIN
     if (saioa.loginaEgiaztatu()==true)
     {
         //ERABILTZAILEA EXISTITZEN DA
         // LEHENGO 3 SAIAKERATAN BALDIN BADAGO
         if (saioa.getSaiakerak()<4)
         {
             String a;
             a=saioa.getIzena();
             zenbigarri.setIzena(a);
             response.sendRedirect("zenbaki.jsp");
         }      
     }
     else
     {
         //ERABILTZAILEA EZ EXISTITZEN DA
         //2 AUKERA EGIN DITU, AZKENA AUKERA DAUKA
         if(saioa.getSaiakerak()<3)
         {
             response.sendRedirect("index.html");
         }
         //3 AUKERA GAIZKI EGIN DITU
         if(saioa.getSaiakerak()==3)
         {
             //BEGIRATU EA ERABIL EXISTITZEN DEN BAIMENA KENTZEKO
             if (saioa.erabilExistitzenda()==true)
             {
                //ERABILZAILEA EXISTITZEN DA => BAIMENA KENDU
                saioa.aldatuBaimena("EZ");
                response.sendRedirect("errorea.jsp");                 
             }
             else
             {
                 ////ERABILZAILEA EZ DA EXISTITZEN => INDEX JOAN
                 response.sendRedirect("index.html");
             }
             
         }         
         
     }        


%>




