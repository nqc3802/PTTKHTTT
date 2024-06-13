package Controller;

import java.io.IOException;

import DAO.SupplierDAO;
import Model.Supplier;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addNCC")
public class AddSupplierController extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		String ten = req.getParameter("name");
		String dia_chi = req.getParameter("add");
		String sdt = req.getParameter("nump");
		String email = req.getParameter("email");
		SupplierDAO nccdao = new SupplierDAO();
		Supplier ncc = nccdao.check(sdt, email);
		if(ncc == null) {
			nccdao.addNCC(ten, dia_chi, sdt, email);
			resp.sendRedirect("NCC.jsp");
		}
		else {
			resp.sendRedirect("home.jsp");
		}
	}
}
