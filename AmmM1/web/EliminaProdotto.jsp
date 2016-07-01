<%-- 
    Document   : EliminaProdotto
    Created on : 25-giu-2016, 20.58.12
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
            <div class="content" id="tabella">
                <div class="form">
                        <h3>Benvenuto </h3>
                        <p>
                        ${venditore.getNome()} - 
                        ${venditore.getCognome()} 
                        </p>
                </div>
                <div id="table">
                    <table>
                        <tr>
                            <th class="prodotto">Prodotto</th>
                            <th>Foto</th>
                            <th class="tot">Tot</th>
                            <th>Prezzo</th>
                            <th class="prezzo">Seleziona</th>
                        </tr>
                        <c:forEach var="prodotto" items="${sellerList}" >
                        <tr>
                            <td class="prodotto">${prodotto.getNomeProdotto()}</td>
                            <td><img title="${prodotto.nomeProdotto}" alt="${prodotto.descrizione}" src="${prodotto.linkFoto}" 
                                     width="100" height="100"></td>
                            <td class="tot">${prodotto.quantita}</td>
                            <td class="prezzo">${prodotto.prezzo}€</td>
                            <td>
                                <a href="EliminaProdotto?idProdotto=${prodotto.id}">
                                    <img src="Immagini/icon.png" width="64" height="64" />
                                </a>
                            </td>
                        </tr>
                        </c:forEach> 

                    </table>
    </div>
</div>

        <jsp:include page="./jspSupporto/footer.jsp" />
    </body>
</html>
