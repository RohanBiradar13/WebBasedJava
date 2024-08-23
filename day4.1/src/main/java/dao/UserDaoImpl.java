package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static utils.DBUtils.fetchDBCOnnection;
import pojo.User;

public class UserDaoImpl implements IUserDao {
	private Connection cn;
	private PreparedStatement pst1;

	public UserDaoImpl() throws ClassNotFoundException, SQLException {
		// get cn
		cn = fetchDBCOnnection();
		pst1 = cn.prepareStatement("select * from users where email=? and password=?");
		System.out.println("User Dao Created");
	}

	@Override
	public User validateUser(String email, String pwd) throws SQLException {
		//set the in params
	pst1.setString(1, email);
	pst1.setString(2, pwd);
	try(ResultSet rst = pst1.executeQuery()){
		if(rst.next())
			return new User(rst.getInt(1), rst.getString(2),rst.getString(3), email, pwd,rst.getDouble(6) , rst.getDate(7), rst.getString(8));
				
	}
		return null;//Invalid login
	}
	public void cleanUp() throws SQLException {
		if(pst1 !=null)
			pst1.close();
		System.out.println("User Dao Cleaned Up");
	}

}
