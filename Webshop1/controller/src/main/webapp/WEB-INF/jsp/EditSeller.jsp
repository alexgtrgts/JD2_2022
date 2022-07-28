<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="MessageBundle" var="messages"/>

<!DOCTYPE html>
<html lang="${lang}">
<head>
    <link rel="stylesheet" type="text/css" href="../../static/css/edit.css">
    <title><fmt:message key="Pleaseeditseller'sdata" bundle="${messages}"/></title>
</head>
<body>
<div align="center">
    <fieldset class="fieldset">
        <form action="updateSeller" method="get">
            <label for="name"><fmt:message key="Name" bundle="${messages}"/></label>
            <input type="text" id="name" name="name" value="${seller.name}"><br>
            <input type="hidden" id="id" name="id" value="${seller.id}"><br>
            <label for="address"><fmt:message key="Address" bundle="${messages}"/></label>
            <input type="text" id="address" name="address" value="${seller.address}"><br>
            <label for="tel"><fmt:message key="Tel" bundle="${messages}"/></label>
            <input type="text" id="tel" name="tel" value="${seller.tel}"><br>
            <input class="button" type="submit" value="Подтвердить"><br>
            <button class="button" type="submit" value="index.jsp"><fmt:message key="GoBack"
                                                                                bundle="${messages}"/></button>
        </form>
    </fieldset>
</div>
</body>
</html>
