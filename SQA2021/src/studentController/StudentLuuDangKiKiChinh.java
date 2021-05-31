package studentController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LopHocPhanDao;
import dao.LopHocPhanDaoImpl;
import model.LopHocPhan;

@WebServlet(urlPatterns = "/student/luudangkikichinh")
public class StudentLuuDangKiKiChinh extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idLopHocPhan=Integer.parseInt(req.getParameter("idLopHocPhan"));
		LopHocPhanDao lopHocPhanDao=new LopHocPhanDaoImpl();
		LopHocPhan lopHocPhan=lopHocPhanDao.get(idLopHocPhan);
		
		HttpSession session = req.getSession();
		session.setAttribute("lopHocPhan", lopHocPhan);
		
		req.setAttribute("lopHocPhan", lopHocPhan);
		
		
		req.getRequestDispatcher("/student/view//user/luudangkikichinh.jsp").forward(req, resp);
	}
}
