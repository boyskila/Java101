package monday.producerconsumer;

import monday.producerconsumer.Factory.ConsumingType;

public class ConsumerThread extends Thread {

	private final Factory<Integer> sharedQueue;
	private ConsumingType consumingType;

	public ConsumerThread(Factory<Integer> sharedQueue, ConsumingType consumingType) {
		this.sharedQueue = sharedQueue;
		this.consumingType = consumingType;

	}

	@Override
	public void run() {
		while (true) {
			synchronized (sharedQueue) {
				while (sharedQueue.isEmpty()) {
					System.out.println("Consumer thread now wait");
					try {
						sharedQueue.wait();
					} catch (Exception ex) {
						ex.printStackTrace();
					}

				}
				try {
					sharedQueue.poll(consumingType);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				sharedQueue.notifyAll();
			}
		}
	}
}
