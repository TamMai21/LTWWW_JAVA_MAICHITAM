<%@ page import="java.util.List" %>
<%@ page import="com.example.tuan04.model.TinTuc" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quản Lý Tin Tức</title>
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
        .delete-btn {
            background-color: #dc3545;
            color: white;
            padding: 5px 10px;
            text-decoration: none;
            border-radius: 3px;
        }
        .delete-btn:hover {
            background-color: #c82333;
        }
        .no-data {
            text-align: center;
            color: #666;
            font-style: italic;
            padding: 20px;
        }
    </style>
</head>
<body>

<div class="header">
    <h1>NEWS - Chức Năng Quản Lý</h1>
</div>

<div class="nav-links">
    <a href="${pageContext.request.contextPath}/bai3">Danh sách tin tức</a>
    <a href="${pageContext.request.contextPath}/addNews">Thêm tin tức mới</a>
    <a href="${pageContext.request.contextPath}/manage">Chức năng quản lý</a>
    <li>Quay ve <a href="${pageContext.request.contextPath}">Quay ve</a></li>
</div>

<h2>Họ tên sinh viên - Mã sinh viên - Lớp</h2>

<h3>Quản lý tin tức: thao tác hủy dữ liệu</h3>

<%
    List<TinTuc> tinTucList = (List<TinTuc>) request.getAttribute("danhSachTinTuc");
    if (tinTucList == null || tinTucList.isEmpty()) {
%>
<div class="no-data">
    <p>Hiện tại chưa có tin tức nào trong hệ thống.</p>
    <a href="${pageContext.request.contextPath}/addNews">Thêm tin tức đầu tiên</a>
</div>
<%
} else {
%>
<p><strong>Tổng số tin tức:</strong> <%= tinTucList.size() %></p>

<table>
    <thead>
    <tr>
        <th>STT</th>
        <th>Mã TT</th>
        <th>Tiêu đề</th>
        <th>Liên kết</th>
        <th>Nội dung</th>
        <th>Danh mục</th>
        <th>Thao tác</th>
    </tr>
    </thead>
    <tbody>
    <%
        int stt = 1;
        for (TinTuc tt : tinTucList) {
    %>
    <tr>
        <td><%= stt++ %></td>
        <td><%= tt.getMaTT() %></td>
        <td><%= tt.getTieuDe() %></td>
        <td>
            <a href="<%= tt.getLienKet() %>" target="_blank">
                <%= tt.getLienKet().length() > 50 ?
                        tt.getLienKet().substring(0, 50) + "..." :
                        tt.getLienKet() %>
            </a>
        </td>
        <td>
            <%= tt.getNoiDung().length() > 100 ?
                    tt.getNoiDung().substring(0, 100) + "..." :
                    tt.getNoiDung() %>
        </td>
        <td><%= tt.getThongTinDanhMuc() %></td>
        <td>
            <a href="manage?action=delete&maTT=<%= tt.getMaTT() %>"
               class="delete-btn"
               onclick="return confirm('Bạn có chắc chắn muốn xóa tin tức \\\'<%= tt.getTieuDe() %>\\\'?')">
                Hủy tin tức
            </a>
        </td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>

<div style="margin-top: 20px;">
    <p><strong>Lưu ý:</strong></p>
    <ul>
        <li>Khi chọn "Hủy tin tức", hệ thống sẽ xóa tin tức khỏi danh sách và kèm theo chức năng hỏi tin tức ra khỏi cơ sở dữ liệu</li>
        <li>Thao tác này không thể hoàn tác, vui lòng cân nhắc kỹ trước khi thực hiện</li>
    </ul>
</div>
<%
    }
%>

</body>
</html>