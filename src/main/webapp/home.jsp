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
%>
<!DOCTYPE html>
<html>

<head>
	<link rel="shortcut icon"
        href="https://static.vecteezy.com/system/resources/thumbnails/000/632/016/small/illust58-2414.jpg"
        type="image/x-icon">
    <link rel="stylesheet" href="home.css">
    <title>Home</title>
</head>

<body>
    <h1>Trang chủ của nhân viên kho</h1>
    <form action="NCC.jsp" id="nhap-form" style="display: none;">
    </form>
    <button form="nhap-form" class="nhap">Nhập hàng</button>
</body>

</html>