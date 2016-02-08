package wednesday.filesearcher;

import java.io.File;
import java.nio.file.Path;
import java.util.concurrent.ConcurrentLinkedDeque;

public class FileQueue {
	private ConcurrentLinkedDeque<File> ll = new ConcurrentLinkedDeque<>();

	public boolean isEmpty() {
		return ll.isEmpty();
	}

	public File getFile() {

		return ll.remove();
	}

	public void addFile(File file) {

		ll.add(file);

	}

}
