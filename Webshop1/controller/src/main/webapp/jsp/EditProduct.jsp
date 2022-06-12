<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Please edit product data</title>
</head>
<body>
<form action="updateProduct" method="get">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" value="${product.name}"><br>
    <input type="hidden" id="id" name="id" value="${product.id}"><br>
    <label for="type">Type:</label>
    <input type="text" id="type" name="type" value="${product.type}"><br>
    <label for="description">Description:</label>
    <input type="text" id="description" name="description" value="${product.description}"><br>
    <label for="price">Price:</label>
    <input type="text" id="price" name="price" value="${product.price}"><br>
    <input type="submit"><br>
    <button type="reset">Clear</button>
</form>
</body>
</html>
