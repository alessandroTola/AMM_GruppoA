<%-- 
    Document   : Venditore_autenticato
    Created on : 26-apr-2016, 22.02.43
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
        <title>Venditore</title>
        <meta name="description" content="Login venditore">
        <jsp:include page="./jspSupporto/Head.jsp" />    
    </head>
    <body>
        <jsp:include page="./jspSupporto/Top_navBar.jsp" />
            <c:choose>
            <c:when test="${loggedVenditore}" >
                <div class="content">
                    <div class="form">
                        <h2>Benvenuto </h2>
                        <h3>${venditore.getNome()} - ${venditore.getCognome()} </h3> 
                        <jsp:include page="./jspSupporto/registraProdotto.jsp" />
                    </div>
                </div>
            </c:when>
            <c:when test="${loggedCliente}" >
            <div class="content">
                <div class="form">
                    <h3>Non hai i permessi per accedere a questa area</h3>
                </div>
            </div>
            </c:when>
            <c:otherwise>
                <div class="content">
                    <jsp:include page="./jspSupporto/loginCl.jsp" />
                </div>
            </c:otherwise>
        </c:choose>
        <jsp:include page="./jspSupporto/footer.jsp" />
    </body>
</html>

