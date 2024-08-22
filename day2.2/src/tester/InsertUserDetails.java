package tester;

import java.sql.Date;
import java.util.Scanner;

import dao.UserDaoImpl;
import pojo.User;

public class InsertUserDetails {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// create the instance of the dao layer
			UserDaoImpl userDao = new UserDaoImpl();
			System.out.println(
					"Enter user details : firstName, lastName, email, password, regAmount, regDate(yy-MM-dd), role");
			String message = userDao.addUserDetails(new User(sc.next(), sc.next(), sc.next(), sc.next(), sc.nextInt(),
					Date.valueOf(sc.next()), sc.next()));
			System.out.println(message);
			userDao.cleanUp();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
