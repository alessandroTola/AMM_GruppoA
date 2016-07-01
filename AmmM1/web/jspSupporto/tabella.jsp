<%-- 
    Document   : tabella
    Created on : 28-apr-2016, 20.10.24
    Author     : alessandrotola
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="content" id="tabella">
    <div class="form">
        <h3>Benvenuto </h3>
        <p>
        ${cliente.getNome()} - 
        ${cliente.getCognome()} 
        </p>
    </div>
    <div class="filtra">
        <!-- Tasto Ricerca -->
        <label for="ricerca">Filtra</label>
        <input type="text" id="ricerca" size="15" />
    </div>
    <div id="table">
        <table>
            <tr>
                <th class="prodotto">Prodotto</th>
                <th>Foto</th>
                <th class="tot">Tot</th>
                <th>Prezzo</th>
                <th class="prezzo">Carrello</th>
            </tr>
            <c:forEach var="prodotto" items="${listaProdotti}" >
            <tr>
                <td class="prodotto">${prodotto.getNomeProdotto()}</td>
                <td><img title="${prodotto.nomeProdotto}" alt="${prodotto.descrizione}" src="${prodotto.linkFoto}" 
                         width="100" height="100"></td>
                <td class="tot">${prodotto.quantita}</td>
                <td class="prezzo">${prodotto.prezzo}€</td>
                <td>
                    <a href="CompraProdotto?idProdotto=${prodotto.id}">
                        <img src="Immagini/carrello.png" width="40" height="45" />
                    </a>
                </td>
            </tr>
            </c:forEach> 
            
        </table>
    </div>
</div>
