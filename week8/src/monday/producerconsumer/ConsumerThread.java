package monday.producerconsumer;

import monday.producerconsumer.SyncValueStorage.ConsumingType;

public class ConsumerThread extends Thread {

	private final SyncValueStorage<Integer> sharedQueue;
	private ConsumingType consumingType;

	public ConsumerThread(SyncValueStorage<Integer> sharedQueue, ConsumingType consumingType) {
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
