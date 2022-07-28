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
<body>
<wl:summary>
<h1 align="center"><fmt:message key="Pleaseaddmanufacturer" bundle="${messages}"/></h1>
<br>
<br>
<fieldset>
    <div align="center">
        <form action="AddManufacturer" method="post">
            <label for="name"><fmt:message key="Name" bundle="${messages}"/></label>
            <input type="text" id="name" name="name"><br>
            <label for="address"><fmt:message key="Address" bundle="${messages}"/></label>
            <input type="text" id="address" name="address"><br>
            <label for="brand"><fmt:message key="Brand" bundle="${messages}"/></label>
            <input type="text" id="brand" name="brand"><br>
            <input class="button" type="submit" value="Сохранить"><br>
            <button class="button" type="reset"><fmt:message key="Clear" bundle="${messages}"/></button>
        </form>
        <br>
    </div>
</fieldset>
<div align="center">
    <form action="../static/1.html">
        <button class="button" type="submit"><fmt:message key="GoToTheMainPage" bundle="${messages}"/></button>
    </form>
</div>
</wl:summary>
</body>
</html>