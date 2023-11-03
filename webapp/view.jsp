<%-- 
    Document   : view
    Created on : Mar 25, 2023, 2:44:49 PM
    Author     : Nam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./style/style.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Product Maintenace</h1>
        <table>
            <tr>
                <th>Code</th>
                <th>Description</th>
                <th>Price</th>
            </tr>
            <c:forEach var="product" items="${listProduct}">
                <tr>
                    <td>${product.code}</td>
                    <td>${product.description}</td>
                    <td>${product.price}</td>
                    <td><a href="updateProduct/${product.code}">Edit</a></td>
                    <td><a href="deleteProduct?productCode=${product.code}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>

        <a href="addProduct">Add Product</a>
    </body>
</html>
