<%-- 
    Document   : registraProdotto
    Created on : 29-apr-2016, 0.01.04
    Author     : alessandrotola
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<h3>Inserisci nuovo prodotto</h3>
<form id="prodotto" action="RegistraProdotto" method="get">
    <label for="nomeprod">Nome prodotto:</label>
    <input type="text" name="nomeprod" id="nomeprod" placeholder="Nome prodotto" />
    <label for="immagine">URL immagine:</label>
    <input type="text" name="immagine" id="immagine" placeholder="Link immagine" />
    <label for="descrizione">Descrizione:</label>
    <textarea id="descrizione" name="descrizione" ></textarea>
    <label for="prezzo">Prezzo:</label>
    <input type="number" name="prezzo" id="prezzo" min="0" step="0.1"/>
    <label for="quantita">Quantità:</label>
    <input type="number" name="quantita" id="quantita" min="0" />
    <button type="submit" name="Submit">Inserisci</button>
</form>

