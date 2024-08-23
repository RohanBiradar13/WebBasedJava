package utils;

import java.sql.*;

import javax.servlet.http.Cookie;

public class DBUtils {
	private static Connection connection;

//add static method to return singleton connection instance
	public static Connection fetchDBCOnnection() throws ClassNotFoundException, SQLException {
		// load JDBC driver into method area of the JVM
		if (connection == null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// establish connection with DB
			String dbURL = "jdbc:mysql://localhost:3306/advjava?useSSL=false&allowPublicKeyRetrieval=true";
			connection = DriverManager.getConnection(dbURL, "root", "Brothers@96");
		}
		return connection;
	}
	//add a static method to close db connection
	public static void closeConnection() throws SQLException{
		if(connection != null)
			connection.close();
	}

}
