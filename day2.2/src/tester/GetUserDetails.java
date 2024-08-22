package tester;

import java.util.List;
import java.util.Scanner;

import dao.UserDaoImpl;


import pojo.User;

public class GetUserDetails {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			//create the instance of the dao layer
			UserDaoImpl userDao = new UserDaoImpl();
			System.out.println("Enter role, begin date(yy-MM-dd),end date");
			List<User> userList = userDao.getSelectedUserDetails(sc.next(), sc.next(), sc.next());
			System.out.println("User List");
			userList.forEach(System.out::println);
			userDao.cleanUp();
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
