<%-- 
    Document   : form_login
    Created on : 27-apr-2016, 18.35.58
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
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="description" content="Pagina per il login">
        <jsp:include page="./jspSupporto/Head.jsp" />     
    </head>
    <body>
        <jsp:include page="./jspSupporto/Top_navBar.jsp" />
            <c:choose>
            <c:when test="${ loggedIn }" >
                <div class="content">
                    <div class="form">
                        <h2>${u.getNome()} hai già effettuato il login</h2>
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

