package monday.parallelwebcrawler;

import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.jsoup.nodes.Document;

public class HtmlDocumentStorage<T> implements Iterable<Document> {
	private ConcurrentLinkedDeque<Document> storage = new ConcurrentLinkedDeque<>();

	public HtmlDocumentStorage() {
	}

	public synchronized void addDocument(Document url) {
		synchronized (this) {
			notifyAll();
		}
		storage.addFirst(url);
	}

	public synchronized Document getDocument() {
		synchronized (this) {
			while (!hasDocuments()) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		Document doc = storage.removeLast();
		return doc;
	}

	public Deque<Document> getStorage() {
		return storage;
	}

	@Override
	public Iterator<Document> iterator() {
		return storage.iterator();
	}

	public boolean hasDocuments() {
		// isEmpty = storage.isEmpty();
		return storage.size() > 0;
	}
}
