<%-- 
    Document   : delete
    Created on : Mar 25, 2023, 2:44:42 PM
    Author     : Nam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./style/style.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Delete</h1>
        <div class="infor">
            <span>Product Code: ${product.code}</span>
        </div>
         <div class="infor">
            <span>Product Description: ${product.description}</span>
        </div>
         <div class="infor">
            <span>Product Price: ${product.price}</span>
        </div>
        <form method="POST">
            <input type="hidden" name="action" value="delete">
            <button type="submit">Yes</button>
        </form>
        <button><a href="displayProducts">No</a></button>
    </body>
</html>
