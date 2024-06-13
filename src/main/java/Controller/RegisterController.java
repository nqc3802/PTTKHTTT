package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import DAO.RegisterDAO;
import Model.Client;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterController extends HttpServlet {
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		String sdt = req.getParameter("phone");
		String pass = req.getParameter("password");
		String re_pass = req.getParameter("re_password");
		String ho_va_dem = req.getParameter("first-name");
		String ten = req.getParameter("last-name");
		String dia_chi = req.getParameter("address");
		if (!pass.equals(re_pass)) {
			resp.sendRedirect("login.jsp");
		} else {
			RegisterDAO registerdao = new RegisterDAO();
			Client a = registerdao.check(sdt);
			if (a == null) {
				registerdao.register(sdt, pass, ho_va_dem, ten, dia_chi);
				PrintWriter out = resp.getWriter();
			    out.println("<script type=\"text/javascript\">");
			    out.println("alert('Đăng ký thành công!');");
			    out.println("window.location.href='home.jsp';");
			    out.println("</script>");
			} else {
				req.setAttribute("mess", "Số điện thoại đã được sử dụng!");
				req.getRequestDispatcher("register.jsp").forward(req, resp);
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	@Override
	public String getServletInfo() {
		return "Short description";
	}
}
