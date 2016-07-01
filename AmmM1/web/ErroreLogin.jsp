<%-- 
    Document   : ErroreLogin
    Created on : 29-giu-2016, 11.58.57
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
            <div class="content">
                <div class="form">
                    <h3>Non hai i permessi per accedere a questa area</h3>
                </div>
            </div>
        <jsp:include page="./jspSupporto/footer.jsp" />
        </div>
    </body>
</html>
