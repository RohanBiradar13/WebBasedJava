package dao;

import java.sql.SQLException;
import java.util.List;

import pojo.User;

public interface IUserDao {
//add a method declaration for getting user details
	List<User> getSelectedUserDetails(String role, String beginDate, String endDate) throws SQLException;

	String addUserDetails(User user) throws SQLException;

	String updateUserDetails(int regAmount, String newRole, int userId) throws SQLException;
    
	String deleteUserDetails(int userId) throws SQLException;
}
