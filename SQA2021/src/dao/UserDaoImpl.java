package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UserDaoImpl implements UserDao {
	private User rowMap(ResultSet rs) throws SQLException {
		User user = new User();
		user.setIduser(rs.getString("iduser"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		user.setRole(rs.getString("role"));
		return user;
	}

	@Override
	public User getIdUser(String iduser) {
		User user = new User();

		Connection connection = JDBCConnection.getJDBConnection();
		String sql = "select *from user where iduser =?";

		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, iduser);
			
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next()) {
				user=rowMap(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
		
	}

}
