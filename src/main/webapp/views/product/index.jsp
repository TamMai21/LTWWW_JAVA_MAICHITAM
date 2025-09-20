<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>Product List</title>
</head>
<body>
<h1>Danh sách sản phẩm</h1>
<li>QUay ve<a href="${pageContext.request.contextPath}">Quay ve</a></li>

<table border="1" cellpadding="8" cellspacing="0">
  <tr>
    <th>ID</th>
    <th>Model</th>
    <th>Description</th>
    <th>Quantity</th>
    <th>Price</th>
    <th>Image</th>
  </tr>
  <c:forEach var="p" items="${products}">
    <tr>
      <td>${p.id}</td>
      <td>${p.model}</td>
      <td>${p.description}</td>
      <td>${p.quantity}</td>
      <td>${p.price}</td>
      <td><img src="${p.imgURL}" alt="Image" width="80"/></td>
    </tr>
  </c:forEach>
</table>

</body>
</html>
