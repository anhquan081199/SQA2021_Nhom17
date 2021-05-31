package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import dao.UserDaoImpl;
import model.User;

@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getParameter("error")!=null) {
			req.setAttribute("err", "Thông tin tài khoản mật khẩu sai và không được bỏ trống");
		}
		req.getRequestDispatcher("/student/view/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idUser= req.getParameter("iduser");
		String password=req.getParameter("password");
		
		UserDao userDao=new UserDaoImpl();
		User user= userDao.getIdUser(idUser);
		
		HttpSession session = req.getSession();
		session.setAttribute("user", user);
		
		if(user!=null && user.getPassword().equals(password)) {
			if(user.getRole().equals("admin")) {
				resp.sendRedirect("/SQA2021/admin/index");
			}else if (user.getRole().equals("student")) {
				resp.sendRedirect("/SQA2021/student/index");
			}else {
				resp.sendRedirect("/SQA2021/teacher/index");
			}
		}else {
			resp.sendRedirect("/SQA2021/login?error");
		}
	}
}
