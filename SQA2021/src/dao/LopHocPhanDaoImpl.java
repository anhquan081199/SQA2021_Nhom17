package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.LopHocPhan;

public class LopHocPhanDaoImpl implements LopHocPhanDao {

	@Override
	public List<LopHocPhan> search(String tenMonHoc) {
		List<LopHocPhan> lopHocPhans = new ArrayList<LopHocPhan>();

		Connection connection = JDBCConnection.getJDBConnection();
		String sql = "select * from lophocphan where tenmonhoc like ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "%" + tenMonHoc + "%");

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				LopHocPhan lopHocPhan = new LopHocPhan();
				lopHocPhan.setIdLopHocPhan(rs.getInt("idlophocphan"));
				lopHocPhan.setIdMonHoc(rs.getString("idmonhoc"));
				lopHocPhan.setTenMonHoc(rs.getString("tenmonhoc"));
				lopHocPhan.setNhomMonHoc(rs.getString("nhommonhoc"));
				lopHocPhan.setSoTinChi(rs.getInt("sotinchi"));
				lopHocPhan.setMaLop(rs.getString("malop"));
				lopHocPhan.setThu(rs.getString("thu"));
				lopHocPhan.setKip(rs.getInt("kip"));
				lopHocPhan.setPhong(rs.getString("phong"));
				lopHocPhan.setTuan(rs.getString("tuan"));
				lopHocPhan.setSoLuong(rs.getInt("soluong"));

				lopHocPhans.add(lopHocPhan);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lopHocPhans;
	}
	
	@Override
	public List<LopHocPhan> search1(String idMonHoc) {
		List<LopHocPhan> lopHocPhans = new ArrayList<LopHocPhan>();

		Connection connection = JDBCConnection.getJDBConnection();
		String sql = "select * from lophocphan where idmonhoc = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, idMonHoc );

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				LopHocPhan lopHocPhan = new LopHocPhan();
				lopHocPhan.setIdLopHocPhan(rs.getInt("idlophocphan"));
				lopHocPhan.setIdMonHoc(rs.getString("idmonhoc"));
				lopHocPhan.setTenMonHoc(rs.getString("tenmonhoc"));
				lopHocPhan.setNhomMonHoc(rs.getString("nhommonhoc"));
				lopHocPhan.setSoTinChi(rs.getInt("sotinchi"));
				lopHocPhan.setMaLop(rs.getString("malop"));
				lopHocPhan.setThu(rs.getString("thu"));
				lopHocPhan.setKip(rs.getInt("kip"));
				lopHocPhan.setPhong(rs.getString("phong"));
				lopHocPhan.setTuan(rs.getString("tuan"));
				lopHocPhan.setSoLuong(rs.getInt("soluong"));

				lopHocPhans.add(lopHocPhan);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lopHocPhans;
	}

	@Override
	public LopHocPhan get(int id) {
		LopHocPhan lopHocPhan = new LopHocPhan();
		Connection connection = JDBCConnection.getJDBConnection();
		String sql = "Select *from lophocphan where idlophocphan=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				lopHocPhan.setIdLopHocPhan(rs.getInt("idlophocphan"));
				lopHocPhan.setIdMonHoc(rs.getString("idmonhoc"));
				lopHocPhan.setTenMonHoc(rs.getString("tenmonhoc"));
				lopHocPhan.setNhomMonHoc(rs.getString("nhommonhoc"));
				lopHocPhan.setSoTinChi(rs.getInt("sotinchi"));
				lopHocPhan.setMaLop(rs.getString("malop"));
				lopHocPhan.setThu(rs.getString("thu"));
				lopHocPhan.setKip(rs.getInt("kip"));
				lopHocPhan.setPhong(rs.getString("phong"));
				lopHocPhan.setTuan(rs.getString("tuan"));
				lopHocPhan.setSoLuong(rs.getInt("soluong"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lopHocPhan;
	}

	
	

}
