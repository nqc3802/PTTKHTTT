package Controller;

import java.io.IOException;
import java.util.List;

import DAO.GoodsDAO;
import Model.Goods;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/MH")
public class GoodsController {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		GoodsDAO mhdao = new GoodsDAO();
		List<Goods> listmh = mhdao.getListMH();
		req.setAttribute("listMH", listmh);
		req.getRequestDispatcher("MH.jsp").forward(req, resp);
	}
}
