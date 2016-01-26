package monday.producerconsumer;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Factory<T> {
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

	public static void main(String[] args) throws InterruptedException {
		try{
		Factory<Integer> bq = new Factory<>();
		Thread prod = new ProducerThread(bq);
		ExecutorService serv = Executors.newFixedThreadPool(2);
		Thread cons = new ConsumerThread(bq, ConsumingType.GET_FIRST);
		Thread cons2 = new ConsumerThread(bq, ConsumingType.GET_LAST);
		// serv.execute(cons);
		// serv.execute(cons2);
		prod.start();
		cons.start();
		cons2.start();

		prod.join();
		cons.join();
		cons2.join();
		}finally {
			
			System.out.println("OVER");
		}
	}

	protected boolean isEmpty() {
		return blockingQueue.isEmpty();
	}
}
