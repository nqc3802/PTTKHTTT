package Controller;

import java.io.IOException;

import DAO.StaffLoginDAO;
import Model.Staff;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/adminLogin")
public class StaffLoginController extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		String sdt = req.getParameter("admin-username");
		String pass = req.getParameter("admin-password");
		StaffLoginDAO adminlogindao = new StaffLoginDAO();
		Staff a = adminlogindao.login(sdt, pass);
		if (a == null) {
			req.setAttribute("mess", "Sai số điện thoại hoặc mật khẩu!");
			req.getRequestDispatcher("adminLogin.jsp").forward(req, resp);
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("acc", a);
			resp.sendRedirect("home.jsp");
		}
	}
}
