<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Product List</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <style>
        table {
            padding: 5px; margin: 10px;
            float: left; text-align: center;
        }
    </style>

    #link {
    width: 80px; height: 100px;
    }
    </style>
</head>

<body>
<p><a href="/ShoppingCartJSPSession/ShoppingCart.jsp">View Cart</a></p>

<c:forEach items="${ds}" var="sp">
    <div class="sp">
        <table border="1" method="POST" action="/ShoppingCartJSPSession/CartController">
            <tr><td>Model</td></tr>
            <tr><td>${sp.model}</td></tr>
            Price: ${sp.price}
            <input type="text" size="2" value="1" name="quantity"><br>
            <input type="hidden" value="${sp.id}" name="modelNo">
            <input type="hidden" name="description" value="${sp.model}">
            <input type="hidden" name="action" value="add">
            <input type="submit" name="action" value="add">
    </div>
</c:forEach>
</body>
</html>