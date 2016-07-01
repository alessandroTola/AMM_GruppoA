<%-- 
    Document   : AggiungiProdotto
    Created on : 18-giu-2016, 11.16.00
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
            <div class="content">
                <div class="form">
                    <jsp:include page="./jspSupporto/registraProdotto.jsp" />
                </div>
            </div>
        <jsp:include page="./jspSupporto/footer.jsp" />
    </body>
</html>
