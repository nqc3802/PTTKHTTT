
<%@page import="Model.Supplier"%>
<%@page import="DAO.SupplierDAO"%>
<%@ page import="Model.Staff" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="DAO.StaffLoginDAO" %>
<%@ page import="DAO.StaffLoginDAO" %>
<%@ page import="java.io.*,java.util.*,jakarta.servlet.*" %>
<%@ page import="jakarta.servlet.http.*" %>
<%
HttpSession sess = request.getSession();
    Staff acc = (Staff) session.getAttribute("acc");
    if (acc == null) {
        response.sendRedirect("login.jsp");
    }
    SupplierDAO nccdao = new SupplierDAO();
    List<Supplier> listNCC = nccdao.getListNCC();
%>
<%@ page pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>

<head>
	<link rel="shortcut icon"
        href="https://static.vecteezy.com/system/resources/thumbnails/000/632/016/small/illust58-2414.jpg"
        type="image/x-icon">
    <link rel="stylesheet" href="NCC.css">
    <title>Nhà cung cấp</title>
</head>

<body>
    <h1>Danh sách nhà cung cấp</h1>
    <div>
        <form action="home.jsp" id="home-form"></form>
        <button class="" form="home-form">Quay lại</button>
    </div>
    <div>
        <button class="addNCC" id="addNCC">Thêm nhà cung cấp</button>
    </div>
    <div id="NCCModal" class="modal">
        <div class="modal-content">
            <div>
                <span class="close">&times;</span>
                <h1>Thêm nhà cung cấp</h1>
            </div>
            <form action="addNCC" method="post">
                <div class="form-group">
                    <div>
                        <label for="name">Tên nhà cung cấp:</label>
                    </div>
                    <input type="text" id="name" name="name" placeholder="Tên nhà cung cấp" required>
                </div>
                <div class="form-group">
                    <div>
                        <label for="add">Địa chỉ nhà cung cấp:</label>
                    </div>
                    <input type="text" id="add" name="add" placeholder="Địa chỉ nhà cung cấp" required>
                </div>
                <div class="form-group">
                    <div>
                        <label for="nump">Số điện thoại:</label>
                    </div>
                    <input type="text" id="nump" name="nump" placeholder="Số điện thoại" required>
                </div>
                <div class="form-group">
                    <div>
                        <label for="email">Email:</label>
                    </div>
                    <input type="text" id="email" name="email" placeholder="Email" required>
                </div>
                <button type="submit" class="btn">Thêm nhà cung cấp</button>
            </form>
        </div>
    </div>
    <div>
        <input type="text" name="searchNCC" id="searchNCC" onkeyup="Search()">
    </div>
    <table id="listNCC">
        <tr>
            <th>Mã nhà cung cấp</th>
            <th>Tên nhà cung cấp</th>
            <th>Địa chỉ</th>
            <th>Số điện thoại</th>
            <th>Email</th>
        </tr>
        <%
        for (Supplier ncc : listNCC) {
        %>
            <tr>
                <td><%= ncc.getId() %></td>
                <td><a href="MH.jsp?id_ncc=<%= ncc.getId() %>"><%= ncc.getTen() %></a></td>
                <td><%= ncc.getDia_chi() %></td>
                <td><%= ncc.getSdt() %></td>
                <td><%= ncc.getEmail() %></td>
            </tr>
        <% } %>
    </table>
    <script src="NCC.js"></script>
</body>

</html>