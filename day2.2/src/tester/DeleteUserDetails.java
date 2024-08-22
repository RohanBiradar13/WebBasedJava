package tester;

import java.util.Scanner;

import dao.UserDaoImpl;

public class DeleteUserDetails {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter the user id ");
			int id = sc.nextInt();
			UserDaoImpl user = new UserDaoImpl();
			String message = user.deleteUserDetails(id);
			System.out.println(message);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
