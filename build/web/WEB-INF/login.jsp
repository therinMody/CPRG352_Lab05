<%-- 
    Document   : login.jsp
    Created on : Oct 9, 2021, 5:11:09 PM
    Author     : 821320
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1><b>Login</b></h1>
        
        <h2>${message}</h2>
        
        <form method="POST" action="login">
            <table>
            <tr>
                <td>Username:</td>
                <td><input type="text" name="username" value="${username}"</td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password" value="${password}"</td>
            </tr>
        </table>
        
            <button type="submit">Log in</button>
        </form>
        
        
    </body>
</html>
