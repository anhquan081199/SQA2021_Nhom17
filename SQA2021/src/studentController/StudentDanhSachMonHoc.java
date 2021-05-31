package studentController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LopHocPhanDao;
import dao.LopHocPhanDaoImpl;
import dao.MonHocDao;
import dao.MonHocDaoImpl;
import model.KiHoc;
import model.LopHocPhan;
import model.MonHoc;
import model.NganhHoc;
import model.User;

@WebServlet(urlPatterns = "/student/danhsachmonhoc")
public class StudentDanhSachMonHoc extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		KiHoc kiHoc=(KiHoc) session.getAttribute("kiHoc");
		NganhHoc nganhHoc=(NganhHoc) session.getAttribute("nganhHoc1");
		
		MonHocDao monHocDao=new MonHocDaoImpl();
		List<MonHoc> monHocs=monHocDao.search2(nganhHoc.getTen(),kiHoc.getTenKiHoc());
		
		req.setAttribute("monHocs", monHocs);
		req.getRequestDispatcher("/student/view/user/danhsachmonhoc.jsp").forward(req, resp);
		
	}
	
}
