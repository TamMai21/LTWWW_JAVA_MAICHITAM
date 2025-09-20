<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.tuan04.model.User" %>
<html>
<head>
    <title>Registration Result</title>
    <style>
        body { font-family: Arial, sans-serif; }
        .container { width: 400px; margin: auto; padding: 20px; border: 1px solid #ccc; }
        h2 { text-align: center; }
        p { margin: 8px 0; }
        .label { font-weight: bold; }
    </style>
</head>
<body>
<div class="container">
    <h2>Registration Successful!</h2>

    <%
        User user = (User) request.getAttribute("user");
        if (user != null) {
    %>
    <p><span class="label">First Name:</span> <%= user.getFirstName() %></p>
    <p><span class="label">Last Name:</span> <%= user.getLastName() %></p>
    <p><span class="label">Email:</span> <%= user.getEmail() %></p>
    <p><span class="label">Re-entered Email:</span> <%= user.getReEmail() %></p>
    <p><span class="label">Password:</span> <%= user.getPassword() %></p>
    <p><span class="label">Birthday:</span> <%= user.getBirthday() %></p>
    <p><span class="label">Gender:</span> <%= user.getGender() %></p>
    <%
    } else {
    %>
    <p>No user data found.</p>
    <%
        }
    %>
</div>
</body>
</html>
