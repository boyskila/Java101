package monday.producerconsumer;

import java.util.LinkedList;

public class SyncValueStorage<T> {
	public enum ConsumingType {
		GET_FIRST, GET_LAST;
	}

	private volatile LinkedList<T> blockingQueue = new LinkedList<>();
	public volatile int LIMIT = 10;

	public synchronized void put(T element) {
		blockingQueue.add(element);
	}

	public synchronized int size() {
		return blockingQueue.size();
	}

	public synchronized T poll(ConsumingType consumingType) throws InterruptedException {
		if (consumingType.equals(ConsumingType.GET_FIRST)) {
			System.out.println("Consumer taking value: from the head " + blockingQueue.peekFirst());
			return blockingQueue.pollFirst();
		} else if (consumingType.equals(ConsumingType.GET_LAST)) {
			System.out.println("Consumer taking value: from the tail " + blockingQueue.peekLast());
			return blockingQueue.pollLast();
		}
		return null;
	}

	public synchronized T pollLast() throws InterruptedException {
		return blockingQueue.removeLast();
	}

	protected boolean isEmpty() {
		return blockingQueue.isEmpty();
	}
}
