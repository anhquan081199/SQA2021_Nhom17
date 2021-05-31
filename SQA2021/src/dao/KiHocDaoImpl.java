package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.crypto.provider.AESParameters;
import com.sun.org.apache.bcel.internal.generic.RETURN;

import model.KiHoc;
import model.NganhHoc;

public class KiHocDaoImpl implements KiHocDao {

	@Override
	public List<KiHoc> search(String tenKiHoc) {
		List<KiHoc> kiHocs = new ArrayList<KiHoc>();
		Connection connection = JDBCConnection.getJDBConnection();
		String sql = "select * from kihoc where tenkihoc like ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "%" + tenKiHoc + "%");

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				KiHoc kiHoc = new KiHoc();
				kiHoc.setIdKiHoc(Integer.parseInt(rs.getString("idKiHoc")));
				kiHoc.setTenKiHoc(rs.getString("tenKiHoc"));
				kiHocs.add(kiHoc);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return kiHocs;
	}

	@Override
	public KiHoc search1(String tenKiHoc) {
		KiHoc kiHoc=new KiHoc();
		
		Connection connection = JDBCConnection.getJDBConnection();
		String sql = "Select *from kihoc where tenkihoc=?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, tenKiHoc);

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {				
				kiHoc.setIdKiHoc(Integer.parseInt(rs.getString("idKiHoc")));
				kiHoc.setTenKiHoc(rs.getString("tenKiHoc"));				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kiHoc;		
	}
}
