package wednesday.measurementtool;

import java.util.concurrent.atomic.AtomicInteger;

public class ProducingTask implements TaskInterface, Runnable {
	private Memory memory;
	private AtomicInteger count = new AtomicInteger(100000);
	long time;

	public ProducingTask(Memory memory, long time) {
		this.time = time;
		this.memory = memory;
	}

	public void run() {
		putInts();
	}

	private void putInts() {
		int totalElementsToProduce = 0;
		while (count.getAndDecrement() > 0) {
			memory.put(new Integer(count.addAndGet(0)));
			System.out.println(new MeasurementTool(System.currentTimeMillis()
					- time, this, totalElementsToProduce));
		}

	}

	@Override
	public String getName() {
		String taskName = ProducingTask.class.getName();
		return taskName.substring(taskName.lastIndexOf(".") + 1);
	}

	@Override
	public String getCurrentThreadName() {
		return Thread.currentThread().getName();
	}

	@Override
	public OperationType operationType() {
		return OperationType.PRODUCING;
	}

}
