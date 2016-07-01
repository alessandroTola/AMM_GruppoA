<%-- 
    Document   : listaProdottiJason
    Created on : 27-giu-2016, 12.00.03
    Author     : alessandrotola
--%>

<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<json:array>
    <c:forEach var="prodotto" items="${listaProdotti}">
        <json:object>
            <json:property name="nomeProdotto" value="${prodotto.nomeProdotto}"/>
            <json:property name="descrizione" value="${prodotto.descrizione}"/>
            <json:property name="linkFoto" value="${prodotto.linkFoto}"/>
            <json:property name="quantita" value="${prodotto.quantita}"/>
            <json:property name="prezzo" value="${prodotto.prezzo}"/>
            <json:property name="id" value="${prodotto.id}"/>
        </json:object>
    </c:forEach>
</json:array>
