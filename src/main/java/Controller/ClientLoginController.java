package Controller;

import java.io.IOException;

import DAO.ClientLoginDAO;
import Model.Client;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class ClientLoginController extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		String sdt = req.getParameter("username");
		String pass = req.getParameter("password");
		ClientLoginDAO logindao = new ClientLoginDAO();
		Client a = logindao.login(sdt, pass);
		if (a == null) {
			req.setAttribute("mess", "Sai số điện thoại hoặc mật khẩu!");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		} else {
			req.setAttribute("mess", "Được rồi!");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}
}
