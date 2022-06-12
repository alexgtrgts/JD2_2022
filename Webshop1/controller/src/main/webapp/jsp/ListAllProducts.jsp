<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<br>
<br>
<table>
    <tr>
        <th>Name</th>
        <th>Type</th>
        <th>Description</th>
        <th>Price</th>
        <th></th>
    </tr>
    <c:forEach var="product" items="${product}">
        <tr>
            <td>${product.name}</td>
            <td>${product.type}</td>
            <td>${product.description}</td>
            <td>${product.price}</td>
            <td>
                <form action="editProduct">
                    <input type="hidden" name="id" value="${product.id}">
                    <button type="submit">Edit</button>
                </form>
            </td>
            <td>
                <form action="deleteProduct" method="get">
                    <input type="hidden" name="id" value="${product.id}">
                    <button type="submit" value="${product.id}">Delete</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td>
            <a href="AddProduct.jsp">Add a product</a>
        </td>
    </tr>
</table>
<br>
<a href="../../../../../src/main/webapp/index.jsp">Go to the main page</a>
</body>
</html>