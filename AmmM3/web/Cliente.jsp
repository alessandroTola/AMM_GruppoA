<%-- 
    Document   : Cliente
    Created on : 28-apr-2016, 8.58.49
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
        <meta name="description" content="Tabella prodotti disponibile">
        <jsp:include page="./jspSupporto/Header.jsp" />
    </head>
    <body>
        <jsp:include page="./jspSupporto/Top_navBar.jsp" />
            <div class="content" id="tabella">
                <div id="table">
                    <table>
                        <tr>
                            <th class="prodotto">Prodotto</th>
                            <th>Foto</th>
                            <th class="tot">Tot</th>
                            <th>Prezzo</th>
                            <th class="prezzo">Carrello</th>
                        </tr>
                        <tr>
                            <td class="prodotto">GT force</td>
                            <td><img title="Force GT" alt="force gt carbon" src="Immagini/gtforce.jpg" 
                                     width="100" height="100"></td>
                            <td class="tot">2</td>
                            <td class="prezzo">4000,00€</td>
                            <td><a href="./cliente.html"><img src="Immagini/carrello.png" width="40" height="45" /></a></td>
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
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    <div class="clear"></div>
    <footer><p>Questo bellissimo sito è prodotto da Alessandro Tola</p></footer>
    </body>
</html>

