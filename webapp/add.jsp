<%-- 
    Document   : add
    Created on : Mar 25, 2023, 2:44:33 PM
    Author     : Nam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./style/style.css"/>
        <title>Update or Add</title>
    </head>
    <body>
        <h1>Product</h1>
        <i>You must enter a description for the product</i>
        <form method="POST">
            <input type="hidden" name="action" value="${action}">
            <div class="form-input">
                <label for="code">Product code</label>
                <input type="text" id="code" name="code" value="${product.code}">
            </div>
            <div class="form-input">
                <label for="description">Product Description</label>
                <input type="text" id="description" name="description" value="${product.description}">
            </div>
            <div class="form-input">
                <label for="price">Product Price</label>
                <input type="text" id="price" name="price" value="${product.price}" >
            </div>
            <input type="submit" value="${action}">
        </form>
    </body>
</html>
