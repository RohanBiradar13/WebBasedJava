package tester;

import java.util.Scanner;

import dao.BankAccountDaoImpl;

public class TransferFunds {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			BankAccountDaoImpl acctDao = new BankAccountDaoImpl();
			System.out.println("Enter the src n dest accts nos n transfer amount");
			String message = acctDao.transferFunds(sc.nextInt(), sc.nextInt(), sc.nextDouble());
			System.out.println(message);
			acctDao.cleanUp();
					
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
