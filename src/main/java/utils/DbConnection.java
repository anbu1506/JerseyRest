package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DbConnection {
	private Connection conn ;
	private  DbConnection() {
		try {
			final String url="jdbc:mysql://localhost:3306/ANBARASU";
			final  String username="anbu";
			final String password="1234";
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=(Connection) DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error connecting to database...................................................!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static DbConnection dConn = new DbConnection();
	
	public static Connection getConnection() {
		return dConn.conn;
	}
}
