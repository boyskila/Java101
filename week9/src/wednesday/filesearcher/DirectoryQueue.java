package wednesday.filesearcher;

import java.io.File;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class DirectoryQueue {

	private LinkedBlockingDeque<File> ll = new LinkedBlockingDeque<>();

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
