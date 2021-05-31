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
import model.LopHocPhan;

@WebServlet(urlPatterns = "/student/chonlophocphankichinh")
public class StudentChonLopHocPhanKiChinh extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idMonHoc = req.getParameter("idMonHoc");

		LopHocPhanDao lopHocPhanDao=new LopHocPhanDaoImpl();
		List<LopHocPhan> lopHocPhans = lopHocPhanDao.search1(idMonHoc);		
		
		
		//HttpSession session = req.getSession();
		//session.setAttribute("lopHocPhans", lopHocPhans);
		
		req.setAttribute("lopHocPhans", lopHocPhans);
		req.getRequestDispatcher("/student/view/user/lophocphankichinh.jsp").forward(req, resp);
	}
}
