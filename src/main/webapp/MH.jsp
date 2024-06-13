<%@page import="Model.Goods"%>
<%@page import="DAO.GoodsDAO"%>
<%@ page pageEncoding="utf-8"%>
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
    String id = request.getParameter("id_ncc");
    int id_ncc = 0;
    try {
        id_ncc = Integer.parseInt(id);
    } catch (NumberFormatException e) {
        e.printStackTrace();
    }
    GoodsDAO nccdao = new GoodsDAO();
    List<Goods> listMH = nccdao.getListMHByNCC(id_ncc);
%>
<!DOCTYPE html>
<html>

<head>
	<link rel="shortcut icon"
        href="https://static.vecteezy.com/system/resources/thumbnails/000/632/016/small/illust58-2414.jpg"
        type="image/x-icon">
    <link rel="stylesheet" href="MH.css">
    <title>Mặt hàng</title>
</head>

<body>
    <h1>Danh sách mặt hàng</h1>
    <div>
        <form action="NCC.jsp" id="NCC-form"></form>
        <button class="" form="NCC-form">Quay lại</button>
    </div>
    <div>
        <button class="addMH" id="addMH">Thêm mặt hàng</button>
    </div>
    <div id="MHModal" class="modal">
        <div class="modal-content">
            <div>
                <span class="close">&times;</span>
                <h1>Thêm mặt hàng</h1>
            </div>
            <form action="addMH" method="post">
                <div class="form-group">
                    <div>
                        <label for="name">Tên mặt hàng:</label>
                    </div>
                    <input type="text" id="name" name="name" placeholder="Tên mặt hàng" required>
                </div>
                <div class="form-group">
                    <div>
                        <label for="mota">Mô tả:</label>
                    </div>
                    <input type="text" id="mota" name="mota" placeholder="Mô tả">
                </div>
                <input type="hidden" id="id_ncc" name="id_ncc" value="<%=id_ncc%>">
                <button type="submit" class="btn">Thêm mặt hàng</button>
            </form>
        </div>
    </div>
    <div>
        <input type="text" name="searchMH" id="searchMH" onkeyup="Search()">
    </div>
    <table id="listMH">
        <tr>
            <th>Mã mặt hàng</th>
            <th>Tên mặt hàng</th>
            <th>Mã nhà cung cấp</th>
            <th>Giá</th>
            <th>Số lượng</th>
            <th>Mô tả</th>
        </tr>
        <%
        for (Goods mh : listMH) {
        %>
            <tr>
                <td><%= mh.getId() %></td>
                <td><a href="detail.jsp?id_mh=<%= mh.getId() %>"><%= mh.getTen() %></a></td>
                <td><%= mh.getId_NCC() %></td>
                <td><%= mh.getDon_gia() %></td>
                <td><%= mh.getSo_luong() %></td>
                <td><%= mh.getMo_ta() %></td>
            </tr>
        <% } %>
    </table>
    <script src="MH.js"></script>
</body>

</html>