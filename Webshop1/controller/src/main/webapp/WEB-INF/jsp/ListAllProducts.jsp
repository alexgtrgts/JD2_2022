<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="MessageBundle" var="messages"/>

<!DOCTYPE html>
<html lang="${lang}">
<head>
    <link rel="stylesheet" type="text/css" href="../../static/css/listall.css">
</head>
<body>
<br>
<br>
<table align="center" width="700" border="2">
    <tr>
        <td><fmt:message key="Name" bundle="${messages}"/></td>
        <td><fmt:message key="Type" bundle="${messages}"/></td>
        <td><fmt:message key="Description" bundle="${messages}"/></td>
        <td><fmt:message key="Price" bundle="${messages}"/></td>
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
                    <button class="button" type="submit"><fmt:message key="Edit" bundle="${messages}"/></button>
                </form>
            </td>
            <td>
                <form action="deleteProduct" method="get">
                    <input type="hidden" name="id" value="${product.id}">
                    <button class="button" type="submit" value="${product.id}"><fmt:message key="Delete"
                                                                                            bundle="${messages}"/></button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<div align="center">
    <form action="AddProduct.jsp">
        <button class="button1" type="submit"><fmt:message key="addaproduct" bundle="${messages}"/></button>
    </form>
    <br>
    <form action="../static/1.html">
        <button class="button1" type="submit"><fmt:message key="GoToTheMainPage" bundle="${messages}"/></button>
    </form>
</div>
</body>
</html>