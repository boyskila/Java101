package monday.blockingqueue;

import java.util.LinkedList;

public class BlockingQueue<T> {
	private LinkedList<T> queue = new LinkedList<>();
	private final int LIMIT = 5;
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
			Thread.sleep(1000);
			return element;
		}
	}

	public boolean isEmpty() {
		return queue.isEmpty();
	}
}