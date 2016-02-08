package monday.parallelwebcrawler;

import java.util.concurrent.ConcurrentLinkedDeque;

public class URLStorage<T> {

	public ConcurrentLinkedDeque<String> storage = new ConcurrentLinkedDeque<String>();
	public ConcurrentLinkedDeque<String> visited = new ConcurrentLinkedDeque<String>();

	public URLStorage() {
	}

	public void addURL(String url) {
		synchronized (this) {
			notifyAll();
		}
		if (!visited.contains(url)) {
			storage.add(url);
			visited.add(url);
		}
	}

	public String getURL() {
		synchronized (this) {
			while (!hasURLs()) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		return storage.removeLast();

	}

	public boolean hasURLs() {
		return storage.size() > 0;
	}

	@Override
	public String toString() {
		return "URLStorage [storage=" + storage + "]";
	}

}
