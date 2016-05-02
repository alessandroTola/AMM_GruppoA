<%-- 
    Document   : Nuovo_Prodotto
    Created on : 30-apr-2016, 22.13.11
    Author     : alessandrotola
--%>

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
                <h2>Riepilogo</h2>
                <h2>Nome prodotto - </h2><h3>${nuovoProdotto.nomeProdotto}</h3> 
                <h2>Immagine - </h2><h3>${nuovoProdotto.linkFoto}</h3>
                <h2>Descrione - </h2><h3>${nuovoProdotto.descrizione}</h3>
                <h2>Prezzo - </h2><h3>${nuovoProdotto.prezzo}</h3>
                <h2>Quantita - </h2><h3>${nuovoProdotto.quantita}</h3>
            </div>
        </div>
            
        <jsp:include page="./jspSupporto/footer.jsp" />
        </div>

    </body>
</html>
