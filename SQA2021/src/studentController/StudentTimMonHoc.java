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
import model.LopHocPhan;
import model.MonHoc;

@WebServlet(urlPatterns = "/student/timmonhoc")
public class StudentTimMonHoc extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("error") != null) {
			req.setAttribute("err1", " môn học bạn tìm không tồn tại - mời bạn nhập lại môn học");
		}
		req.getRequestDispatcher("/student/view//user/timmonhoc.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idMonHoc = req.getParameter("idMonHoc");
		
		MonHocDao monHocDao=new MonHocDaoImpl();
		MonHoc monHoc=monHocDao.search1(idMonHoc);

		LopHocPhanDao lopHocPhanDao = new LopHocPhanDaoImpl();
		List<LopHocPhan> lopHocPhans = lopHocPhanDao.search1(idMonHoc);

		HttpSession session = req.getSession();
		session.setAttribute("lopHocPhans", lopHocPhans);

		if (monHoc != null) {
			resp.sendRedirect("/SQA2021/student/chonlophocphankihe");
		} else {
			resp.sendRedirect("/SQA2021//student/timmonhoc?error");
		}
	}
}
