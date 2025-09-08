<%@page bean id="cart" scope="session" class="se.iuh.edu.vn.beans.CartBean" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Shopping cart</title>
</head>
<body>
<p><a href="/ShoppingCartJSPSession/DS8">Product List</a></p>
<table width="100%" border="1">
    <tr bgcolor="#cccccc">
        <td>Model Description</td> <td>Quantity</td>
        <td>Unit Price</td> <td>Total</td>
    </tr>

    <% if (cart.getLineItemCount() == 0) { %>
    <tr>
        <td colspan="4">Cart is currently empty <br />
        </td>
    </tr>
    <% } %>

    <c:forEach var="cartItem" items="${cart.cartItems}" varStatus="counter">
        <form name="item" method="POST" action="/ShoppingCartJSPSession/CartController">
            <tr>
                <td>
                    <c:out value="${cartItem.partNumber}" /><br />
                    <c:out value="${cartItem.modelDescription}" /><br />
                </td>
                <td>
                    <input type="hidden" name="itemindex" value="<c:out value="${counter.count}" />">
                    <input type="text" name="quantity" value="<c:out value="${cartItem.quantity}" size="2">
                <input type="submit" name="action" value="Update">
                    <input type="submit" name="action" value="Delete">
                </td>
                <td><c:out value="${cartItem.unitCost}" /><br>
                <td><c:out value="${cartItem.totalCost}" /><br>
            </tr>
        </form>
    </c:forEach>

    <tr>
        <td colspan="3"></td>
    </tr>
    <tr>
        <td colspan="3">Sub-total: $<c:out value="${cart.orderTotal}" /><br>
    </tr>
</table>
</body>
</html>