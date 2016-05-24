<%-- 
    Document   : erroreAcquisto
    Created on : 24-mag-2016, 18.41.56
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
                <h3>Riepilogo</h3>
                <h3>Nome prodotto - ${prodotto.nomeProdotto}</h3> 
                <h3>Descrione - ${prodotto.descrizione}</h3>
                <h3>Prezzo - ${prodotto.prezzo}</h3>
                <h3>Quantita - ${prodotto.quantita}</h3>
                <h3>Immagine</h3><img title="${prodotto.nomeProdotto}" alt="${prodotto.descrizione}" src="${prodotto.linkFoto}" 
                         width="100" height="100">
                <h3>Mi dispiace non hai abbastanza disponibilità</h3>
                <h3>Il tuo saldo disponibile è ${cliente.getSaldo().getSaldo()}</h3>
            </div>
        </div>
                         
            
        <jsp:include page="./jspSupporto/footer.jsp" />
        </div>

    </body>
</html>

