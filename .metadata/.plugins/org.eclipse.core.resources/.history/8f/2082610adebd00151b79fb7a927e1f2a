package week5.friday.bank.account;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import week5.friday.bank.Interest;
import week5.friday.bank.enums.OperationType;
import week5.friday.bank.exception.InsufficientAvailabilityException;
import week5.friday.bank.util.MessageConstants;

public class BankAccount implements Serializable {

	private static final long serialVersionUID = 1L;

	public class History implements Serializable {
		private static final long serialVersionUID = 8743656606584303715L;
		private OperationType operationType;
		private String message;
		private double addedOrTransferedMoney;
		private BankAccount transferAccount;

		public History(OperationType operationType, double money) {
			addedOrTransferedMoney = money;
			this.operationType = operationType;
			setMessage();
		}

		public History(BankAccount account, OperationType operationType,
				double money) {
			transferAccount = account;
			addedOrTransferedMoney = money;
			this.operationType = operationType;
			setMessage();
		}

		public String getMessage() {
			return message;
		}

		public void setMessage() {
			switch (operationType) {
			case ADD:
				message = addedOrTransferedMoney + " was added to your account";
				break;
			case WITHDRAW:
				message = addedOrTransferedMoney
						+ " was withdrawn from your account";
				break;
			case TRANSFER:
				message = addedOrTransferedMoney
						+ " was transfered from your account to this "
						+ transferAccount.getPerson();
				break;
			default:
				break;
			}
		}
	}

	private long ID;
	private String password;
	private double money;

	private Person person;
	private Interest interest;
	private History history;
	private List<History> accountHistory;

	public BankAccount(Person person) {
		this.person = person;
		accountHistory = new ArrayList<>(5);
		money = 0.0;
	}

	public Person getPerson() {
		return person;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Interest getInterest() {
		return interest;
	}

	public void setInterest(Interest interest) {
		this.interest = interest;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(OperationType type, double money) {
		switch (type) {
		case ADD:
			this.money += money;
			break;
		case WITHDRAW:
			this.money -= money;
			break;
		case TRANSFER:
			this.money -= money;
			break;
		default:
			break;
		}
	}

	public History getOperationHistory() {
		return history;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public void showHistory() {
		if (accountHistory.isEmpty()) {
			System.err.println("History is empty");
		} else {
			for (History history : accountHistory) {
				System.out.println(history.operationType + ":"
						+ history.getMessage());
			}
		}
	}

	public Double getBalance() throws InsufficientAvailabilityException {
		if (money > 0) {
			System.out.println(MessageConstants.BALANCE_MESSAGE + money);
			return money;
		}
		throw new InsufficientAvailabilityException("Zero balance" + money);
	}

	public void addToHistory(History history) {
		if (accountHistory.size() == 5) {
			accountHistory.remove(0);
		}
		accountHistory.add(history);
	}

	@Override
	public String toString() {
		return "BankAccount [ID=" + getID() + " " + getPerson() + " "
				+ interest + ", money=" + money + "]";
	}
}
