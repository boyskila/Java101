package friday.blockingqueue;

import java.util.LinkedList;

public class BlockingQueue<T> {
	private LinkedList<T> queue = new LinkedList<>();
	private final int LIMIT = 10;
	private Object lock = new Object();

	public void put(T element) {
		synchronized (lock) {
			System.out.println("Adding: " + element);
			queue.add(element);
			try {
				while (queue.size() == LIMIT) {
					lock.wait();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public T take() throws InterruptedException {
		synchronized (lock) {
			while (queue.isEmpty()) {
				lock.wait();
			}
			T element = queue.removeFirst();
			lock.notify();
			Thread.sleep(2000);
			return element;
		}
	}

	public static void main(String[] args) {
		BlockingQueue<Integer> bq = new BlockingQueue<>();
		Thread producer = new Thread(new Runnable() {
			@Override
			public void run() {
				int counter = 0;
				while (true) {
					bq.put(counter++);
				}

			}
		});

		Thread consumer = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						System.out.println("Taken: " + bq.take());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		});
		producer.start();
		consumer.start();

		try {
			producer.join();
			consumer.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
