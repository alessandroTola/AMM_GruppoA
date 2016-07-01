<%-- 
    Document   : Cliente_autenticato
    Created on : 26-apr-2016, 22.02.31
    Author     : alessandrotola
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Cliente</title>
        <meta name="description" content="Login cliente">
        <jsp:include page="/Head.jsp" />    
    </head>
    <body>
        <jsp:include page="./jspSupporto/Top_navBar.jsp" />
            <c:choose>
            <c:when test="${loggedCliente}" >
                <jsp:include page="/tabella.jsp" />
            </c:when>
            <c:when test="${loggedVenditore}" >
            <div class="content">
                <div class="form">
                    <h3>Non hai i permessi per accedere a questa area</h3>
                </div>
            </div>
            </c:when>
            <c:otherwise>
                <div class="content">
                    <jsp:include page="/jspSupporto/loginCl.jsp" />
                </div>
            </c:otherwise>
        </c:choose>
        
        <jsp:include page="./jspSupporto/footer.jsp" />
        </div>
    </body>
</html>

