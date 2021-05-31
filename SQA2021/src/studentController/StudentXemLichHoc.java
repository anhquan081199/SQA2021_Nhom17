package studentController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LichHocDao;
import dao.LichHocDaoImpl;
import model.LichHoc;
import model.User;

@WebServlet(urlPatterns = "/student/xemlichhoc")
public class StudentXemLichHoc extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		HttpSession session = req.getSession();
		User user=(User) session.getAttribute("user");
		
		LichHocDao lichHocDao=new LichHocDaoImpl();
		List<LichHoc> lichHocs= lichHocDao.searchLichHoc(user.getIduser());
				
		req.setAttribute("lichHocs", lichHocs);
		
		req.getRequestDispatcher("/student/view/user/xemlichhoc.jsp").forward(req, resp);
	}
}
