package wednesday.measurementtool;

import java.util.concurrent.atomic.AtomicInteger;

public class ConsumingTask implements TaskInterface, Runnable {

	private Memory memory;
	private long time;
	AtomicInteger at = new AtomicInteger(100000);

	ConsumingTask(Memory memory, long time) {
		this.memory = memory;
		this.time = time;
	}

	public void run() {
		while (at.decrementAndGet() > 0) {
			int number = memory.get();
			System.out.println(new MeasurementTool(System.currentTimeMillis()
					- time, this, number));
		}
	}

	@Override
	public String getName() {
		String name = ConsumingTask.class.getName();
		return name.substring(name.lastIndexOf(".") + 1);
	}

	@Override
	public String getCurrentThreadName() {
		return Thread.currentThread().getName();
	}

	@Override
	public OperationType operationType() {
		return OperationType.CONSUMING;
	}
}
