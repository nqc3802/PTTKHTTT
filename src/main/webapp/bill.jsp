<%@page import="DAO.SupplierDAO"%>
<%@page import="DAO.GoodsDAO"%>
<%@page import="DAO.BillDetailDAO"%>
<%@page import="Model.BillDetail"%>
<%@page import="DAO.BillDAO"%>
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
    BillDAO bdao = new BillDAO();
    GoodsDAO mhdao = new GoodsDAO();
    BillDetailDAO bddao = new BillDetailDAO();
    SupplierDAO nccdao = new SupplierDAO();
    
    String ten = acc.getHo_va_dem() + " " + acc.getTen();
    String ncc = nccdao.getTenNCC(bdao.getIdNCCbyHDN(bdao.getIdHDN()));
    int tong = bdao.getTong(bdao.getIdHDN());
    List<BillDetail> bill = bddao.getBillDetail(bdao.getIdHDN());
%>
<!DOCTYPE html>

<head>
	<link rel="shortcut icon"
        href="https://static.vecteezy.com/system/resources/thumbnails/000/632/016/small/illust58-2414.jpg"
        type="image/x-icon">
	<link rel="stylesheet" href="bill.css">
    <title>Thông tin hóa đơn</title>
</head>

<body>
    <h1>Thông tin hóa đơn</h1>
    <table id="bill">
        <tr>
            <th>Tên mặt hàng</th>
            <th>Số lượng</th>
            <th>Đơn giá</th>
            <th>Thành tiền</th>
        </tr>
        <% for (BillDetail b : bill) { %>
            <tr>
                <td><%= mhdao.getTenMH(b.getId_mh()) %></td>
                <td><%= b.getSl() %></a></td>
                <td><%= b.getGia() %></td>
                <td><%= b.getTt() %></td>
            </tr>
        <% } %>
    </table>
    <div class="d">
		<label class="lb">Tên nhân viên: </label>
		<p class="pt"><%= ten %></p>
    </div>
    <div class="d">
		<label class="lb">Nhà cung cấp:</label>
		<p class="pt"><%= ncc %></p>
    </div>
    <div class="d">
		<label class="lb">Tổng hóa đơn: </label>
		<p class="pt"><%= tong %></p>
    </div>
    <div>
        <form action="home.jsp" id="back"></form>
        <button form="back" class="btn">OK</button>
    </div>
</body>