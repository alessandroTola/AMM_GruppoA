<%-- 
    Document   : ErroreDatiProdotto
    Created on : 29-giu-2016, 12.11.41
    Author     : alessandrotola
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

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
                    <h3>Errore inserimento dati, inserisci i dati in modo corretto</h3>
                </div>
            </div>
            <div class="content">
                <div class="form">
                    <jsp:include page="./jspSupporto/registraProdotto.jsp" />
                </div>
            </div>
        <jsp:include page="./jspSupporto/footer.jsp" />
        </div>
    </body>
</html>
