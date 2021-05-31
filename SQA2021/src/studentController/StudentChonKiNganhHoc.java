package studentController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.KiHocDao;
import dao.KiHocDaoImpl;
import dao.NganhHocDao;
import dao.NganhHocDaoImpl;
import model.KiHoc;
import model.NganhHoc;

@WebServlet(urlPatterns = "/student/chonkinganhhoc")
public class StudentChonKiNganhHoc extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		KiHocDao kiHocDao=new KiHocDaoImpl();
		List<KiHoc> kiHocs = kiHocDao.search("");
		
		req.setAttribute("kiHocs", kiHocs);
		
		NganhHocDao nganhHocDao=new NganhHocDaoImpl();
		List<NganhHoc> nganhHocs=nganhHocDao.search("");
		req.setAttribute("nganhHocs", nganhHocs);
		
		req.getRequestDispatcher("/student/view/user/chonkinganhhoc.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tenKiHoc= req.getParameter("kiHoc");
		String nganhHoc= req.getParameter("nganhHoc");
		
		KiHocDao kiHocDao=new KiHocDaoImpl();
		KiHoc kiHoc=kiHocDao.search1(tenKiHoc);
		
		NganhHocDao nganhHocDao=new NganhHocDaoImpl();
		NganhHoc nganhHoc1=nganhHocDao.search1(nganhHoc);
		
		HttpSession session = req.getSession();
		session.setAttribute("kiHoc", kiHoc);
		session.setAttribute("nganhHoc1", nganhHoc1);
		
		resp.sendRedirect("/SQA2021/student/danhsachmonhoc");
		
	}
}
