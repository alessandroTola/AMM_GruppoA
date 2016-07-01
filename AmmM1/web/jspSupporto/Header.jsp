<%-- 
    Document   : Header
    Created on : 29-apr-2016, 18.32.15
    Author     : alessandrotola
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<header>
    <nav>
        <div class="logo"></div>
        <div class="bar">
            <ul class="nevHeader">
                <li class="nevHeader"><a class="nevHeader" href="index.jsp">HOME</a></li>
                <li class="nevHeader"><a class="nevHeader" href="${pageContext.request.contextPath}/Login">LOGIN</a></li>
                <li class="nevHeader"><a class="nevHeader" href="${pageContext.request.contextPath}/ClienteLog">CLIENTE</a></li>
                <li class="nevHeader"><a class="nevHeader" href="${pageContext.request.contextPath}/VenditoreLog">VENDITORE</a></li>
                <li class="nevHeader"><a class="nevHeader" href="${pageContext.request.contextPath}/Logout">LOGOUT</a></li>
            </ul>
        </div>
    </nav>
    <!--<h1>MTB no shTop</h1>-->
</header>
