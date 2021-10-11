<%-- 
    Document   : home.jsp
    Created on : Oct 9, 2021, 5:11:20 PM
    Author     : 821320
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1><b>Home Page</b></h1>
        
        <h2><b>Hello ${username}</b></h2>
        
        <a href="/MyLogin/login?logOut=logout">Log out</a>
    </body>
</html>
