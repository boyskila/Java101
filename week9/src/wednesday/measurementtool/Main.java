package wednesday.measurementtool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		Memory memory = new Memory();
		ExecutorService ex = Executors.newFixedThreadPool(4);
		ProducingTask producer = null;
		ConsumingTask consumer = null;
		long start = System.currentTimeMillis();
		for (int i = 0; i < 3; i++) {
			producer = new ProducingTask(memory, start);
			ex.execute(producer);
		}
		for (int i = 0; i < 4; i++) {
			consumer = new ConsumingTask(memory, start);
			ex.execute(consumer);

		}
		ex.shutdown();
		while (!ex.isTerminated()) {

		}
		System.out.println(System.currentTimeMillis() - start);
		System.out.println(memory.size());
	}
}
