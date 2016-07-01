<%-- 
    Document   : erroreAcquisto
    Created on : 24-mag-2016, 18.41.56
    Author     : alessandrotola
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

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
                <h3>Mi dispiace non hai abbastanza disponibilità</h3>
                <h3>Il tuo saldo disponibile è ${oldSaldo}</h3>
            </div>
        </div>
        <jsp:include page="./jspSupporto/footer.jsp" />
        </div>

    </body>
</html>


