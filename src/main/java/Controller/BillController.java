package Controller;

import java.io.IOException;
import java.sql.Date;

import DAO.BillDAO;
import Model.Staff;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/addBill")
public class BillController extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		HttpSession sess = req.getSession();
		Staff nv = (Staff) sess.getAttribute("acc");
		int id_nv = nv.getId();
		long millis = System.currentTimeMillis();
		Date date = new Date(millis);
		int id_mh = Integer.parseInt(req.getParameter("id_m"));
		BillDAO bdao = new BillDAO();
		int id_ncc = bdao.getIdNCC(id_mh);
		int id_hdn = bdao.getIdHDN();
		int tong = bdao.getTong(0);
		
		bdao.nhap(tong, date, id_nv, id_ncc);
		bdao.UpdateIdHDN(id_hdn + 1);
		req.getRequestDispatcher("bill.jsp").forward(req, resp);
	}
}
