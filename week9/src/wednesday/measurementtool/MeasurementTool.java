package wednesday.measurementtool;

import wednesday.measurementtool.TaskInterface.OperationType;

public class MeasurementTool {
	private String threadName;
	private String taskName;
	private long milliseconds;
	@SuppressWarnings("unused")
	private TaskInterface task;
	private int el;
	private OperationType operationType;

	public MeasurementTool(long milliseconds, TaskInterface task) {
		super();
		this.threadName = task.getCurrentThreadName();
		taskName = task.getName();
		this.milliseconds = milliseconds;
		this.task = task;
		operationType = task.operationType();
	}

	public MeasurementTool(long milliseconds, TaskInterface task, int count) {
		super();
		this.threadName = task.getCurrentThreadName();
		taskName = task.getName();
		this.milliseconds = milliseconds;
		this.task = task;
		this.el = count;
		operationType = task.operationType();
	}

	@Override
	public String toString() {
		return threadName + " " + taskName + ", did task in: " + milliseconds
				+ " ms " + operationType + " " + el;
	}
}
