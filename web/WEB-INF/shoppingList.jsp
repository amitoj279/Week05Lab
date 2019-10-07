<%-- 
    Document   : shoppingList
    Created on : Oct 7, 2019, 9:23:30 AM
    Author     : 794473
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        Hello, ${name}.
        <br>
        <a href="shoppingList?action=logout"> Logout </a>
        <br>
        <h2>List</h2>
        <form action="shoppingList" method="post">
            Add item: <input type="text" name="item"> <input type="submit" value="Add">
            <input type="hidden" name="action" value="add">
        </form>

        <form action="shoppingList" method="post">
            <table>
                <c:forEach var="stuff" items="${displayList}" >
                    <tr>
                        <td><input type="radio" name="thing" value="${stuff}"></td> 
                        <td>${stuff}</td>
                    </tr>                 
                </c:forEach>
            </table>
            <input type="submit" value="Delete">
            <input type="hidden" name="action" value="delete">
        </form>
    </body>
</html>
