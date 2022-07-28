<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="MessageBundle" var="messages"/>

<!DOCTYPE html>
<html lang="${lang}">
<head>
    <link rel="stylesheet" type="text/css" href="../../static/css/edit.css">
    <title><fmt:message key="Pleaseeditproductdata" bundle="${messages}"/></title>
</head>
<body>
<div align="center">
    <fieldset class="fieldset">
        <form action="updateProduct" method="get">
            <label for="name"><fmt:message key="Name" bundle="${messages}"/></label>
            <input type="text" id="name" name="name" value="${product.name}"><br>
            <input type="hidden" id="id" name="id" value="${product.id}"><br>
            <label for="type"><fmt:message key="Type" bundle="${messages}"/></label>
            <input type="text" id="type" name="type" value="${product.type}"><br>
            <label for="description"><fmt:message key="Description" bundle="${messages}"/></label>
            <input type="text" id="description" name="description" value="${product.description}"><br>
            <label for="price"><fmt:message key="Price" bundle="${messages}"/></label>
            <input type="text" id="price" name="price" value="${product.price}"><br>
            <input class="button" type="submit" value="Подтвердить"><br>
            <button class="button" type="submit" value="index.jsp"><fmt:message key="GoBack"
                                                                                bundle="${messages}"/></button>
        </form>
    </fieldset>
</div>
</body>
</html>
