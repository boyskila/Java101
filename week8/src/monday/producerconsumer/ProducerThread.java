package monday.producerconsumer;

import java.util.concurrent.atomic.AtomicInteger;

public class ProducerThread extends Thread {
	private final Factory<Integer> sharedQueue;

	public ProducerThread(Factory<Integer> sharedQueue) {
		this.sharedQueue = sharedQueue;
	}

	@Override
	public void run() {
		AtomicInteger counter = new AtomicInteger(0);
		while (true) {
			synchronized (sharedQueue) {
				while (sharedQueue.size() == sharedQueue.LIMIT) {
					try {
						System.out.println("Producer thread wait now");
						sharedQueue.wait();
					} catch (Exception ex) {
						ex.printStackTrace();
					}

				}
				int number = counter.incrementAndGet();
				System.out.println("Producer putting value: " + number);
				sharedQueue.put(number);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				sharedQueue.notifyAll();
			}
		}

	}

}
