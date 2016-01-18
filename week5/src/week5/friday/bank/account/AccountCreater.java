package week5.friday.bank.account;

import javax.naming.InvalidNameException;

import week5.friday.bank.Interest;
import week5.friday.bank.ScannerClass;
import week5.friday.bank.enums.InterestType;
import week5.friday.bank.exception.AgeException;
import week5.friday.bank.storage.Bank;
import week5.friday.bank.util.MessageConstants;

public class AccountCreater {
	private ScannerClass sc;
	private Person person;

	public AccountCreater() {
		sc = new ScannerClass();
		person = new Person();
	}

	public boolean createAccount() throws InvalidNameException, AgeException {
		fillFirstName();
		fillLastName();
		fillAge();

		BankAccount account = new BankAccount(person);

		account.setID(Bank.lastAccountID + 1);
		Bank.lastAccountID++;

		System.out.println("PLease enter your password");
		account.setPassword(sc.nextLine());

		InterestType type = chooseInterestType();

		System.out.println("Choose size of the Interest");
		Interest interest = new Interest(account, type, sc.getDouble());
		account.setInterest(interest);
		Bank.accounts.put(account.getID(), account);
		Bank.saveAccounts();
		Bank.saveLastAccountId();
		System.err.println("Your id is: " + "\"" + account.getID() + "\"");
		return Bank.accounts.get(account.getID()) != null;

	}

	private void fillFirstName() throws InvalidNameException {
		System.out.println("Please enter your first name");
		person.setFirstName(sc.nextLine());
	}

	private void fillLastName() throws InvalidNameException {
		System.out.println("Please enter your last name");
		person.setLastName(sc.nextLine());
	}

	private void fillAge() throws AgeException {
		System.out.println("Please enter your age");
		person.setAge(Integer.parseInt(sc.nextLine()));
	}

	private InterestType chooseInterestType() {
		System.out.println(MessageConstants.INTEREST_NAVIGATION);
		switch (sc.getInt()) {
		case 1:
			return InterestType.SIMPLE;
		default:
			return InterestType.COMPLEX;
		}
	}
}
