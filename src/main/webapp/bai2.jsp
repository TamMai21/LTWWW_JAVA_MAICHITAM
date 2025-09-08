<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Registration Form</title>
    <style>
        body { font-family: Arial, sans-serif; }
        .container { width: 400px; margin: auto; padding: 20px; border: 1px solid #ccc; }
        h2 { text-align: center; }
        input, select { width: 100%; padding: 8px; margin: 5px 0; }
        .row { display: flex; gap: 10px; }
        .row input { flex: 1; }
        .gender { display: flex; gap: 15px; margin: 5px 0; }
        button { width: 100%; padding: 10px; background: #2a5dba; color: #fff; border: none; cursor: pointer; }
        button:hover { background: #1e4791; }
    </style>
</head>
<body>
<div class="container">
    <h2>User Registration Form</h2>
    <form action="bai2" method="post">
        <div class="row">
            <input type="text" name="firstName" placeholder="First Name" required>
            <input type="text" name="lastName" placeholder="Last Name" required>
        </div>
        <input type="email" name="email" placeholder="Your Email" required>
        <input type="email" name="reEmail" placeholder="Re-enter Email" required>
        <input type="password" name="password" placeholder="New Password" required>

        <label>Birthday</label>
        <div class="row">
            <select name="month" required>
                <option value="">Month</option>
                <option>1</option><option>2</option><option>3</option>
                <option>4</option><option>5</option><option>6</option>
                <option>7</option><option>8</option><option>9</option>
                <option>10</option><option>11</option><option>12</option>
            </select>
            <select name="day" required>
                <option value="">Day</option>
                <% for (int i = 1; i <= 31; i++) { %>
                <option><%= i %></option>
                <% } %>
            </select>
            <select name="year" required>
                <option value="">Year</option>
                <% for (int i = 1980; i <= 2024; i++) { %>
                <option><%= i %></option>
                <% } %>
            </select>
        </div>

        <div class="gender">
            <label><input type="radio" name="gender" value="Female" required> Female</label>
            <label><input type="radio" name="gender" value="Male" required> Male</label>
        </div>

        <button type="submit">Sign Up</button>
    </form>
</div>
</body>
</html>
