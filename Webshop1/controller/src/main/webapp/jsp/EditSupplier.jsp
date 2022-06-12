<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Please edit supplier data</title>
</head>
<body>
<form action="updateSupplier" method="get">
  <label for="name">Name:</label>
  <input type="text" id="name" name="name" value="${supplier.name}"><br>
  <input type="hidden" id="id" name="id" value="${supplier.id}"><br>
  <label for="address">Address:</label>
  <input type="text" id="address" name="address" value="${supplier.address}"><br>
  <label for="vatnumber">VAT Number:</label>
  <input type="text" id="vatnumber" name="vatnumber" value="${supplier.vatNumber}"><br>
  <input type="submit"><br>
  <button type="reset">Clear</button>
</form>
</body>
</html>

