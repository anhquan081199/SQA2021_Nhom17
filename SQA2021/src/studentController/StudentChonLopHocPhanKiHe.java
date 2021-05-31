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

@WebServlet(urlPatterns = "/student/chonlophocphankihe")
public class StudentChonLopHocPhanKiHe extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		HttpSession session=req.getSession();		
		List<LopHocPhan> lopHocPhans=(List<LopHocPhan>) session.getAttribute("lopHocPhans");
		
		req.setAttribute("lopHocPhans", lopHocPhans);
		req.getRequestDispatcher("/student/view/user/lophocphan.jsp").forward(req, resp);
	}
}
