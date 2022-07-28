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
<table align="center" width="700">
    <tr>
        <th><fmt:message key="ID" bundle="${messages}"/></th>
        <th><fmt:message key="Name" bundle="${messages}"/></th>
        <th><fmt:message key="Address" bundle="${messages}"/></th>
        <th><fmt:message key="VatNumber" bundle="${messages}"/></th>
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
                    <button class="button" type="submit"><fmt:message key="Edit" bundle="${messages}"/></button>
                </form>
            </td>
            <td>
                <form action="deleteSupplier" method="get">
                    <input type="hidden" name="id" value="${supplier.id}">
                    <button class="button" type="submit" value="${supplier.id}"><fmt:message key="Delete"
                                                                                             bundle="${messages}"/></button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<div align="center">
    <form action="AddSupplier.jsp">
        <button class="button1" type="submit"><fmt:message key="addasupplier" bundle="${messages}"/></button>
    </form>
    <br>
    <form action="../static/1.html">
        <button class="button1" type="submit"><fmt:message key="GoToTheMainPage" bundle="${messages}"/></button>
    </form>
</div>
</body>
</html>