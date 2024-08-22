package utils;

import java.sql.*;

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

}
