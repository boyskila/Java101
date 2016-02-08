package wednesday.filesearcher;

import java.io.File;
import java.util.concurrent.ConcurrentLinkedDeque;

public class DirectoryQueue {

	private ConcurrentLinkedDeque<File> ll = new ConcurrentLinkedDeque<>();

	public void addDir(File file) {
		ll.add(file);
	}

	public File getDir() {
		return ll.remove();
	}

	public boolean isEmpty() {
		return ll.isEmpty();
	}
}
