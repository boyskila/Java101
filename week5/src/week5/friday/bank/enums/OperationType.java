package week5.friday.bank.enums;

public enum OperationType {
	ADD(" was added to your account"), WITHDRAW(" was withdrawn from your account"), TRANSFER(
			" was transfered from your account to this "), SHOW_HISTORY(), CHECK_BALANCE(), CALCULATE_AMOUNT(), LOGOUT();
	private final String message;

	OperationType() {
		message = "";
	}

	OperationType(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}