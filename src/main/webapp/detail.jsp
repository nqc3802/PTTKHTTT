<%@page import="DAO.BillDAO"%>
<%@ page pageEncoding="utf-8"%>
<%@ page import="Model.Staff" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="DAO.StaffLoginDAO" %>
<%@ page import="java.io.*,java.util.*,jakarta.servlet.*" %>
<%@ page import="jakarta.servlet.http.*" %>
<%
    HttpSession sess = request.getSession();
    Staff acc = (Staff) sess.getAttribute("acc");
    if (acc == null) {
        response.sendRedirect("login.jsp");
    }
    String id = request.getParameter("id_mh");
    int id_mh = 0;
    try {
        id_mh = Integer.parseInt(id);
    } catch (NumberFormatException e) {
        e.printStackTrace();
    }
    BillDAO bdao = new BillDAO();
    int tong = bdao.getTong(0);
    int id_ncc = bdao.getIdNCC(id_mh);
%>
<!DOCTYPE html>

<head>
	<link rel="shortcut icon"
        href="https://static.vecteezy.com/system/resources/thumbnails/000/632/016/small/illust58-2414.jpg"
        type="image/x-icon">
        <link rel="stylesheet" href="detail.css">
    <title>Chi tiết</title>
</head>

<body>
	<h1>Nhập chi tiết đơn hàng</h1>
	<div>
        <button onclick="history.back()" class="" form="mh-form">Quay lại</button>
    </div>
    <form action="addBillDetail" method="post" onsubmit="return save(event)">
    	<div class="form-group">
	        <span>Số lượng</span>
	        <input type="text" name="sl" id="sl" placeholder="Nhập số lượng" required>
	    </div>
	    <div class="form-group">
	        <span>Đơn giá</span>
	        <input type="text" name="gia" id="gia" placeholder="Nhập đơn giá" required>
	    </div>
	    <div class="form-group">
	        <span>Note</span>
	        <input type="text" name="note" id="note" placeholder="Nhập ghi chú">
	    </div>
    	<input type="hidden" id="id_mh" name="id_mh" value="<%= id_mh %>">
	    <div>
	        <button type="submit" class="btn-r">Lưu</button>
	    </div>
    </form>
    <input type="hidden" id="id_ncc" value="<%= id_ncc %>">
	<form id="continueForm" name="continueForm">
    	<button type="button" onclick="con()" class="btn-g">Tiếp tục</button>
	</form>

    <form action="addBill" method="post" onsubmit="return sub(event)">
    	<input type="hidden" id="tong" value="<%= tong %>">
    	<input type="hidden" id="id_m" name="id_m" value="<%= id_mh %>">
    	<div>
	        <button type="submit" class="btn-b">Submit</button>
	    </div>
    </form>
    <script src="detail.js"></script>
</body>