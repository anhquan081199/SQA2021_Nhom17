package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.KiHoc;
import model.MonHoc;

public class MonHocDaoImpl implements MonHocDao {

/*	@Override
	public List<MonHoc> search(String name) {
		List<MonHoc> monHocs = new ArrayList<MonHoc>();

		Connection connection = JDBCConnection.getJDBConnection();
		String sql = "select * from monhoc where nganhhoc=?,kihoc=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "%" + name + "%");

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				MonHoc mh = new MonHoc();
				mh.setIdMonHoc(rs.getString("idmonhoc"));
				mh.setTenMonHoc(rs.getString("tenmonhoc"));
				mh.setSoTinChi(rs.getInt("sotinchi"));
				mh.setNganhHoc(rs.getString("nganhhoc"));

				monHocs.add(mh);
			}

		} catch (SQLException e) {
			System.out.println("Loi search" + e);
		}
		return monHocs;
	}
	*/

	@Override
	public MonHoc search1(String idMonHoc) {
		MonHoc monHoc=new MonHoc();
		
		Connection connection = JDBCConnection.getJDBConnection();
		String sql = "select *from monhoc where idmonhoc like ?";
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1, idMonHoc);
			
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next()) {
				monHoc.setIdMonHoc(rs.getString("idMonHoc"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return monHoc;
	}

	@Override
	public List<MonHoc> search2(String nganhhoc, String kihoc) {
		List<MonHoc> monHocs = new ArrayList<MonHoc>();

		Connection connection = JDBCConnection.getJDBConnection();
		String sql = "select * from monhoc where nganhhoc = ? and tenkihoc= ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,nganhhoc );
			preparedStatement.setString(2,kihoc);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				MonHoc mh = new MonHoc();
				mh.setIdMonHoc(rs.getString("idmonhoc"));
				mh.setTenMonHoc(rs.getString("tenmonhoc"));
				mh.setSoTinChi(rs.getInt("sotinchi"));
				mh.setNganhHoc(rs.getString("nganhhoc"));

				monHocs.add(mh);
			}

		} catch (SQLException e) {
			System.out.println("Loi search" + e);
		}
		return monHocs;
	}

}
