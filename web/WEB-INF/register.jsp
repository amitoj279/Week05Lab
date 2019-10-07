<%-- 
    Document   : register
    Created on : Oct 7, 2019, 9:22:15 AM
    Author     : 794473
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <br>
        <form action="shoppingList" method="post"> 
            Username: <input type="text" name="name">
            <input type="hidden" name="action" value="register">
            <br>
            <br>
            <input type="submit" value="Register Name">
        </form>
    </body>
</html>
