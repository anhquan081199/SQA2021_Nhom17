package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.NganhHoc;

public class NganhHocDaoImpl implements NganhHocDao {

	@Override
	public List<NganhHoc> search(String tenNganh) {
		List<NganhHoc> nganhHocs = new ArrayList<NganhHoc>();

		Connection connection = JDBCConnection.getJDBConnection();
		String sql = "select * from nganhhoc where ten like ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "%" + tenNganh + "%");

			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				NganhHoc nganhHoc=new NganhHoc();
				nganhHoc.setId(Integer.parseInt(rs.getString("id")));
				nganhHoc.setTen(rs.getString("ten"));
				nganhHocs.add(nganhHoc);
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nganhHocs;
	}

	@Override
	public NganhHoc search1(String tenNganh) {
		NganhHoc nganhHoc=new NganhHoc();
		Connection connection = JDBCConnection.getJDBConnection();
		String sql = "select * from nganhhoc where ten = ?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,tenNganh);

			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){				
				nganhHoc.setId(Integer.parseInt(rs.getString("id")));
				nganhHoc.setTen(rs.getString("ten"));				
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nganhHoc;
	}

}
