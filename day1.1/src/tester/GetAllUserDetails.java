package tester;

import static utils.DBUtils.fetchDBCOnnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;;

public class GetAllUserDetails {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Connection cn = fetchDBCOnnection();
		String sql = "select * from users";
		Statement st = cn.createStatement();
		ResultSet rst = st.executeQuery(sql);
		while (rst.next())
			System.out.println(("User id " + rst.getInt(1) + " first name " + rst.getString(2) + " last name "
					+ rst.getString(3) + " email " + rst.getString(4) + " password " + rst.getString(5) + " res amount "
					+ rst.getInt(6) + " res date " + rst.getDate(7)));

		cn.close();
		st.close();

	}

}
