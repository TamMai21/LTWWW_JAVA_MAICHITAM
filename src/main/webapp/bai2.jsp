<%@ page import="java.util.List" %>
<%@ page import="com.example.tuan04.model.CartItem" %>
<%@ page import="com.example.tuan04.service.CartServiceImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bài 2 - Shopping Cart</title>
</head>
<body>
<li>QUay ve<a href="${pageContext.request.contextPath}">Quay ve</a></li>
<h2>Danh sách sản phẩm</h2>
<form method="post" action="bai2">
    <input type="hidden" name="action" value="add"/>
    <input type="hidden" name="id" value="P001"/>
    <input type="hidden" name="name" value="Nokia Lumia"/>
    <input type="hidden" name="price" value="99000"/>
    Nokia Lumia - 99000
    <input type="number" name="quantity" value="1" min="1"/>
    <button type="submit">Add to Cart</button>
</form>
<hr/>

<h2>Giỏ hàng</h2>
<%
    CartServiceImpl cartService = new CartServiceImpl();
    List<CartItem> cart = cartService.getCart(session);

    if (cart.isEmpty()) {
%>
<p>Giỏ hàng hiện đang trống</p>
<%
} else {
%>
<table border="1">
    <tr>
        <th>Sản phẩm</th>
        <th>Số lượng</th>
        <th>Giá</th>
        <th>Tổng</th>
        <th>Action</th>
    </tr>
    <%
        for (CartItem item : cart) {
    %>
    <tr>
        <td><%= item.getProduct().getName() %></td>
        <td>
            <form method="post" action="bai2">
                <input type="hidden" name="action" value="update"/>
                <input type="hidden" name="id" value="<%= item.getProduct().getId() %>"/>
                <input type="number" name="quantity" value="<%= item.getQuantity() %>" min="1"/>
                <button type="submit">Update</button>
            </form>
        </td>
        <td><%= item.getProduct().getPrice() %></td>
        <td><%= item.getTotal() %></td>
        <td>
            <form method="post" action="bai2">
                <input type="hidden" name="action" value="remove"/>
                <input type="hidden" name="id" value="<%= item.getProduct().getId() %>"/>
                <button type="submit">Delete</button>
            </form>
        </td>
    </tr>
    <% } %>
    <tr>
        <td colspan="3">Tổng cộng</td>
        <td colspan="2"><%= cartService.getTotal(session) %></td>
    </tr>
</table>
<%
    }
%>
</body>
</html>
