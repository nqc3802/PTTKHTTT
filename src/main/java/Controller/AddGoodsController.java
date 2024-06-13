package Controller;

import java.io.IOException;

import DAO.GoodsDAO;
import Model.Goods;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addMH")
public class AddGoodsController extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		String ten = req.getParameter("name");
		int id_ncc = Integer.parseInt(req.getParameter("id_ncc"));
		String mota = req.getParameter("mota");
		GoodsDAO mhdao = new GoodsDAO();
		Goods mh = mhdao.check(ten);
		if(mh == null) {
			mhdao.addMH(ten, id_ncc, mota);
			resp.sendRedirect("MH.jsp?id_ncc=" + id_ncc);
		}
		else {
			resp.sendRedirect("home.jsp");
		}
	}
}
