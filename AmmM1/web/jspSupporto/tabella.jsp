<%-- 
    Document   : tabella
    Created on : 28-apr-2016, 20.10.24
    Author     : alessandrotola
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="content" id="tabella">
    <div class="form">
            <h3>Benvenuto </h3>
            <p>
            ${cliente.getNome()} - 
            ${cliente.getCognome()} 
            </p>
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
            <!--<tr>
                <td class="prodotto">GT force</td>
                <td><img title="Force GT" alt="force gt carbon" src="Immagini/gtforce.jpg" 
                         width="100" height="100"></td>
                <td class="tot">2</td>
                <td class="prezzo">4000,00€</td>
                <td><a href="RegistraProdotto?idProdotto=${alunno.id}"><img src="Immagini/carrello.png" width="40" height="45" /></a></td>
                
            </tr>
            <tr>
                <td class="prodotto">Casco Fox</td>
                <td><img title="Casco fox" alt="Casco Fox" src="Immagini/casco.jpg" 
                         width="100" height="100"></td>
                <td class="tot">5</td>
                <td class="prezzo">159,00€</td>
                <td><a href="./cliente.html"><img src="Immagini/carrello.png" width="40" height="45" /></a></td>
            </tr>
            <tr>
                <td class="prodotto">Maglia FOX</td>
                <td><img title="Maglia demo Fox" alt="Maglia Fox" src="Immagini/fox.jpg" 
                         width="100" height="100"></td>
                <td class="tot">10</td>
                <td class="prezzo">59,00€</td>
                <td><a href="./cliente.html"><img src="Immagini/carrello.png" width="40" height="45" /></a></td>
            </tr>
            <tr>
                <td class="prodotto">Pantalone FOX</td>
                <td><img title="Pantalone fox" alt="Pantalone Fox" src="Immagini/pantalone.png" 
                         width="100" height="100"></td>
                <td class="tot">3</td>
                <td class="prezzo">99,00€</td>
                <td><a href="./cliente.html"><img src="Immagini/carrello.png" width="40" height="45" /></a></td>
            </tr>
            <tr>
                <td class="prodotto">Guanti FOX</td>
                <td><img title="Guanti fox" alt="guanti Fox" src="Immagini/guanti.jpg" 
                         width="100" height="100"></td>
                <td class="tot">7</td>
                <td class="prezzo">39,00€</td>
                <td><a href="./cliente.html"><img src="Immagini/carrello.png" width="40" height="45" /></a></td>
            </tr>-->
        </table>
    </div>
</div>
