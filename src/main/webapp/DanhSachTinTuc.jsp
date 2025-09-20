<%@ page import="java.util.List" %>
<%@ page import="com.example.tuan04.model.TinTuc" %>
<%@ page import="com.example.tuan04.model.DanhMuc" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bài 3 - Quản lý Tin tức</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        .header { background-color: #f0f0f0; padding: 10px; margin-bottom: 20px; }
        .news-item { border: 1px solid #ccc; margin: 10px 0; padding: 10px; }
        .form-section { background-color: #f9f9f9; padding: 15px; margin: 10px 0; }
        .message { color: green; font-weight: bold; }
        .error { color: red; font-weight: bold; }
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
        .nav-links { margin: 20px 0; }
        .nav-links a { margin-right: 15px; text-decoration: none; color: #007bff; }
        .nav-links a:hover { text-decoration: underline; }
    </style>
</head>
<body>

<div class="header">
    <h1>NEWS - Hệ thống Quản lý Tin tức Trực tuyến</h1>
    <div style="background-color: white; padding: 5px;">
        <strong>Danh sách tin tức | Thêm tin tức mới | Chức năng quản lý</strong>
    </div>
</div>

<div class="nav-links">
    <a href="${pageContext.request.contextPath}/bai3">Danh sách tin tức</a>
    <a href="${pageContext.request.contextPath}/addNews">Thêm tin tức mới</a>
    <a href="${pageContext.request.contextPath}/manage">Chức năng quản lý</a>
    <li>Quay ve <a href="${pageContext.request.contextPath}">Quay ve</a></li>
</div>

<h2>Họ tên sinh viên - Mã sinh viên - Lớp</h2>

<%-- Display messages --%>
<% if (request.getAttribute("message") != null) { %>
<div class="message"><%= request.getAttribute("message") %></div>
<% } %>

<% if (request.getAttribute("error") != null) { %>
<div class="error"><%= request.getAttribute("error") %></div>
<% } %>

<%-- Search form --%>
<div class="form-section">
    <h3>Tìm kiếm tin tức theo danh mục</h3>
    <form method="get" action="bai3">
        <input type="hidden" name="action" value="search"/>
        <label>Chọn danh mục:</label>
        <select name="danhMuc">
            <option value="">-- Tất cả danh mục --</option>
            <%
                List<DanhMuc> danhMucList = (List<DanhMuc>) request.getAttribute("danhSachDanhMuc");
                String selectedDanhMuc = (String) request.getAttribute("searchDanhMuc");
                if (danhMucList != null) {
                    for (DanhMuc dm : danhMucList) {
                        String selected = (selectedDanhMuc != null && selectedDanhMuc.equals(dm.getMadm())) ? "selected" : "";
            %>
            <option value="<%= dm.getMadm() %>" <%= selected %>><%= dm.getTendm() %></option>
            <%      }
            }
            %>
        </select>
        <button type="submit">Tìm kiếm</button>
    </form>
</div>

<%-- Add news form --%>
<div class="form-section">
    <h3>Thêm tin tức mới</h3>
    <form method="post" action="bai3">
        <input type="hidden" name="action" value="add"/>
        <table>
            <tr>
                <td>Mã tin tức:</td>
                <td><input type="text" name="maTT" required/></td>
            </tr>
            <tr>
                <td>Tiêu đề:</td>
                <td><input type="text" name="tieuDe" required/></td>
            </tr>
            <tr>
                <td>Liên kết:</td>
                <td><input type="url" name="lienKet" placeholder="http://..." required/></td>
            </tr>
            <tr>
                <td>Nội dung:</td>
                <td><textarea name="noiDung" maxlength="255" required></textarea></td>
            </tr>
            <tr>
                <td>Danh mục:</td>
                <td>
                    <select name="danhMuc" required>
                        <option value="">-- Chọn danh mục --</option>
                        <%
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
                <td colspan="2"><button type="submit">Thêm tin tức</button></td>
            </tr>
        </table>
    </form>
</div>

<%-- News list --%>
<div>
    <h3>Danh sách tin tức</h3>
    <%
        List<TinTuc> tinTucList = (List<TinTuc>) request.getAttribute("danhSachTinTuc");
        if (tinTucList == null || tinTucList.isEmpty()) {
    %>
    <p>Không có tin tức nào.</p>
    <%
    } else {
    %>
    <table>
        <thead>
        <tr>
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
            for (TinTuc tt : tinTucList) {
        %>
        <tr>
            <td><%= tt.getMaTT() %></td>
            <td><%= tt.getTieuDe() %></td>
            <td><a href="<%= tt.getLienKet() %>" target="_blank"><%= tt.getLienKet() %></a></td>
            <td><%= tt.getNoiDung() %></td>
            <td><%= tt.getThongTinDanhMuc() %></td>
            <td>
                <a href="bai3?action=delete&maTT=<%= tt.getMaTT() %>"
                   onclick="return confirm('Bạn có chắc muốn xóa?')">Xóa</a>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
    <%
        }
    %>
</div>

</body>
</html>