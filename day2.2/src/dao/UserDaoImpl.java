package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static utils.DBUtils.fetchDBCOnnection;
import pojo.User;

public class UserDaoImpl implements IUserDao {
	// state
	private Connection cn;
	private PreparedStatement pst1, pst2, pst3,pst4;

	// constr will be invokes exactly once by the top layer(main(..)bases tester
	public UserDaoImpl() throws ClassNotFoundException, SQLException {
		// get connection from DBUtils
		cn = fetchDBCOnnection();
		// create pst1 : select
		String sql = "SELECT id, first_name, last_name, reg_amt, reg_date, role FROM users WHERE role = ? AND reg_date BETWEEN ? AND ?";
		pst1 = cn.prepareStatement(sql);
		// Corrected insert statement
		pst2 = cn.prepareStatement(
				"INSERT INTO users (first_name, last_name, email, password, reg_amt, reg_date, role) VALUES (?, ?, ?, ?, ?, ?, ?)");
		System.out.println("user dao created");
		// Update user details query
		pst3 = cn.prepareStatement("update users set reg_amt = ?, role=? where id =?");
		//delete user
		pst4 = cn.prepareStatement("delete from users where id = ?");
	}

	@Override
	public List<User> getSelectedUserDetails(String role, String beginDate, String endDate) throws SQLException {
		List<User> list = new ArrayList<User>();
		// set IN params
		pst1.setString(1, role);
		pst1.setDate(2, Date.valueOf(beginDate));
		pst1.setDate(3, Date.valueOf(endDate));
		// execute query : executeQuery() : RST
		try (ResultSet rst = pst1.executeQuery()) {
			while (rst.next())
				list.add(new User(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getInt(4), rst.getDate(5),
						rst.getString(6)));
		}
		return list;
	}

	@Override
	public String addUserDetails(User user) throws SQLException {
		// set IN params
		// first_name | last_name | email | password | reg_amt | reg_date | role
		pst2.setString(1, user.getFirstName());
		pst2.setString(2, user.getLastName());
		pst2.setString(3, user.getEmail());
		pst2.setString(4, user.getPassword());
		pst2.setInt(5, user.getRegAmount());
		pst2.setDate(6, user.getRegDate());
		pst2.setString(7, user.getRole());
		int updateCount = pst2.executeUpdate();// DML
		if (updateCount == 1)
			return "User details inserted....";
		return "Inserting user details failed!!!!";
	}

	@Override
	public String updateUserDetails(int regAmount, String newRole, int userId) throws SQLException {
		// id regAmount role
		pst3.setInt(1, regAmount);
		pst3.setString(2, newRole);
		pst3.setInt(3, userId);
		int updateCount = pst3.executeUpdate();
		if (updateCount >= 1)
			return "User details updated....";
		return "Updating user details failed!!!!";
	}

	public String deleteUserDetails(int userId) throws SQLException{
		pst4.setInt(1, userId);
		int updateCount = pst4.executeUpdate();
		if (updateCount >= 1)
			return "User details deleted....";
		return "Deleting user details failed!!!!";
	}
	// add a method to close DB resources
	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		if (pst2 != null)
			pst2.close();
		if (pst3 != null)
			pst3.close();
		if (pst4 != null)
			pst4.close();
		if (cn != null)
			cn.close();
		System.out.println("user dao cleaned up !");
	}

}
