package Controller;

import java.io.IOException;
import java.util.List;

import DAO.SupplierDAO;
import Model.Supplier;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/NCC")
public class SupplierController extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		SupplierDAO nccdao = new SupplierDAO();
		List<Supplier> listncc = nccdao.getListNCC();
		req.setAttribute("listNCC", listncc);
		req.getRequestDispatcher("NCC.jsp").forward(req, resp);
	}
}
