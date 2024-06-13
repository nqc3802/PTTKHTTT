package Controller;

import java.io.IOException;

import DAO.BillDetailDAO;
import DAO.GoodsDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addBillDetail")
public class BillDetailController extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		String slg = req.getParameter("sl");
		String dgia = req.getParameter("gia");
		int sl = 0, gia = 0;
		if (!slg.isEmpty()) {
		    sl = Integer.parseInt(slg);
		}
		if (!dgia.isEmpty()) {
		    gia = Integer.parseInt(dgia);
		}
		int tt = sl * gia;
		String note = req.getParameter("note");
		int id_mh = Integer.parseInt(req.getParameter("id_mh"));
		BillDetailDAO bddao = new BillDetailDAO();		
		try {
			bddao.detail(sl, gia, tt, note, 0, id_mh);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		GoodsDAO mhdao = new GoodsDAO();
		sl = sl + mhdao.getSl(id_mh);
		mhdao.updateMH(sl, gia, id_mh);
		req.getRequestDispatcher("detail.jsp?id_mh=" + id_mh).forward(req, resp);
	}
}
