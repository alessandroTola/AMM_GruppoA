<%-- 
    Document   : loginCl
    Created on : 28-apr-2016, 18.43.27
    Author     : alessandrotola
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="form">
    <h3>LOGIN</h3>
    <form class="Login-form" action="Login" method="post">
        <input type="hidden" name="cmd" value="login">
        <label for="userid">User ID</label>
        <input type="text" name="userid" id="userid" placeholder="User ID" />
        <label for="pswd">Password</label>
        <input type="password" name="pswd" id="pswd" value="valore oscurato" />
        <button type="submit" name="Submit">Login</button>
    </form>
</div>
