package tester;

import java.util.Scanner;
import dao.UserDaoImpl;

public class UpdateUserDetails {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			UserDaoImpl userDao = new UserDaoImpl();
			System.out.println("Enter reg amount, role, user id");
			String message = userDao.updateUserDetails(sc.nextInt(), sc.next(), sc.nextInt());
			System.out.println(message);
			userDao.cleanUp();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
