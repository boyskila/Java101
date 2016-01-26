package monday.thumbnailgenerator;

import java.util.LinkedList;

public class BlockingQueue<T> {
	private LinkedList<T> queue = new LinkedList<>();
	private static final int LIMIT = 10;

	public synchronized void addLast(T item) throws InterruptedException {
		while (isLimit()) {
			wait();
		}
		if (isEmpty()) {
			notifyAll();
		}
		this.queue.addLast(item);
	}

	public synchronized T removeFirst() throws InterruptedException {
		while (isEmpty()) {
			wait();
		}
		if (isLimit()) {
			notifyAll();
		}

		return this.queue.removeFirst();
	}

	private boolean isLimit() {
		return this.queue.size() == LIMIT;
	}

	public boolean isEmpty() {
		return queue.isEmpty();
	}
}
