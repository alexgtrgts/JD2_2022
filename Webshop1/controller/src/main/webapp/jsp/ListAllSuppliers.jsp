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
        <th>ID</th>
        <th>Name</th>
        <th>Address</th>
        <th>VAT Number</th>
        <th></th>
    </tr>
    <c:forEach var="supplier" items="${supplier}">
        <tr>
            <td>${supplier.id}</td>
            <td>${supplier.name}</td>
            <td>${supplier.address}</td>
            <td>${supplier.vatNumber}</td>
            <td>
                <form action="editSupplier">
                    <input type="hidden" name="id" value="${supplier.id}">
                    <button type="submit">Edit</button>
                </form>
            </td>
            <td>
                <form action="deleteSupplier" method="get">
                    <input type="hidden" name="id" value="${supplier.id}">
                    <button type="submit" value="${supplier.id}">Delete</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td>
            <a href="AddSupplier.jsp">Add a supplier</a>
        </td>
    </tr>
</table>
<br>
<a href="../../../../../src/main/webapp/index.jsp">Go to the main page</a>
</body>
</html>