<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="MessageBundle" var="messages"/>

<!DOCTYPE html>
<html lang="${lang}">
<head>
    <link rel="stylesheet" type="text/css" href="../../static/css/style.css">
</head>
<p>
<h1 align="center"><fmt:message key="Pleaseaddasupplier" bundle="${messages}"/></h1>
<br>
<br>
<div align="center">
    <fieldset>
        <form action="AddSupplier" method="get">
            <label for="name"><fmt:message key="Name" bundle="${messages}"/></label>
            <input type="text" id="name" name="name"><br>
            <label for="address"><fmt:message key="Address" bundle="${messages}"/></label>
            <input type="text" id="address" name="address"><br>
            <label for="vatNumber"><fmt:message key="VatNumber" bundle="${messages}"/></label>
            <input type="text" id="vatNumber" name="vatNumber"><br>
            <input class="button" type="submit" value="Сохранить"><br>
            <button class="button" type="reset"><fmt:message key="Clear" bundle="${messages}"/></button>
        </form>
        <br>
    </fieldset>

    <form action="../static/1.html">
        <button class="button" type="submit"><fmt:message key="GoToTheMainPage" bundle="${messages}"/></button>
    </form>
</div>
</body>
</html>