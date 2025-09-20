<%@ page import="java.util.List" %>
<%@ page import="com.example.tuan04.model.DanhMuc" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm Tin Tức Mới</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        .header {
            background-color: #f0f0f0;
            padding: 10px;
            margin-bottom: 20px;
        }
        .form-section {
            background-color: #f9f9f9;
            padding: 15px;
            margin: 10px 0;
        }
        .error {
            color: red;
            font-weight: bold;
        }
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        input[type="text"], input[type="url"], textarea, select {
            width: 100%;
            padding: 5px;
        }
        .nav-links {
            margin: 20px 0;
        }
        .nav-links a {
            margin-right: 15px;
            text-decoration: none;
            color: #007bff;
        }
        .nav-links a:hover {
            text-decoration: underline;
        }
    </style>
    <script>
        function validateForm() {
            var lienKet = document.forms["tinTucForm"]["lienKet"].value;
            var noiDung = document.forms["tinTucForm"]["noiDung"].value;

            // Kiểm tra URL format
            if (!lienKet.match(/^https?:\/\/.+/)) {
                alert("Liên kết phải bắt đầu bằng http://");
                return false;
            }

            // Kiểm tra độ dài nội dung
            if (noiDung.length > 255) {
                alert("Nội dung không được quá 255 ký tự");
                return false;
            }

            return true;
        }
    </script>
</head>
<body>

<div class="header">
    <h1>NEWS - Thêm Tin Tức Mới</h1>
</div>

<div class="nav-links">
    <a href="${pageContext.request.contextPath}/bai3">Danh sách tin tức</a>
    <a href="${pageContext.request.contextPath}/addNews">Thêm tin tức mới</a>
    <a href="${pageContext.request.contextPath}/manage">Chức năng quản lý</a>
    <li>Quay ve <a href="${pageContext.request.contextPath}">Quay ve</a></li>
</div>

<h2>Họ tên sinh viên - Mã sinh viên - Lớp</h2>

<%-- Display error messages --%>
<% if (request.getAttribute("error") != null) { %>
<div class="error"><%= request.getAttribute("error") %></div>
<% } %>

<div class="form-section">
    <h3>Thêm tin tức mới</h3>
    <form name="tinTucForm" method="post" action="addNews" onsubmit="return validateForm()">
        <table>
            <tr>
                <td><strong>Mã TT:</strong></td>
                <td><input type="text" name="maTT" required placeholder="Nhập mã tin tức"/></td>
            </tr>
            <tr>
                <td><strong>Tiêu đề:</strong></td>
                <td><input type="text" name="tieuDe" required placeholder="Nhập tiêu đề tin tức"/></td>
            </tr>
            <tr>
                <td><strong>Liên kết:</strong></td>
                <td><input type="url" name="lienKet" required placeholder="http://example.com"/></td>
            </tr>
            <tr>
                <td><strong>Nội dung:</strong></td>
                <td>
                    <textarea name="noiDung" rows="5" maxlength="255" required
                              placeholder="Nhập nội dung tin tức (tối đa 255 ký tự)"
                              onkeyup="document.getElementById('charCount').innerHTML = this.value.length + '/255'"></textarea>
                    <div id="charCount">0/255</div>
                </td>
            </tr>
            <tr>
                <td><strong>Thông tin danh mục:</strong></td>
                <td>
                    <select name="danhMuc" required>
                        <option value="">-- Chọn danh mục --</option>
                        <%
                            List<DanhMuc> danhMucList = (List<DanhMuc>) request.getAttribute("danhSachDanhMuc");
                            if (danhMucList != null) {
                                for (DanhMuc dm : danhMucList) {
                        %>
                        <option value="<%= dm.getMadm() %>"><%= dm.getTendm() %></option>
                        <%      }
                        }
                        %>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center;">
                    <button type="submit" style="padding: 10px 20px; margin: 5px;">Thêm tin tức</button>
                    <button type="reset" style="padding: 10px 20px; margin: 5px;">Reset</button>
                    <a href="${pageContext.request.contextPath}/bai3"
                       style="padding: 10px 20px; margin: 5px; text-decoration: none; background-color: #6c757d; color: white;">
                        Quay lại
                    </a>
                </td>
            </tr>
        </table>
    </form>
</div>

<div style="margin-top: 20px; padding: 10px; background-color: #e9ecef;">
    <h4>Lưu ý khi thêm tin tức:</h4>
    <ul>
        <li>Mã TT, Tiêu đề, Liên kết, Nội dung, Thông tin danh mục của tin là bắt buộc nhập</li>
        <li>Liên kết bắt đầu bởi "http://" (dùng RegularExpression)</li>
        <li>Nội dung không quá 255 ký tự (dùng RegularExpression)</li>
    </ul>
</div>

</body>
</html>