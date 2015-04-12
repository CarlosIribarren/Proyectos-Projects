<%@page import="IraunkortasunMaila.ZenbakiJokoaDatuBasea"%>

<%@ page import = "bean.ZenbakiaIgarriBean" %>
<jsp:useBean id="zenbigarri" class="bean.ZenbakiaIgarriBean" scope="session"/>
<jsp:setProperty name="zenbigarri" property="*"/>

<html>
<head><title>ZENBAKIA IGARTZEN JOKOA</title></head>
<body bgcolor="white">
<font size=4>

<%
    if (zenbigarri.getarrakasta()==true)
    {    
%>
        ZORIONAK !  Igarri duzu zenbakia.
        Proba kopurua : <%= zenbigarri.getprobaKopurua() %> proba.<p>
   
        <% zenbigarri.bukatu(); %>
        <a href="zenbaki.jsp">Probatu nahi berriz</a>  ?
<%
    } 
    else if (zenbigarri.getprobaKopurua() == 0) 
    { 
        zenbigarri.hasieratu();
%>
        Ongi etorri ZENBAKIA IGARRI JOKORA.<p>
        Zenbaki bat sortuko dut 1 eta 100 bitartean.<p>
        <form method=get>
        Sartu zure aukera? <input type=text name=proba>
        <input type=submit value="Submit">
        </form>

<%
    } 
    else 
    { 
%>
        Aukera ona baina ez da zenbakia.  Proba: <b><%= zenbigarri.getaholkua() %></b>.
        Egin duzun proba kopurua : <%= zenbigarri.getprobaKopurua() %> proba.<p>
        Gogoratu zenbakia 1 eta 100 bitartean dagoela.<p>
        <form method=get>
        Sartu zure aukera? <input type=text name=proba>
        <input type=submit value="Submit">
        </form>

<% } %>

</font>
</body>
</html>
