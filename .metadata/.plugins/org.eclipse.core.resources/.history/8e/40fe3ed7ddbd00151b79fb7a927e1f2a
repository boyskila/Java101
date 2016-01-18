package week5.friday.bank;

import javax.naming.InvalidNameException;

import week5.friday.bank.account.AccountAccessManager;
import week5.friday.bank.account.AccountOperationManager;
import week5.friday.bank.account.AccountSession;
import week5.friday.bank.account.BankAccount;
import week5.friday.bank.exception.AgeException;
import week5.friday.bank.storage.Bank;

public class OnlineBanking {

	public static void main(String[] args) {

		AccountAccessManager accessManager = new AccountAccessManager();

		BankAccount account = null;
		try {
			account = accessManager.createAccountOrLogin();
		} catch (AgeException ageException) {
			ageException.printStackTrace();
		} catch (InvalidNameException nameException) {
			nameException.printStackTrace();
		} catch (IllegalAccessException nameException) {
			nameException.printStackTrace();
		}

		AccountSession accountSession = new AccountSession(account);
		AccountOperationManager operationManager = new AccountOperationManager(accountSession);

		System.out.println("Hello " + account.getPerson().getFirstName() + " " + account.getPerson().getLastName());

		while (operationManager.menageOperations()) {
		}
		Bank.saveAccounts();
	}
}
