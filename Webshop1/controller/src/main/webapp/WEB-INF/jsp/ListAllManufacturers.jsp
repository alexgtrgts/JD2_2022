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
        <th><fmt:message key="Name" bundle="${messages}"/></th>
        <th><fmt:message key="Address" bundle="${messages}"/></th>
        <th><fmt:message key="Brand" bundle="${messages}"/></th>
        <th></th>
    </tr>
    <c:forEach var="manufacturer" items="${manufacturer}">
        <tr>
            <td>${manufacturer.name}</td>
            <td>${manufacturer.address}</td>
            <td>${manufacturer.brand}</td>
            <td>
                <form action="editManufacturer">
                    <input type="hidden" name="id" value="${manufacturer.id}">
                    <button class="button" type="submit"><fmt:message key="Edit" bundle="${messages}"/></button>
                </form>
            </td>
            <td>
                <form action="deleteManufacturer" method="get">
                    <input type="hidden" name="id" value="${manufacturer.id}">
                    <button class="button" type="submit" value="${manufacturer.id}"><fmt:message key="Delete"
                                                                                                 bundle="${messages}"/></button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<div align="center">
    <form action="AddManufacturer.jsp">
        <button class="button1" type="submit"><fmt:message key="addamanufacturer" bundle="${messages}"/></button>
    </form>
    <br>
    <form action="../static/1.html">
        <button class="button1" type="submit"><fmt:message key="GoToTheMainPage" bundle="${messages}"/></button>
    </form>
</div>
</body>
</html>