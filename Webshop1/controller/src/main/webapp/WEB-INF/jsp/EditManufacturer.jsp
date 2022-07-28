<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="MessageBundle" var="messages"/>

<!DOCTYPE html>
<html lang="${lang}">
<head>
    <link rel="stylesheet" type="text/css" href="../../static/css/edit.css">
    <title><fmt:message key="Pleaseeditmanufacturer'sdata" bundle="${messages}"/></title>
</head>
<p>
<div align="center">
    <fieldset class="fieldset">
        <form action="updateManufacturer" method="get">
            <label for="name"><fmt:message key="Name" bundle="${messages}"/></label>
            <input type="text" id="name" name="name" value="${manufacturer.name}"><br>
            <input type="hidden" id="id" name="id" value="${manufacturer.id}"><br>
            <label for="address"><fmt:message key="Address" bundle="${messages}"/></label>
            <input type="text" id="address" name="address" value="${manufacturer.address}"><br>
            <label for="brand"><fmt:message key="Brand" bundle="${messages}"/></label>
            <input type="text" id="brand" name="brand" value="${manufacturer.brand}"><br>
            <input class="button" type="submit" value="Подтвердить"><br>
            <button class="button" type="submit" value="index.jsp"><fmt:message key="GoBack"
                                                                                bundle="${messages}"/></button>
        </form>
    </fieldset>
</div>
</body>
</html>
