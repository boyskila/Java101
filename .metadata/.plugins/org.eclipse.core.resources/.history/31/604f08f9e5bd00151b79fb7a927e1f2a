package week5.friday.bank.account;

import week5.friday.bank.ScannerClass;
import week5.friday.bank.enums.OperationType;
import week5.friday.bank.exception.ExceededInterestException;
import week5.friday.bank.exception.InsufficientAvailabilityException;
import week5.friday.bank.storage.Bank;
import week5.friday.bank.util.MessageConstants;

public class AccountOperationManager {
	private ScannerClass sc = new ScannerClass();
	private AccountSession accountSession;

	public AccountOperationManager(AccountSession session) {
		accountSession = session;
	}

	public boolean menageOperations() {
		System.out.println(MessageConstants.ACCOUNT_PAGE_NAVIGATION);
		int number = sc.getInt();
		OperationType type = OperationType.values()[number - 1];
		try {
			switch (type) {
			case ADD:
				accountSession.add();
				break;
			case WITHDRAW:
				accountSession.withdraw();
				break;
			case TRANSFER:
				return accountSession.transfer();
			case SHOW_HISTORY:
				accountSession.showHistory();
				break;
			case CHECK_BALANCE:
				accountSession.showBalance();
				break;
			case CALCULATE_AMOUNT:
				accountSession.calculateAmount();
				break;
			case LOGOUT:
				return false;
			default:
				break;
			}
		} catch (InsufficientAvailabilityException | ExceededInterestException e) {
			Bank.saveAccounts();
			e.printStackTrace();
		}
		return true;
	}
}
