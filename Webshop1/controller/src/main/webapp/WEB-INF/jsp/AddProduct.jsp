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
<h1 align="center"><fmt:message key="Pleaseaddaproduct" bundle="${messages}"/></h1>
<br>
<br>
<div align="center">
    <fieldset>
        <form action="AddProduct" method="post">
            <label for="name"><fmt:message key="Name" bundle="${messages}"/></label>
            <input type="text" id="name" name="name"><br>
            <label for="type"><fmt:message key="Type" bundle="${messages}"/></label>
            <input type="text" id="type" name="type"><br>
            <label for="description"><fmt:message key="Description" bundle="${messages}"/></label>
            <input type="text" id="description" name="description"><br>
            <label for="price"><fmt:message key="Price" bundle="${messages}"/></label>
            <input type="text" id="price" name="price"><br>
            <input class="button" type="submit" value="Сохранить"><br>
            <button class="button" type="reset"><fmt:message key="Clear" bundle="${messages}"/></button>
        </form>
        <br>

        <form action="../static/1.html">
            <button class="button" type="submit"><fmt:message key="GoToTheMainPage" bundle="${messages}"/></button>
        </form>
    </fieldset>
</div>
</body>
</html>