package monday.thumbnailgenerator;

import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class BlockingQueue<BufferedImage> {
	private LinkedList<BufferedImage> queue = new LinkedList<>();
	private static final int LIMIT = 10;

	public synchronized void addLast(BufferedImage item) throws InterruptedException {
		while (isLimit()) {
			wait();
		}
		if (isEmpty()) {
			notifyAll();
		}
		this.queue.addLast(item);
	}

	public synchronized BufferedImage removeFirst() throws InterruptedException {
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
		// TODO Auto-generated method stub
		return queue.isEmpty();
	}

}
