package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	public static Connection getJDBConnection() {
		final String url = "jdbc:mysql://localhost:3306/quanlysinhvien";
        final String user = "root";
        final String password = "081199";       

        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 try {
				return (Connection) DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
	}
	public static void main(String[] args) throws SQLException {
		Connection connection=getJDBConnection();
		if(connection!=null) {
			System.out.println("connect success");
		}else {
			System.out.println("connect fail");
		}
	}
}
