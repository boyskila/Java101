package monday.thumbnailcreator;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressWarnings("hiding")
public class ImageStorage<Image> {
	AtomicInteger count = new AtomicInteger(0);
	private LinkedList<Image> images = new LinkedList<>();
	private volatile boolean isEmpty;

	private static ImageStorage<?> instance = null;
	private static Object lock = new Object();

	private ImageStorage() {
	}

	public static ImageStorage<?> getInstance() {
		if (instance == null) {
			synchronized (lock) {
				if (instance == null)
					instance = new ImageStorage<>();
			}
		}
		return instance;
	}

	public void putImage(Image image) {
		synchronized (this) {
			images.addLast(image);
		}
	}

	public Image getImage() {
		return images.removeFirst();
	}

	public synchronized boolean isEmpty() {
		isEmpty = images.isEmpty();
		return isEmpty;
	}

	public synchronized int size() {
		return images.size();
	}

	public synchronized String storeImageAt() {
		return "/img" + count.incrementAndGet();
	}
}
