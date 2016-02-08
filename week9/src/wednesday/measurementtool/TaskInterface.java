package wednesday.measurementtool;

public interface TaskInterface {
	public enum OperationType {
		PRODUCING, CONSUMING
	}

	String getName();

	String getCurrentThreadName();

	OperationType operationType();

}
