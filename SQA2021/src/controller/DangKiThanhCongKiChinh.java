package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LichHocDao;
import dao.LichHocDaoImpl;
import model.KiHoc;
import model.LichHoc;
import model.LopHocPhan;
import model.User;

@WebServlet(urlPatterns = "/thanhcong1")
public class DangKiThanhCongKiChinh extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		KiHoc kiHoc=(KiHoc) session.getAttribute("kiHoc");
		User user =(User) session.getAttribute("user");
		LopHocPhan lopHocPhan=(LopHocPhan) session.getAttribute("lopHocPhan");
		
		LichHoc lichHoc=new LichHoc();
		lichHoc.setTenMonHoc(lopHocPhan.getTenMonHoc());
		lichHoc.setNhomMonHoc(lopHocPhan.getNhomMonHoc());
		lichHoc.setThu(lopHocPhan.getThu());
		lichHoc.setKip(lopHocPhan.getKip());
		lichHoc.setPhong(lopHocPhan.getPhong());
		lichHoc.setTuan(lopHocPhan.getTuan());
		lichHoc.setKiHoc(kiHoc.getTenKiHoc());
		lichHoc.setIdSinhVien(user.getIduser());
		LichHocDao lichHocDao=new LichHocDaoImpl();
		lichHocDao.add1(lichHoc);
		
		req.getRequestDispatcher("/student/view/thanhcongkichinh.jsp").forward(req, resp);
	}
}
